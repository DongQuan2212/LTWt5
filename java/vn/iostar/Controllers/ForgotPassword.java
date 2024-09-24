package vn.iostar.Controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iostar.Models.UserModel;
import vn.iostar.dao.IUserDao;
import vn.iostar.dao.impl.UserDaoimpl;
import vn.iostar.services.IUserService;
import vn.iostar.services.impl.UserServiceimpl;

@WebServlet(urlPatterns = {"/forgotpassword"})
public class ForgotPassword extends HttpServlet {

	IUserDao Dao = new UserDaoimpl();
	IUserService service = new UserServiceimpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
		resp.sendRedirect(req.getContextPath() + "/admin");
		return;
		 }
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
		for (Cookie cookie : cookies) {
		 if (cookie.getName().equals("username")) {
		session = req.getSession(true);
		session.setAttribute("username", cookie.getValue());
		resp.sendRedirect(req.getContextPath() + "/admin");
		return;
		 }
		}
		}
		req.getRequestDispatcher("views/web/forgotpassword.jsp").forward(req, resp);
		}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String to = req.getParameter("to");
		String subject = req.getParameter("subject");
		String password = req.getParameter("password");
		UserModel b = Dao.checkExistEmail(email);
		
		UserModel mail = Dao.update(email);
		String alertMsg ="";
		if(b==null) {
			alertMsg =
					"Email không tồn tại";
					req.setAttribute("alert", alertMsg);
					req.getRequestDispatcher("views/web/forgotpassword.jsp").forward(req, resp);
		}
		else {
			if(mail!= null) {
				alertMsg =
						"Mật khẩu cập nhật thất bại";
						req.setAttribute("alert", alertMsg);	
						req.getRequestDispatcher("views/web/forgotpassword.jsp").forward(req, resp);
			}
			else {
				to = email;
				service.send(to, subject, password);
				alertMsg =
					"Mật khẩu của bạn đã được gửi";
					req.setAttribute("alert", alertMsg);	
					
			req.getRequestDispatcher("views/web/forgotpassword.jsp").forward(req, resp);
			}
			
		}
	}


	
		
	}

