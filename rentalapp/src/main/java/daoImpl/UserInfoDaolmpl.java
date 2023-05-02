package daoImpl;

import dao.CommonDao;
import model.Address_Info;
import model.BaseModel;
import model.Property;
import model.User_Info;
import postgres.SQLDriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserInfoDaolmpl implements CommonDao {
    static Connection conn = SQLDriver.getConnection();

    @Override
    public int add(BaseModel prop) throws SQLException {
         User_Info ai = (User_Info) prop;
        String query = "INSERT INTO user_info ( user_id, email, user_type_id, first_name, last_name, address_id, contact_no, job_type, agency_name) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?); ";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, ai.getUser_id());
            ps.setString(2, ai.getEmail());
            ps.setInt(3, ai.getUser_type_id());
            ps.setString(4, ai.getFirst_name());
            ps.setString(5, ai.getLast_name());
            ps.setInt(6, ai.getAddress_id());
            ps.setString(7, ai.getContact_no());
            ps.setString(8, ai.getJob_type());
            ps.setString(9, ai.getAgency_name());


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
        String query = "delete from user_info where user_id =?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public void update(BaseModel prop) throws SQLException {
        User_Info ai = (User_Info) prop;
        String query
                = "update user_info set email=?, "
                + " user_type_id= ?,first_name = ?, last_name = ?,address_id= ?,contact_no = ?, job_type = ?, agency_name = ? where user_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, ai.getEmail());
        ps.setInt(2, ai.getUser_type_id());
        ps.setString(3, ai.getFirst_name());
        ps.setString(4, ai.getLast_name());
        ps.setInt(5, ai.getAddress_id());
        ps.setString(6, ai.getContact_no());
        ps.setString(7, ai.getJob_type());
        ps.setString(8, ai.getAgency_name());
        ps.setInt(9, ai.getUser_id());


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
