package daoImpl;

import dao.CommonDao;
import model.BaseModel;
import model.Booking_Info;
import postgres.SQLDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDaoImpl extends CommonDao {

    Connection conn = SQLDriver.getInstance().getConnection();

    @Override
    public int add(BaseModel prop) throws SQLException {
        Booking_Info bi = (Booking_Info) prop;
        String query = "INSERT INTO booking_info (renter_id, start_date, end_date, booking_unit_id, booking_status, transaction_id) "
                + "VALUES (?, ?, ?, ?, ?, ?) RETURNING booking_id; ";
        int booking_id = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, bi.getRenter_id());
            ps.setDate(2, Date.valueOf(bi.getStart_date()));
            ps.setDate(3, Date.valueOf(bi.getEnd_date()));
            ps.setInt(4, bi.getBooking_unit_id());
            ps.setString(5, bi.getBooking_status());
            ps.setInt(6, bi.getTransaction_id());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                booking_id = rs.getInt("booking_id");
            }
            if (booking_id != 0) {
                System.out.println("Address record created successfully");
                return booking_id;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
        return 0;
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "delete from booking_info where booking_id  =?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public void update(BaseModel prop) throws SQLException {
        Booking_Info bi = (Booking_Info) prop;
        String query
                = "update booking_info set renter_id=?, "
                + " start_date= ?,end_date = ?, booking_unit_id = ?, booking_status = ?, transaction_id = ? where booking_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, bi.getRenter_id());
        ps.setDate(2, Date.valueOf(bi.getStart_date()));
        ps.setDate(3, Date.valueOf(bi.getEnd_date()));
        ps.setInt(4, bi.getBooking_unit_id());
        ps.setString(5, bi.getBooking_status());
        ps.setInt(6, bi.getTransaction_id());
        ps.setInt(7, bi.getBooking_id());
        ps.executeUpdate();
    }

    @Override
    public BaseModel getByName(String name) throws SQLException {
        return null;
    }

    @Override
    public boolean hasProp(String filter) throws SQLException {
        return false;
    }

    public List<Booking_Info> getByUserId(int userId) throws SQLException {
        String query = "select * from booking_info where renter_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();
        List<Booking_Info> ls = new ArrayList<>();

        while (rs.next()) {
            Booking_Info bookingInfo = new Booking_Info();
            bookingInfo.setBooking_status(rs.getString("booking_status"));
            bookingInfo.setBooking_unit_id(rs.getInt("booking_unit_id"));
            bookingInfo.setRenter_id(rs.getInt("renter_id"));
            bookingInfo.setStart_date(String.valueOf(rs.getDate("start_date")));
            bookingInfo.setEnd_date(String.valueOf(rs.getDate("end_date")));
            bookingInfo.setTransaction_id(rs.getInt("transaction_id"));
            ls.add(bookingInfo);
        }
        return ls;
    }
}
