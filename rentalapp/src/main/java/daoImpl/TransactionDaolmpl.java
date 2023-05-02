package daoImpl;

import dao.CommonDao;
import model.BaseModel;
import model.Property;
import model.Transaction_Info;
import postgres.SQLDriver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TransactionDaolmpl implements CommonDao {
    static Connection conn = SQLDriver.getConnection();

    @Override
    public int add(BaseModel prop) throws SQLException {
         Transaction_Info ai = (Transaction_Info) prop;
        String query = "INSERT INTO transaction_info (transaction_id, txn_amount, card_number, address_id, payment_type_id, txn_date, txn_status, expiry_date) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?); ";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, ai.getTransaction_id());
            ps.setFloat(2, ai.getTxn_amount());
            ps.setString(3, ai.getCard_number());
            ps.setInt(4, ai.getAddress_id());
            ps.setInt(5, ai.getPayment_type_id());
            ps.setDate(6, (Date) ai.getTxn_date());
            ps.setString(7, ai.getTxn_status());
            ps.setDate(8, (Date) ai.getExpiry_date());
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
        String query = "delete from transaction_info where transaction_id =?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public void update(BaseModel prop) throws SQLException {
        Transaction_Info ai = (Transaction_Info) prop;
        String query
                = "update transaction_info set txn_amount=?, "
                + " card_number= ?,address_id = ?, payment_type_id = ?, txn_date = ?, txn_status = ?,  expiry_date = ? where transaction_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setFloat(1, ai.getTxn_amount());
        ps.setString(2, ai.getCard_number());
        ps.setInt(3, ai.getAddress_id());
        ps.setInt(4, ai.getPayment_type_id());
        ps.setDate(5, (Date) ai.getTxn_date());
        ps.setString(6, ai.getTxn_status());
        ps.setDate(7, (Date) ai.getExpiry_date());
        ps.setInt(8, ai.getTransaction_id());

        int n = ps.executeUpdate();
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
