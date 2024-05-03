<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <%@include file="Component/all_css.jsp" %>
</head>
<body style="background-color: #f0f1f3;">

    <div class="container">
        <div class="rows p-5">
            <div class="col-md-6 offset-md-3">
                <div class="card">
                    <div class="card-body">
                        <h3 class="text-center text-success">Log in</h3>
                        <form action="index" method="post">
                            <div class="form-group">
                                <label for="exampleInputEmail1">Email</label> <input type="text"
                                                                                          class="form-control" id="exampleInputEmail1" name="email"
                                                                                          aria-describedby="emailHelp">

                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Password</label> <input type="password"
                                                                                              class="form-control" id="exampleInputPassword1" name="password"
                                                                                              aria-describedby="passwordHelp">
                            </div>
                            <div class="form-group form-check">
                                <input type="checkbox" class="form-check-input" id="exampleCheck1" name="remember-me">
                                <label class="form-check-label" for="exampleCheck1">Remember me</label>
                            </div>
							<a class="text-center" href="Registration.jsp">
				              <span data-feather="file-text"></span>
				              Create account
				            </a>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary">Login</button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
