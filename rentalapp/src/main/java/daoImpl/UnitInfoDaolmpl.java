package daoImpl;

import dao.CommonDao;
import model.BaseModel;
import model.Unit_Info;
import postgres.SQLDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UnitInfoDaolmpl extends CommonDao {
    Connection conn = SQLDriver.getInstance().getConnection();

    @Override
    public int add(BaseModel prop) throws SQLException {
        Unit_Info ai = (Unit_Info) prop;
        String query = "INSERT INTO unit_info (unit_title, unit_type, property_id, floor_number, number_of_beds, number_of_bathrooms, number_of_balcony, square_footage, availability_date, rent_amount) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING unit_id; ";
        int unit_id = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, ai.getUnit_title());
            ps.setString(2, ai.getUnit_type());
            ps.setInt(3, ai.getProperty_id());
            ps.setInt(4, ai.getFloor_number());
            ps.setInt(5, ai.getNumber_of_beds());
            ps.setInt(6, ai.getNumber_of_bathrooms());
            ps.setInt(7, ai.getNumber_of_balcony());
            ps.setInt(8, ai.getSquare_footage());
            ps.setDate(9, (Date) ai.getAvailability_date());
            ps.setInt(10, ai.getRent_amount());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                unit_id = rs.getInt("unit_id");
            }
            if (unit_id != 0) {
                System.out.println("Address record created successfully");
                return unit_id;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "delete from unit_info where unit_id =?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public void update(BaseModel prop) throws SQLException {
        Unit_Info ai = (Unit_Info) prop;
        String query
                = "update unit_info set unit_title=?, "
                + " unit_type= ?, property_id = ?, floor_number = ?, number_of_beds= ?,number_of_bathrooms = ?, number_of_balcony = ?, square_footage = ?, availability_date = ?, rent_amount= ? where unit_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, ai.getUnit_title());
        ps.setString(2, ai.getUnit_type());
        ps.setInt(3, ai.getProperty_id());
        ps.setInt(4, ai.getFloor_number());
        ps.setInt(5, ai.getNumber_of_beds());
        ps.setInt(6, ai.getNumber_of_bathrooms());
        ps.setInt(7, ai.getNumber_of_balcony());
        ps.setInt(8, ai.getSquare_footage());
        ps.setDate(9, (Date) ai.getAvailability_date());
        ps.setInt(10, ai.getRent_amount());
        ps.setInt(11, ai.getUnit_id());
        ps.executeUpdate();
    }

    @Override
    public BaseModel getByName(String type) throws SQLException {
        return null;
    }

    public List<Unit_Info> getUnitsByCity(String city) throws SQLException {
        String query = "select * from property_info P JOIN unit_info U ON P.property_id = U.property_id where city like ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, city);
        ResultSet rs = ps.executeQuery();
        List<Unit_Info> ls = new ArrayList<>();

        while (rs.next()) {
            Unit_Info unit = new Unit_Info();
            unit.setUnit_id(rs.getInt("unit_id"));
            unit.setUnit_title(rs.getString("unit_title"));
            unit.setUnit_type(rs.getString("unit_type"));
            unit.setProperty_id(rs.getInt("property_id"));
            unit.setFloor_number(rs.getInt("floor_number"));
            unit.setNumber_of_beds(rs.getInt("number_of_beds"));
            unit.setNumber_of_bathrooms(rs.getInt("number_of_bathrooms"));
            unit.setNumber_of_balcony(rs.getInt("number_of_balcony"));
            unit.setSquare_footage(rs.getInt("square_footage"));
            unit.setAvailability_date(rs.getDate("availability_date"));
            unit.setRent_amount(rs.getInt("rent_amount"));
            ls.add(unit);
        }
        return ls;
    }

    public List<Unit_Info> filterUnitsByType(String city, String type) throws SQLException {
        String query = "select * from property_info P JOIN unit_info U ON P.property_id = U.property_id where city like ? and unit_type like ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, city);
        ps.setString(2, type);
        ResultSet rs = ps.executeQuery();
        List<Unit_Info> ls = new ArrayList<>();

        while (rs.next()) {
            Unit_Info unit = new Unit_Info();
            unit.setUnit_id(rs.getInt("unit_id"));
            unit.setUnit_title(rs.getString("unit_title"));
            unit.setUnit_type(rs.getString("unit_type"));
            unit.setProperty_id(rs.getInt("property_id"));
            unit.setFloor_number(rs.getInt("floor_number"));
            unit.setNumber_of_beds(rs.getInt("number_of_beds"));
            unit.setNumber_of_bathrooms(rs.getInt("number_of_bathrooms"));
            unit.setNumber_of_balcony(rs.getInt("number_of_balcony"));
            unit.setSquare_footage(rs.getInt("square_footage"));
            unit.setAvailability_date(rs.getDate("availability_date"));
            unit.setRent_amount(rs.getInt("rent_amount"));
            ls.add(unit);
        }
        return ls;
    }

    public List<Unit_Info> filterUnits(String city, String minbed, String maxbed, String minbath, String maxprice, String type, String date) throws SQLException {
        StringBuilder sb = new StringBuilder();
        PreparedStatement ps;
        int i = 2;
        sb.append("select * from property_info P JOIN unit_info U ON P.property_id = U.property_id where city like ? ");
        if (minbed != null && !minbed.equals("")) {
            sb.append(" and number_of_beds >= " + Integer.parseInt(minbed));
        }
        if (maxbed != null && !maxbed.equals("")) {
            sb.append(" and number_of_beds <= " + Integer.parseInt(maxbed));
        }
        if (minbath != null && !minbath.equals("")) {
            sb.append(" and number_of_bathrooms >= " + Integer.parseInt(minbath));
        }
        if (maxprice != null && !maxprice.equals("")) {
            sb.append(" and rent_amount <= " + Integer.parseInt(maxprice));
        }
        if (type != null && !type.equals("") && !type.equalsIgnoreCase("All")) {
            sb.append(" and unit_type like " + "\'" + type + "\'");
        }
        if (date != null && !date.equals("")) {
            sb.append(" and availability_date >= ?");    //date: yyyy-[m]m-[d]d
        }
        ps = conn.prepareStatement(sb.toString());
        ps.setString(1, city);
        ResultSet rs = ps.executeQuery();
        List<Unit_Info> ls = new ArrayList<>();

        while (rs.next()) {
            Unit_Info unit = new Unit_Info();
            unit.setUnit_id(rs.getInt("unit_id"));
            unit.setUnit_title(rs.getString("unit_title"));
            unit.setUnit_type(rs.getString("unit_type"));
            unit.setProperty_id(rs.getInt("property_id"));
            unit.setFloor_number(rs.getInt("floor_number"));
            unit.setNumber_of_beds(rs.getInt("number_of_beds"));
            unit.setNumber_of_bathrooms(rs.getInt("number_of_bathrooms"));
            unit.setNumber_of_balcony(rs.getInt("number_of_balcony"));
            unit.setSquare_footage(rs.getInt("square_footage"));
            unit.setAvailability_date(rs.getDate("availability_date"));
            unit.setRent_amount(rs.getInt("rent_amount"));
            ls.add(unit);
        }
        return ls;
    }
}