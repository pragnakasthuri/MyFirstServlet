package com.bridgelabz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(description = "Login servlet",
urlPatterns = {"/LoginServlet"},
initParams = {
        @WebInitParam(name="user", value="Pragna"),
        @WebInitParam(name="password", value="Bridglabz")
})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usr = req.getParameter("user");
        String pwd = req.getParameter("pwd");

        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");
        
        if (userID.equals(usr) && password.equals(pwd)) {
            req.setAttribute("user", usr);
            req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter writer = resp.getWriter();
            writer.println("<font color=red>Either username or password is wrong!</font>");
            writer.close();
        }
    }
}
