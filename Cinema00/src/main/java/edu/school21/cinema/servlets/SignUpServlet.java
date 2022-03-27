package edu.school21.cinema.servlets;

import edu.school21.cinema.User.service.UserService;
import edu.school21.cinema.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DuplicateKeyException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/signup", name = "SignUp", description = "Sing Up")
public class SignUpServlet extends HttpServlet {
    private static final String SIGNUP_URL = "/WEB-INF/html/signup.html";
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        userService = context.getBean(UserService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getRequestDispatcher(SIGNUP_URL).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        String phoneNum = req.getParameter("phoneNum");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        try {
            userService.saveUser(phoneNum, password, firstName, lastName);
        } catch (DuplicateKeyException e) {
            req.getRequestDispatcher(SIGNUP_URL).forward(req, resp);
        }
        resp.sendRedirect("/signin");
    }
}
