package daoImpl;

import dao.CommonDao;
import model.BaseModel;
import model.Property;
import model.Unit_Features;
import postgres.SQLDriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UnitFeaturesDaolmpl implements CommonDao {
    static Connection conn = SQLDriver.getConnection();

    @Override
    public int add(BaseModel prop) throws SQLException {
        Unit_Features ai = (Unit_Features) prop;
        String query = "INSERT INTO address_info (unit_id, has_heating, has_hardwood_floor, has_carpet_floor, has_pets_allowed, has_no_of_parking) "
                + "VALUES (?, ?, ?, ?, ?, ?); ";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, ai.getUnit_id());
            ps.setBoolean(2, ai.getHas_heating());
            ps.setBoolean(3, ai.getHas_hardwood_floor());
            ps.setBoolean(4, ai.getHas_carpet_floor());
            ps.setBoolean(5, ai.getHas_pets_allowed());
            ps.setBoolean(5, ai.getHas_no_of_parking());

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
        String query = "delete from unit_features where unit_id =?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public void update(BaseModel prop) throws SQLException {
        Unit_Features ai = (Unit_Features) prop;
        String query
                = "update unit_features set has_heating=?, "
                + " has_hardwood_floor= ?,has_carpet_floor = ?, has_pets_allowed = ?, has_no_of_parking = ? where unit_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setBoolean(1, ai.getHas_heating());
        ps.setBoolean(2, ai.getHas_hardwood_floor());
        ps.setBoolean(3, ai.getHas_carpet_floor());
        ps.setBoolean(4, ai.getHas_pets_allowed());
        ps.setBoolean(5, ai.getHas_no_of_parking());
        ps.setInt(6, ai.getUnit_id());
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
