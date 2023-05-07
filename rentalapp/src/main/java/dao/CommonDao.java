package dao;

import model.BaseModel;
import model.Property;

import java.sql.SQLException;
import java.util.List;

public abstract class CommonDao {
    public int add(BaseModel prop) throws SQLException {
        return 0;
    }

    public void delete(int id) throws SQLException {

    }

    public void update(BaseModel prop) throws SQLException {

    }

    public BaseModel getByName(String name) throws SQLException {
        return null;
    }

    List<BaseModel> getByFilter(String filter) throws SQLException {
        return null;
    }

    public boolean hasProp(String filter) throws SQLException {
        return false;
    }

}
