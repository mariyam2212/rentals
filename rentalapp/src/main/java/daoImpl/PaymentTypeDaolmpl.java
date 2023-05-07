package daoImpl;

import dao.CommonDao;
import model.BaseModel;
import model.Payment_Type_Info;
import model.Property;
import postgres.SQLDriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PaymentTypeDaolmpl extends CommonDao {
    Connection conn = SQLDriver.getInstance().getConnection();

    //TODO: to be removed
    @Override
    public int add(BaseModel prop) throws SQLException {
        Payment_Type_Info ai = (Payment_Type_Info) prop;
        String query = "INSERT INTO Payment_Type_Info (payment_id, payment_type) "
                + "VALUES (?, ?); ";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, ai.getPayment_id());
            ps.setString(2, ai.getPayment_type());
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
        String query = "delete from payment_type_info where payment_id =?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public void update(BaseModel prop) throws SQLException {
        Payment_Type_Info ai = (Payment_Type_Info) prop;
        String query
                = "update payment_type_info set payment_type=?, where payment_id = ?" ;
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, ai.getPayment_type());
        ps.setInt(2, ai.getPayment_id());

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
}
