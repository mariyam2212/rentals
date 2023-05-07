package service;

import commons.RequestStrategy;
import daoImpl.UserInfoDaolmpl;
import model.User_Info;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class Login implements RequestStrategy {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            if (validateLoginCredentials(request, response)) {
                User_Info userInfo = (User_Info) request.getSession().getAttribute("user_info");
                if (userInfo.getUser_type_id() == 2) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("agentDashboard.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("getProperties.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean validateLoginCredentials(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String user_type = request.getParameter("option");
        UserInfoDaolmpl userInfoDaolmpl = new UserInfoDaolmpl();
        boolean hasEmail = userInfoDaolmpl.hasProp(email);
        if (!hasEmail) {
            request.setAttribute("error", "No user found. Please register");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return false;
        }
        User_Info byEmail = (User_Info) userInfoDaolmpl.getByName(email);
        if (byEmail.getPassword() != null && !byEmail.getPassword().equals(password)) {
            String errorMessage = "Invalid email or password";
            request.setAttribute("error", errorMessage);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return false;
        }
        HttpSession session = request.getSession();
        session.setAttribute("user_info", byEmail);
        session.setAttribute("user_id", byEmail.getUser_id());
        session.setAttribute("user_type_id", byEmail.getUser_type_id());
        session.setAttribute("first_name", byEmail.getFirst_name());
        session.setAttribute("address_id", byEmail.getAddress_id());
        return true;
    }
}
