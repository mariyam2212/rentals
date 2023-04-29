package daoImpl;

import dao.CommonDao;
import model.Address_Info;
import model.BaseModel;
import model.Property;
import postgres.SQLDriver;

import java.sql.*;
import java.util.List;

public class AddressDaoImpl implements CommonDao {

    static Connection conn = SQLDriver.getConnection();

    @Override
    public int add(BaseModel prop) throws SQLException {
        Address_Info ai = (Address_Info) prop;
        String query = "INSERT INTO address_info (address_id, street, city, country, zip_code) "
                + "VALUES (?, ?, ?, ?, ?); ";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, ai.getAddress_id());
            ps.setString(2, ai.getStreet());
            ps.setString(3, ai.getCity());
            ps.setString(4, ai.getCountry());
            ps.setString(5, ai.getZip_code());
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
        String query = "delete from address_info where address_id =?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public void update(BaseModel prop) throws SQLException {
        Address_Info ai = (Address_Info) prop;
        String query
                = "update address_info set street=?, "
                + " city= ?,country = ?, zip_code = ? where address_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, ai.getStreet());
        ps.setString(2, ai.getCity());
        ps.setString(3, ai.getCountry());
        ps.setString(4, ai.getZip_code());
        ps.setInt(5, ai.getAddress_id());
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
