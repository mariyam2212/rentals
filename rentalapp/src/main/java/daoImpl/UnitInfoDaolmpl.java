package daoImpl;

import dao.CommonDao;
import model.BaseModel;
import model.Property;
import model.Unit_Info;
import postgres.SQLDriver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UnitInfoDaolmpl implements CommonDao {
    static Connection conn = SQLDriver.getConnection();

    @Override
    public int add(BaseModel prop) throws SQLException {
        Unit_Info ai = (Unit_Info) prop;
        String query = "INSERT INTO unit_info (unit_id, unit_title, unit_type, property_id, floor_number, number_of_beds, number_of_bathrooms, number_of_balcony, square_footage, availability_date, rent_amount) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, ai.getUnit_id());
            ps.setString(2, ai.getUnit_title());
            ps.setString(3, ai.getUnit_type());
            ps.setInt(4, ai.getProperty_id());
            ps.setInt(5, ai.getFloor_number());
            ps.setInt(6, ai.getNumber_of_beds());
            ps.setInt(7, ai.getNumber_of_bathrooms());
            ps.setInt(8, ai.getNumber_of_balcony());
            ps.setInt(9, ai.getSquare_footage());
            ps.setDate(10, (Date) ai.getAvailability_date());
            ps.setInt(11, ai.getRent_amount());
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
        String query = "delete from unit_info where unit_id =?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public void update(BaseModel prop) throws SQLException {
        Unit_Info ai = (Unit_Info) prop;
        String query
                = "update unit_info set unit_title=?, "
                + " unit_type= ?, property_id = ?, floor_number = ?, number_of_beds= ?,number_of_bathrooms = ?, number_of_balcony = ?, square_footage = ?, availability_date = ?, rent_amount= ? where unit_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, ai.getUnit_title());
        ps.setString(2, ai.getUnit_type());
        ps.setInt(3, ai.getProperty_id());
        ps.setInt(4, ai.getFloor_number());
        ps.setInt(5, ai.getNumber_of_beds());
        ps.setInt(6, ai.getNumber_of_bathrooms());
        ps.setInt(7, ai.getNumber_of_balcony());
        ps.setInt(8, ai.getSquare_footage());
        ps.setDate(9, (Date) ai.getAvailability_date());
        ps.setInt(10, ai.getRent_amount());
        ps.setInt(11, ai.getUnit_id());
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
