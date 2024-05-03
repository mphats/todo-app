package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.TodoDAO;
import com.DB.DBContext;

@WebServlet("/todoitems") // or any other suitable URL

public class AddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String t_name = req.getParameter("t_name");
		String t_todo = req.getParameter("t_todo");
		String t_status = req.getParameter("t_status");
		
		TodoDAO dao = new TodoDAO(DBContext.getConn());
		boolean f = dao.addTodo(t_name, t_todo, t_status);
		HttpSession session=req.getSession();
		if(f) {
			session.setAttribute("sucMsg", "Todo added sucessfully");
			resp.sendRedirect("index.jsp");
		}else {
			session.setAttribute("errMsg", "Failed to add todo. Please try again later.");
			System.out.println("add_todo.jsp");
		}
		
	}
      
}
