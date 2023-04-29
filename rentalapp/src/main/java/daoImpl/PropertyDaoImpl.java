/**
 * 
 */
package daoImpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import model.Property;
import dao.PropertyDao;

import postgres.SQLDriver;

/**
 * @author fatimamariyam
 *
 */
public class PropertyDaoImpl implements PropertyDao {
	private final Connection conn;
	SQLDriver sql = new SQLDriver();

	public PropertyDaoImpl() {
		conn = sql.getDriver();
	}

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
