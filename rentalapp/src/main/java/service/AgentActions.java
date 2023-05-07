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

public class AgentActions implements RequestStrategy {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String path = request.getServletPath();
        int action;
        RequestDispatcher requestDispatcher = null;
        switch (path) {
            case "/addPropertyRedirect":
                try {
                    requestDispatcher = request.getRequestDispatcher("addProperty.jsp");
                    requestDispatcher.forward(request, response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/addProperty":
                try {
                    action = addProperty(request, response);
                    requestDispatcher = request.getRequestDispatcher("agentDashboard.jsp");
                    requestDispatcher.forward(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private int addProperty(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        PropertyDaoImpl propertyDao = new PropertyDaoImpl();
        Property property = new Property();
        property.setProperty_name(request.getParameter("property_name"));
        property.setTotal_units(Integer.parseInt(request.getParameter("total_units")));
        property.setAddress(request.getParameter("address"));
        property.setStreet_name(request.getParameter("street_name"));
        property.setState(request.getParameter("state"));
        property.setCity(request.getParameter("city"));
        property.setCountry(request.getParameter("country"));
        property.setZip_code(request.getParameter("zip_code"));
        property.setTotal_floors(Integer.parseInt(request.getParameter("total_floors")));
        property.setHas_parking(Boolean.valueOf(request.getParameter("has_parking")));
        property.setHas_laundry(Boolean.valueOf(request.getParameter("has_laundry")));
        property.setIs_pet_friendly(Boolean.valueOf(request.getParameter("is_pet_friendly")));
        int addedPropertyId = propertyDao.add(property);
        return addedPropertyId;
    }
}
