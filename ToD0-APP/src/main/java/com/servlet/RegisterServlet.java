package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.RegisterDAO;
import com.DB.DBContext;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/userdetails")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String contact = req.getParameter("contact");
        
        RegisterDAO dao = new RegisterDAO(DBContext.getConn());
        boolean f = dao.addAccount(name, email, password,contact);
        HttpSession session=req.getSession();
        if(f) {
            session.setAttribute("sucMsg", "Account created sucessfully");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }else {
            session.setAttribute("errMsg", "Failed to create account. Please try again later.");
            req.getRequestDispatcher("add_todo.jsp").forward(req, resp);
        }
    }

}
