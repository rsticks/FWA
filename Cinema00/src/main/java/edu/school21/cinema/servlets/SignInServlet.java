package edu.school21.cinema.servlets;

import edu.school21.cinema.User.User;
import edu.school21.cinema.User.service.UserService;
import edu.school21.cinema.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.naming.AuthenticationException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/signin", name = "SignIn", description = "Sing In")
public class SignInServlet extends HttpServlet {

    private UserService userService;
    private static final String SIGNIN_URL = "/WEB-INF/html/signIn.html";

    @Override
    public void init(ServletConfig config) throws ServletException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        userService = context.getBean(UserService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getRequestDispatcher(SIGNIN_URL).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String phoneNum = req.getParameter("phoneNum");
        String password = req.getParameter("password");
        try {
            User user = userService.signInUser(phoneNum, password);
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/profile");
        } catch (AuthenticationException e) {
            RequestDispatcher dispatcher = req.getRequestDispatcher(SIGNIN_URL);
            dispatcher.forward(req, resp);
        }
    }
}
