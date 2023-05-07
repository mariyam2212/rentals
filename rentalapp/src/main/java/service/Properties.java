package service;

import commons.RequestStrategy;
import daoImpl.PropertyDaoImpl;
import daoImpl.UnitInfoDaolmpl;
import model.Property;
import model.Unit_Info;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Properties implements RequestStrategy {
    PropertyDaoImpl pdi = new PropertyDaoImpl();
    UnitInfoDaolmpl unitInfoDaolmpl = new UnitInfoDaolmpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String city = request.getParameter("city");
        RequestDispatcher dispatcher = null;
        HttpSession session = request.getSession();
        try {
            int selectionType = getBySelectionType(request);
            if (selectionType == 1) {
                List<Property> lp = pdi.getPropertiesByCity(city);
                request.setAttribute("properties", lp);
                session.setAttribute("city", city);
                dispatcher = request.getRequestDispatcher("propertyList.jsp");
            } else {
                List<Unit_Info> lp = unitInfoDaolmpl.getUnitsByCity(city);
                request.setAttribute("units", lp);
                session.setAttribute("city", city);
                dispatcher = request.getRequestDispatcher("units.jsp");
            }
            dispatcher.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException | ServletException e) {
            e.printStackTrace();
        }
    }

    private int getBySelectionType(HttpServletRequest request) {
        return request.getParameter("selection").equals("1") ? 1 : 2;
    }

    private boolean validateLoginCredentials(HttpServletRequest request, HttpServletResponse response) {

        return false;
    }
}
