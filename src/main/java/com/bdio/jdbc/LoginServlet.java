package com.bdio.jdbc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class LoginServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    private UserDbUtil userdb  = new UserDbUtil();


    public LoginServlet(){
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.getWriter().append("Served at: ").append(request.getContextPath());
        RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
        dispatcher.forward(request,response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        if (userdb.loginUser(username,password)){
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Redirigez vers la page de bienvenue
            response.sendRedirect("welcome.jsp");
        }else {
            request.setAttribute("error", "Nom d'utilisateur ou mot de passe incorrect");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
            dispatcher.forward(request, response);
        }



    }


}
