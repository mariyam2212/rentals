package dao;

import java.sql.SQLException;
import java.util.List;

import model.Property;

public interface PropertyDao {
	List<Property> getPropertiesByCity(String city) throws SQLException;
}
