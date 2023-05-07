/**
 *
 */
package daoImpl;

import dao.CommonDao;
import dao.PropertyDao;
import model.BaseModel;
import model.Property;
import postgres.SQLDriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fatimamariyam
 */
public class PropertyDaoImpl extends CommonDao implements PropertyDao {
    Connection conn = SQLDriver.getInstance().getConnection();

    public PropertyDaoImpl() {
    }

    @Override
    public int add(BaseModel prop) throws SQLException {
        Property ai = (Property) prop;
        String query = "INSERT INTO public.property_info(property_name, total_units, total_floors, street_name, city, state, country, zip_code, address, has_parking, has_laundry, is_pet_friendly, rating) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING property_id; ";
        int property_id = 0;
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, ai.getProperty_name());
        ps.setInt(2, ai.getTotal_units());
        ps.setInt(3, ai.getTotal_floors());
        ps.setString(4, ai.getStreet_name());
        ps.setString(5, ai.getCity());
        ps.setString(6, ai.getState());
        ps.setString(7, ai.getCountry());
        ps.setString(8, ai.getZip_code());
        ps.setString(9, ai.getAddress());
        ps.setBoolean(10, ai.getHas_parking());
        ps.setBoolean(11, ai.getHas_laundry());
        ps.setBoolean(12, ai.getIs_pet_friendly());
        ps.setInt(13, ai.getRating());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            property_id = rs.getInt("property_id");
        }
        if (property_id != 0) {
            System.out.println("Property record created successfully");
            return property_id;
        }
        return 0;
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void update(BaseModel prop) throws SQLException {

    }

    @Override
    public BaseModel getByName(String name) throws SQLException {
        return null;
    }

    // fetches properties from db by city name
    @Override
    public List<Property> getPropertiesByCity(String city) throws SQLException {
        String query = "select * from property_info where city = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, city);
        ResultSet rs = ps.executeQuery();
        List<Property> ls = new ArrayList<>();

        while (rs.next()) {
            Property prop = new Property();
            prop.setProperty_id(rs.getInt("property_id"));
            prop.setProperty_name(rs.getString("property_name"));
            prop.setTotal_units(rs.getInt("total_units"));
            prop.setTotal_floors(rs.getInt("total_floors"));
            prop.setStreet_name(rs.getString("street_name"));
            prop.setCity(rs.getString("city"));
            prop.setState(rs.getString("state"));
            prop.setCountry(rs.getString("country"));
            prop.setZip_code(rs.getString("zip_code"));
            prop.setAddress(rs.getString("address"));
            prop.setHas_laundry(rs.getBoolean("has_laundry"));
            prop.setHas_parking(rs.getBoolean("has_parking"));
            prop.setIs_pet_friendly(rs.getBoolean("is_pet_friendly"));
            prop.setRating(rs.getInt("rating"));
            ls.add(prop);
        }
        return ls;
    }
}
