<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create account</title>
<%@include file="Component/all_css.jsp" %>
</head>
<body style="background-color: #f0f1f3;">

	<div class="container">
		<div class="rows p-4">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
					<h3 class="text-center text-success">Sign up</h3>
						<form action="userdetails" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Name</label> <input type="text"
									class="form-control" id="exampleInputEmail1" name="name"
									aria-describedby="emailHelp">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email</label> <input type="text"
									class="form-control" id="exampleInputEmail1" name="email"
									aria-describedby="emailHelp">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Password</label> <input type="password"
									class="form-control" id="exampleInputEmail1" name="password"
									aria-describedby="emailHelp">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Contact</label> <input type="text"
									class="form-control" id="exampleInputEmail1" name="contact"
									aria-describedby="emailHelp">

							</div>
							
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Register</button>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>