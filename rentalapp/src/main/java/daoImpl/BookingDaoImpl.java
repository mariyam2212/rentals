package daoImpl;

import dao.CommonDao;
import model.BaseModel;
import model.Booking_Info;
import model.Property;
import postgres.SQLDriver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BookingDaoImpl implements CommonDao {

    static Connection conn = SQLDriver.getConnection();

    @Override
    public int add(BaseModel prop) throws SQLException {
        Booking_Info bi = (Booking_Info) prop;
        String query = "INSERT INTO booking_info (booking_id, renter_id, start_date, end_date, booking_unit_id, booking_status, transaction_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?); ";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, bi.getBooking_id());
            ps.setInt(2, bi.getRenter_id());
            ps.setDate(3, (Date) bi.getStart_date());
            ps.setDate(4, (Date) bi.getEnd_date());
            ps.setInt(5, bi.getBooking_unit_id());
            ps.setString(6, bi.getBooking_status());
            ps.setInt(7, bi.getTransaction_id());
            int n = ps.executeUpdate();
            conn.commit();
            System.out.println("Address record created successfully");
            return n;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
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
        ps.setDate(2, (Date) bi.getStart_date());
        ps.setDate(3, (Date) bi.getEnd_date());
        ps.setInt(4, bi.getBooking_unit_id());
        ps.setString(5, bi.getBooking_status());
        ps.setInt(6, bi.getTransaction_id());
        ps.setInt(7, bi.getBooking_id());
        ps.executeUpdate();
    }

    @Override
    public Property getByName(String name) throws SQLException {
        return null;
    }

    @Override
    public List<Property> getByFilter(String filter) throws SQLException {
        return null;
    }
}
