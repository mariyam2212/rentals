package controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.RequestStrategy;
import daoImpl.PropertyDaoImpl;
import model.Property;
import service.Back;
import service.Login;
import service.Properties;
import service.RequestContext;

/**
 * Servlet implementation class GetProperties
 */
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    RequestContext requestContext;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getServletPath();
        switch (action) {
            case "/login":
                doAction(new Login(), request, response);
                break;
            case "/back":
                doAction(new Back(), request, response);
                break;
            case "/getProperties":
                doAction(new Properties(), request, response);
                break;
            default:
                break;
        }

    }

    private void doAction(RequestStrategy requestStrategy, HttpServletRequest request, HttpServletResponse response) {
        requestContext = new RequestContext(requestStrategy, request, response);
        requestContext.execute();
    }
}
