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
import com.entity.TodoDtls;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
		/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(req.getParameter("id"));
		String t_name = req.getParameter("t_name");
		String t_todo = req.getParameter("t_todo");
		String t_status = req.getParameter("t_status");
		
		TodoDAO dao = new TodoDAO(DBContext.getConn());
		TodoDtls t=new TodoDtls();
		t.setId(id);
		t.setName(t_name);
		t.setTodo(t_todo);
		t.setStatus(t_status);
		boolean f=dao.updateTodo(t);
		HttpSession session=req.getSession();
		if(f) {
			session.setAttribute("sucMsg", "Todo updated sucessfully");
			resp.sendRedirect("index.jsp");
		}else {
			session.setAttribute("errMsg", "Failed to update todo. Please try again later.");
			System.out.println("edit.jsp");
		}
	}

}
