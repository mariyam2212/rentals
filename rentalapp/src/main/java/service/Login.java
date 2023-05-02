package service;

import commons.RequestStrategy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login implements RequestStrategy {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        if (validateLoginCredentials(request, response)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username.equals("admin") && password.equals("password123")) {
                // If the username and password are correct, redirect to the home page
                RequestDispatcher dispatcher = request.getRequestDispatcher("getProperties.jsp");
                try {
                    dispatcher.forward(request, response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private boolean validateLoginCredentials(HttpServletRequest request, HttpServletResponse response) {

        return true;
    }
}
