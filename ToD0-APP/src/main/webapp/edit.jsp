<%@page import = "com.DB.DBContext"%>
<%@page import = "com.entity.TodoDtls"%>
<%@page import = "com.DAO.TodoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit-ToDo</title>
<%@include file="Component/all_css.jsp" %>
</head>
<body style="background-color: #f0f1f3;">
<%@include file="Component/navbar.jsp" %>

	<div class="container">
		<div class="rows p-4">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
					<h3 class="text-center text-success">Edit Todo</h3>
					<%int id = Integer.parseInt(request.getParameter("id"));
					TodoDAO dao=new TodoDAO(DBContext.getConn());
					TodoDtls t=dao.getTodoById(id);
					
					%>
						<form action="update" method="post">
						<input type="hidden" value="<%=t.getId() %>" name="id">
							<div class="form-group">
								<label for="exampleInputEmail1">Name</label> <input type="text"
									class="form-control" id="exampleInputEmail1" name="t_name" value="<%=t.getName()%>"
									aria-describedby="emailHelp">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">TODO</label> <input type="text"
									class="form-control" id="exampleInputEmail1" name="t_todo" value="<%=t.getTodo()%>"
									aria-describedby="emailHelp">

							</div>
							<div class="form-group">
								<label for="inputState">Status</label> <select id="inputState"
									class="form-control" name="t_status">
									<%if("Pending".equals(t.getStatus())){%>
										<option value="Pending">Pending</option>
										<option value="Complete">Complete</option>
									<%}else{%>
										<option value="Complete">Complete</option>
										<option value="Pending">Pending</option>
									<%}
										%>
									
								</select>
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-primary">Update</button>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>