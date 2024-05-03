<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add-ToDo</title>
<%@include file="Component/all_css.jsp" %>
</head>
<body style="background-color: #f0f1f3;">
<%@include file="Component/navbar.jsp" %>

	<div class="container">
		<div class="rows p-4">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
					<h3 class="text-center text-success">Add Todo</h3>
						<form action="todoitems" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Name</label> <input type="text"
									class="form-control" id="exampleInputEmail1" name="t_name"
									aria-describedby="emailHelp">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">TODO</label> <input type="text"
									class="form-control" id="exampleInputEmail1" name="t_todo"
									aria-describedby="emailHelp">

							</div>
							<div class="form-group">
								<label for="inputState">Status</label> <select id="inputState"
									class="form-control" name="t_status">
									<option selected>--Select--</option>
									<option value="Pending">Pending</option>
									<option value="Complete">Complete</option>
								</select>
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-primary">ADD</button>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>