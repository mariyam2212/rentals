package daoImpl;

import dao.CommonDao;
import model.Address_Info;
import model.BaseModel;
import model.Property;
import postgres.SQLDriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl extends CommonDao {
    Connection conn = SQLDriver.getInstance().getConnection();

    @Override
    public int add(BaseModel prop) throws SQLException {
        Address_Info ai = (Address_Info) prop;
        String query = "INSERT INTO address_info (street, city, state, zip_code) "
                + "VALUES (?, ?, ?, ?) RETURNING address_id; ";
        int address_id = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, ai.getStreet());
            ps.setString(2, ai.getCity());
            ps.setString(3, ai.getState());
            ps.setString(4, ai.getZip_code());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                address_id = rs.getInt("address_id");
            }
            if (address_id != 0) {
                System.out.println("Address record created successfully");
                return address_id;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
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
    public BaseModel getByName(String name) throws SQLException {
        return null;
    }

    @Override
    public boolean hasProp(String filter) throws SQLException {
        return false;
    }


    public Address_Info getAddressInfoByUserId(Integer userId) throws SQLException {
        String query = "\n" +
                "Select street, city, state, zip_code from address_info join user_info on address_info.address_id = user_info.address_id where user_info.user_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();
        Address_Info addressInfo = new Address_Info();

        while (rs.next()) {
            addressInfo.setStreet(rs.getString("street"));
            addressInfo.setCity(rs.getString("city"));
            addressInfo.setState(rs.getString("state"));
            addressInfo.setZip_code(rs.getString("zip_code"));
        }
        return addressInfo;
    }
}
