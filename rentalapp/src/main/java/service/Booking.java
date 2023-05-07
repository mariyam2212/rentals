package service;

import commons.RequestStrategy;
import daoImpl.AddressDaoImpl;
import daoImpl.BookingDaoImpl;
import daoImpl.TransactionDaolmpl;
import model.Address_Info;
import model.Booking_Info;
import model.Transaction_Info;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Booking implements RequestStrategy {

    HttpSession session = null;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        session = request.getSession();
        RequestDispatcher dispatcher = null;
        int unit_id;
        int rent;
        try {
            if (request.getServletPath().equalsIgnoreCase("/bookingPage")) {
                rent = Integer.parseInt(request.getParameter("rent"));
                unit_id = Integer.parseInt(request.getParameter("unit_id"));
                session.setAttribute("unit_id", unit_id);
                session.setAttribute("rent", rent);
                dispatcher = request.getRequestDispatcher("bookUnit.jsp");
                dispatcher.forward(request, response);
                return;
            } else if (request.getServletPath().equalsIgnoreCase("/addBookingInfo")) {
                updateBookingInfo(request, response);
            }
            List<Booking_Info> bookingInfoList = getBookingsForUser((Integer) session.getAttribute("user_id"));
            request.setAttribute("bookings", bookingInfoList);
            getAddressInfoForUser((Integer) session.getAttribute("user_id"));
            dispatcher = request.getRequestDispatcher("userProfile.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Address_Info getAddressInfoForUser(Integer userId) throws SQLException {
        AddressDaoImpl addressDao = new AddressDaoImpl();
        Address_Info addressInfo = new Address_Info();
        addressInfo = addressDao.getAddressInfoByUserId(userId);
        session.setAttribute("address_info", addressInfo);
        return addressInfo;
    }

    private List<Booking_Info> getBookingsForUser(int userId) throws SQLException {
        BookingDaoImpl bookingDao = new BookingDaoImpl();
        return bookingDao.getByUserId(userId);
    }

    private void updateBookingInfo(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int transaction_id = updateTransactionTable(request, response);
        if (transaction_id != 1) {
            updateBookingTable(request, response, transaction_id);
        }
    }

    private void updateBookingTable(HttpServletRequest request, HttpServletResponse response, int transaction_id) throws SQLException {
        BookingDaoImpl bookingDao = new BookingDaoImpl();
        Booking_Info bookingInfo = new Booking_Info();
        bookingInfo.setBooking_status("Pending");
        bookingInfo.setBooking_unit_id((Integer) request.getSession().getAttribute("unit_id"));
        bookingInfo.setRenter_id((Integer) request.getSession().getAttribute("user_id"));
        bookingInfo.setStart_date(request.getParameter("startDate"));
        bookingInfo.setEnd_date(request.getParameter("endDate"));
        bookingInfo.setTransaction_id(transaction_id);
        bookingDao.add(bookingInfo);
    }

    private int updateTransactionTable(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        TransactionDaolmpl transactionDaolmpl = new TransactionDaolmpl();
        Transaction_Info transactionInfo = new Transaction_Info();
        transactionInfo.setAddress_id((Integer) request.getSession().getAttribute("address_id"));
        transactionInfo.setCard_number(request.getParameter("cardNumber"));
        transactionInfo.setPayment_type_id(Integer.parseInt(request.getParameter("paymentMethod")));
        transactionInfo.setExpiry_date(request.getParameter("expiryDate"));
        transactionInfo.setCvv(Integer.parseInt(request.getParameter("cvv")));
        transactionInfo.setTxn_amount((Integer) request.getSession().getAttribute("rent"));
        transactionInfo.setAddress_id((Integer) request.getSession().getAttribute("address_id"));
        transactionInfo.setTxn_status("Success");
        return transactionDaolmpl.add(transactionInfo);
    }
}
