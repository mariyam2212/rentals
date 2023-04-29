package dao;

import java.sql.SQLException;
import java.util.List;

import model.Property;

public interface PropertyDao {
	//public int add(Property prop) throws SQLException;

	//public void delete(int id) throws SQLException;

	//public Property getPropertyByName(String name) throws SQLException;

	List<Property> getPropertiesByCity(String city) throws SQLException;

	//public void update(Property prop) throws SQLException;
}
