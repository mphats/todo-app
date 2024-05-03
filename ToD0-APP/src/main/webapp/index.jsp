		<%@page import ="com.DB.DBContext"%>
		<%@page import = "com.entity.TodoDtls"%>
		<%@page import = "com.DAO.TodoDAO"%>
		<%@page import = "java.util.List"%>
		<%@page import = "java.sql.Connection"%>
		<%@ page language="java" contentType="text/html; charset=UTF-8"
		    pageEncoding="UTF-8"%>
		   <%
			    if(session.getAttribute("email") == null) {
			        response.sendRedirect("login.jsp");
			    }
			%>
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset="UTF-8">
		<title>index</title>
		<%@include file="Component/all_css.jsp" %>
		
		<style>
		      .bd-placeholder-img {
		        font-size: 1.125rem;
		        text-anchor: middle;
		        -webkit-user-select: none;
		        -moz-user-select: none;
		        user-select: none;
		      }
		
		      @media (min-width: 768px) {
		        .bd-placeholder-img-lg {
		          font-size: 3.5rem;
		        }
		      }
		    </style>
			<link rel="icon" href="data:,">
		</head>
		<body>
		 
		 <header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
		  <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">SOKOTECH</a>
		  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
		  <div class="navbar-nav">
		    <div class="nav-item text-nowrap">
		      <a class="nav-link px-3" href="#">Sign out</a>
		    </div>
		  </div>
		</header>
		
		<div class="container-fluid">
		  <div class="row">
		    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
		      <div class="position-sticky pt-3">
		        <ul class="nav flex-column">
		          <li class="nav-item">
		            <a class="nav-link active" aria-current="page" href="#">
		              <span data-feather="index.jsp"></span>
		              Dashboard
		            </a>
		          </li>
		          <li class="nav-item">
		            <a class="nav-link" href="add_todo.jsp">
		              <span data-feather="file"></span>
		              Add-Todo
		            </a>
		          </li>
		          <li class="nav-item">
		            <a class="nav-link" href="#">
		              <span data-feather="shopping-cart"></span>
		              Products
		            </a>
		          </li>
		          <li class="nav-item">
		            <a class="nav-link" href="#">
		              <span data-feather="users"></span>
		              Customers
		            </a>
		          </li>
		          <li class="nav-item">
		            <a class="nav-link" href="edit.jsp">
		              <span data-feather="bar-chart-2"></span>
		              Edit Todo
		            </a>
		          </li>
		          <li class="nav-item">
		            <a class="nav-link" href="#">
		              <span data-feather="layers"></span>
		              Integrations
		            </a>
		          </li>
		        </ul>
		
		        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
		          <span>Saved reports</span>
		          <a class="link-secondary" href="#" aria-label="Add a new report">
		            <span data-feather="plus-circle"></span>
		          </a>
		        </h6>
		        <ul class="nav flex-column mb-2">
		          <li class="nav-item">
		            <a class="nav-link" href="#">
		              <span data-feather="file-text"></span>
		              Current month
		            </a>
		          </li>
		          <li class="nav-item">
		            <a class="nav-link" href="#">
		              <span data-feather="file-text"></span>
		              Last quarter
		            </a>
		          </li>
		          <li class="nav-item">
		            <a class="nav-link" href="#">
		              <span data-feather="file-text"></span>
		              Social engagement
		            </a>
		          </li>
		          <li class="nav-item">
		            <a class="nav-link" href="#">
		              <span data-feather="file-text"></span>
		              Year-end sale
		            </a>
		          </li>
		        </ul>
		      </div>
		    </nav>
		    
		    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
		      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
		        <h1 class="h2">TODO-APP</h1>
		        <div class="btn-toolbar mb-2 mb-md-0">
		          <div class="btn-group me-2">
		            <button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
		            <button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
		          </div>
		          <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
		            <span data-feather="calendar"></span>
		            This week
		          </button>
		        </div>
		      </div>
		      <%	
				String sucMsg=(String)session.getAttribute("sucMsg");
				if(sucMsg!=null){%>
					<div class="alert alert-success" role="alert">
					<%=sucMsg %>
					</div>
				<%
				session.removeAttribute("suMsg");
				}
			%>
			<%
				String failedMsg=(String)session.getAttribute("failedMsg");
				if(failedMsg!=null){%>
					<div class="alert alert-danger" role="alert">
					<%=failedMsg %>
					</div>
				<%
				session.removeAttribute("failedMsg");
				}
			%>
		      <div class="table-responsive">
		        <table class="table table-striped table-sm">
		          <thead>
		            <tr>
		              <th scope="col">ID</th>
		              <th scope="col">Name</th>
		              <th scope="col">Todo</th>
		              <th scope="col">Status</th>
		              <th scope="col">Action</th>
		            </tr>
		          </thead>
		          <tbody>
		          <%
		          	TodoDAO dao = new TodoDAO(DBContext.getConn());
		          	List<TodoDtls> todo=dao.getTodo();
		          	for(TodoDtls t:todo){%>
		          		<tr>
			              <td><%=t.getId() %></td>
			              <td><%=t.getName() %></td>
			              <td><%=t.getTodo() %></td>
			              <td><%=t.getStatus() %></td>
			              <td>
				      		<a href="edit.jsp?id=<%=t.getId() %>" class="btn btn-sm btn-success">Edit</a>
				      		<a href="delete?id=<%=t.getId() %>" class="btn btn-sm btn-danger">Delete</a>
				      	</td>
		            	</tr>
		          	<%}
		          %>
		            
		          </tbody>
		        </table>
		      </div>
		    </main>
		  </div>
		</div>
		</body>
		</html>