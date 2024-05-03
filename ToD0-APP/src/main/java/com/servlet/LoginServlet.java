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

@WebServlet("/index")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        RegisterDAO dao = new RegisterDAO(DBContext.getConn());
        try {
            boolean loggedIn = dao.loginIntoAccount(email, password);
            if (loggedIn) {
                session.setAttribute("sucMsg", "Login successfully");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            } else {
                session.setAttribute("errMsg", "Failed to login. Please check your credentials.");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            session.setAttribute("errMsg", "An error occurred while logging in. Please try again later.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } finally {
            dao.closeConnection();
        }
    }
}
