package service;

import commons.RequestStrategy;
import daoImpl.AddressDaoImpl;
import daoImpl.UserInfoDaolmpl;
import model.Address_Info;
import model.BaseModel;
import model.User_Info;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Register implements RequestStrategy {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        if (validateRegistration(request, response)) {
            try {
                registerUser(request, response);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String email = request.getParameter("email");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String password = request.getParameter("password");
        String contact_no = request.getParameter("contact");
        String user_type = request.getParameter("user_type");
        BaseModel user = new User_Info();
        ((User_Info) user).setEmail(email);
        ((User_Info) user).setFirst_name(first_name);
        ((User_Info) user).setLast_name(last_name);
        ((User_Info) user).setPassword(password);
        ((User_Info) user).setContact_no(contact_no);
        ((User_Info) user).setAddress_id(-1);
        ((User_Info) user).setUser_type_id(user_type.equals("1") ? 1 : 2);
        if (user_type.equals("1")) {
            AddressDaoImpl addressDao = new AddressDaoImpl();
            BaseModel address = new Address_Info();
            ((Address_Info) address).setStreet(request.getParameter("street"));
            ((Address_Info) address).setCity(request.getParameter("city"));
            ((Address_Info) address).setState(request.getParameter("state"));
            ((Address_Info) address).setZip_code(request.getParameter("zip"));
            int address_id = addressDao.add(address);
            ((User_Info) user).setAddress_id(address_id);
        } else {
            ((User_Info) user).setAddress_id(0);
            ((User_Info) user).setJob_type(request.getParameter("job_type"));
            ((User_Info) user).setAgency_name(request.getParameter("agency"));
        }
        UserInfoDaolmpl userInfoDaolmpl = new UserInfoDaolmpl();
        boolean hasEmail = userInfoDaolmpl.hasProp(email);
        if (hasEmail) {
            request.setAttribute("error", "Already register. Please login");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        userInfoDaolmpl.add(user);
    }

    private boolean validateRegistration(HttpServletRequest request, HttpServletResponse response) {

        return true;
    }
}
