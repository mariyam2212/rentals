package service;

import commons.RequestStrategy;
import daoImpl.PropertyDaoImpl;
import model.Property;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Properties implements RequestStrategy {
    PropertyDaoImpl pdi = new PropertyDaoImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String city = request.getParameter("city");
        try {
            List<Property> lp = pdi.getPropertiesByCity(city);
            request.setAttribute("properties", lp);
            RequestDispatcher dispatcher = request.getRequestDispatcher("propertyList.jsp");
            dispatcher.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException | ServletException e) {
            e.printStackTrace();
        }
    }

    private boolean validateLoginCredentials(HttpServletRequest request, HttpServletResponse response) {

        return false;
    }
}
