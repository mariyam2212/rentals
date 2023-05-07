package daoImpl;

import dao.CommonDao;
import model.BaseModel;
import model.Property;
import model.Property_Neighbourhood;
import postgres.SQLDriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PropertyNeighbourhoodDaolmpl extends CommonDao {
    Connection conn = SQLDriver.getInstance().getConnection();

    @Override
    public int add(BaseModel prop) throws SQLException {
        Property_Neighbourhood ai = (Property_Neighbourhood) prop;
        String query = "INSERT INTO property_neighbourhood (property_id, nearest_grocery, nearest_school, nearest_bus_stop, nearest_metro, nearest_atm, nearest_airport) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?); ";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, ai.getProperty_id());
            ps.setFloat(2, ai.getNearest_grocery());
            ps.setFloat(3, ai.getNearest_school());
            ps.setFloat(4, ai.getNearest_bus_stop());
            ps.setFloat(5, ai.getNearest_metro());
            ps.setFloat(6, ai.getNearest_atm());
            ps.setFloat(7, ai.getNearest_airport());

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
        String query = "delete from property_neighbourhood where property_id =?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public void update(BaseModel prop) throws SQLException {
        Property_Neighbourhood ai = (Property_Neighbourhood) prop;
        String query
                = "update property_neighbourhood set nearest_grocery=?, "
                + "nearest_school = ?, nearest_bus_stop= ?, nearest_metro = ? nearest_atm= ?, nearest_airport= ?  = ?where property_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setFloat(1, ai.getNearest_grocery());
        ps.setFloat(2, ai.getNearest_school());
        ps.setFloat(3, ai.getNearest_bus_stop());
        ps.setFloat(4, ai.getNearest_metro());
        ps.setFloat(5, ai.getNearest_atm());
        ps.setFloat(6, ai.getNearest_airport());
        ps.setInt(7, ai.getProperty_id());

        ps.executeUpdate();
    }

    @Override
    public BaseModel getByName(String name) throws SQLException {
        return null;
    }
}
