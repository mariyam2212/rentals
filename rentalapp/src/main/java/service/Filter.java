package service;

import commons.RequestStrategy;
import daoImpl.UnitInfoDaolmpl;
import model.Unit_Info;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Filter implements RequestStrategy {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String min_beds = request.getParameter("min_beds");
        String max_beds = request.getParameter("max_beds");
        String min_baths = request.getParameter("min_baths");
        String max_price = request.getParameter("max_price");
        String type = request.getParameter("type");
        String city = request.getParameter("city");
        String date = request.getParameter("date");
        if (type != null) {
            UnitInfoDaolmpl unitInfoDaolmpl = new UnitInfoDaolmpl();
            try {
                List<Unit_Info> lp = unitInfoDaolmpl.filterUnits(city, min_beds, max_beds, min_baths, max_price, type, date);
                request.setAttribute("units", lp);
                RequestDispatcher dispatcher = request.getRequestDispatcher("units.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
