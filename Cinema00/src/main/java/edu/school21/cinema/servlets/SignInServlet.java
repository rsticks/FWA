package edu.school21.cinema.servlets;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/signin"}, name = "SignIn", description = "Sing In")
public class SignInServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignInServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.warn("doGet signIn - Started");

        resp.setContentType("text/html");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/html/signIn.html");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String phoneNum = req.getParameter("phoneNum");
        String password = req.getParameter("pass");
        LOGGER.debug("phoneNum = " + phoneNum + "\n" +
        "pass = " + password);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
