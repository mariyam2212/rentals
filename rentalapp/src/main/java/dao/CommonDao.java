package dao;

import model.BaseModel;
import model.Property;

import java.sql.SQLException;
import java.util.List;

public interface CommonDao {
    public int add(BaseModel prop) throws SQLException;

    public void delete(int id) throws SQLException;

    public void update(BaseModel prop) throws SQLException;

    public Property getByName(String name) throws SQLException;

    List<Property> getByFilter(String filter) throws SQLException;

}
