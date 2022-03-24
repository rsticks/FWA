package edu.school21.cinema.servlets;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import edu.school21.cinema.User.UserService;
import edu.school21.cinema.User.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = {"/signup"}, name = "SignUp", description = "Sing Up")
public class SignUpServlet extends HttpServlet {

    private ApplicationContext springContext;
    private UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(SignUpServlet.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        springContext = (ApplicationContext) config.getServletContext().getAttribute("springContext");
        userService = springContext.getBean(UserService.class);
        LOGGER.warn("init done");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.warn("doGet signUp - Started");
        resp.setContentType("text/html");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/html/signup.html");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.warn("doPost signUp - Started");
        resp.setContentType("text/html");
        String phoneNum = req.getParameter("phoneNum");
        String password = req.getParameter("pass");
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        LOGGER.warn("phoneNum = " + phoneNum + "\n" +
                "pass = " + password);

        userService.saveUser(phoneNum, password, firstName, lastName);
    }
}
