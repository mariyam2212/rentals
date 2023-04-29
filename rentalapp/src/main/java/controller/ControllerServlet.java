package controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.PropertyDaoImpl;
import model.Property;
import postgres.SQLDriver;

/**
 * Servlet implementation class GetProperties
 */
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    SQLDriver sql = new SQLDriver();
    PropertyDaoImpl pdi = new PropertyDaoImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/back":
                goBack(request, response);
                break;
            case "/getProperties":
                getPropertiesByCity(request, response);
                break;
            default:
                break;
        }

    }

    private void getPropertiesByCity(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String city = request.getParameter("city");
        try {
            List<Property> lp = pdi.getPropertiesByCity(city);
            request.setAttribute("properties", lp);
            RequestDispatcher dispatcher = request.getRequestDispatcher("propertyList.jsp");
            dispatcher.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void goBack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
