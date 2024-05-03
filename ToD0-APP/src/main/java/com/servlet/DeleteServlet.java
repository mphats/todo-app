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

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest, HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int todoIdToDelete = Integer.parseInt(req.getParameter("id")); 
		TodoDAO dao = new TodoDAO(DBContext.getConn());
		boolean success = dao.deleteTodo(todoIdToDelete);
		HttpSession session=req.getSession();
		if(success) {
			session.setAttribute("sucMsg", "Todo deleted sucessfully");
			resp.sendRedirect("index.jsp");
		}else {
			session.setAttribute("errMsg", "Something went wrong with server.");
			System.out.println("edit.jsp");
		}

	}

}
