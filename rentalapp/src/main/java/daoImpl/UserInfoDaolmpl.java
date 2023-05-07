package daoImpl;

import dao.CommonDao;
import model.BaseModel;
import model.User_Info;
import postgres.SQLDriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInfoDaolmpl extends CommonDao {
    Connection conn = SQLDriver.getInstance().getConnection();

    @Override
    public int add(BaseModel prop) throws SQLException {
        User_Info ai = (User_Info) prop;
        String query = "INSERT INTO user_info ( password, email, user_type_id, first_name, last_name, address_id, contact_no, job_type, agency_name) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING user_id; ";
        int user_id = 0;
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, ai.getPassword());
        ps.setString(2, ai.getEmail());
        ps.setInt(3, ai.getUser_type_id());
        ps.setString(4, ai.getFirst_name());
        ps.setString(5, ai.getLast_name());
        ps.setInt(6, ai.getAddress_id());
        ps.setString(7, ai.getContact_no());
        ps.setString(8, ai.getJob_type());
        ps.setString(9, ai.getAgency_name());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            user_id = rs.getInt("user_id");
        }
        if (user_id != 0) {
            System.out.println("Address record created successfully");
            return user_id;
        }
        return 0;
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
    public BaseModel getByName(String email) throws SQLException {
        String query = "SELECT password, user_id, user_type_id, first_name, address_id, contact_no FROM user_info WHERE email like ?; ";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, email);
        ResultSet rset = ps.executeQuery();
        rset.next();
        User_Info result = new User_Info();
        result.setPassword(rset.getString(1));
        result.setEmail(email);
        result.setUser_id(rset.getInt(2));
        result.setUser_type_id(rset.getInt(3));
        result.setFirst_name(rset.getString(4));
        result.setAddress_id(rset.getInt(5));
        result.setContact_no(rset.getString(6));
        return result;
    }

    @Override
    public boolean hasProp(String filter) throws SQLException {
        String query = "SELECT 1 FROM user_info WHERE email like ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, filter);
        ResultSet rset = ps.executeQuery();
        if (rset.next()) {
            int rsetInt = rset.getInt(1);
            if (rsetInt == 1)
                return true;
        }
        return false;
    }
}
