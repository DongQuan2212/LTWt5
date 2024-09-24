<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>


<!-- BEGIN CONTENT -->
<div class="col-md-9 col-sm-9">
	<h1>Create an account</h1>
	<div class="content-form-page">
		<div class="row">
			<div class="col-md-7 col-sm-7">
				<form action="register" method="post" class="form-horizontal"
					role="form">
					<c:if test="${alert !=null}">
						<h3 class="alert alertdanger">${alert}</h3>
					</c:if>
					<fieldset>
						<legend>Your personal details</legend>
						<div class="form-group">
							<label for="fullname" class="col-lg-4 control-label">Fullname
								<span class="require">*</span>
							</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="fullname"
									name="fullname">
							</div>
						</div>
						<div class="form-group">
							<label for="username" class="col-lg-4 control-label">Username
								<span class="require">*</span>
							</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="fusername"
									name="username">
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="col-lg-4 control-label">Email <span
								class="require">*</span></label>
							<div class="col-lg-8">
								<input type="text" name="email" class="form-control" id="email">
							</div>
						</div>
					</fieldset>
					<fieldset>
						<legend>Your password</legend>
						<div class="form-group">
							<label for="password" class="col-lg-4 control-label">Password
								<span class="require">*</span>
							</label>
							<div class="col-lg-8">
								<input type="password" name="password" class="form-control"
									id="password">
							</div>
						</div>
						<div class="form-group">
							<label for="rp" class="col-lg-4 control-label">Confirm
								password <span class="require">*</span>
							</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="rp" name="rp">
							</div>
						</div>
					</fieldset>

					<div class="row">
						<div
							class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
							<button type="submit" class="btn btn-primary">Create an
								account</button>
						</div>
					</div>
					<div class="row">
						
					</div>
				</form>
				<form action="login" class="row">
							<div
								class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
								<button type="submit">Cancel</button>
							</div>
							</form>
			</div>
		</div>
	</div>
</div>
<!-- END CONTENT -->



