package model;

import java.util.Date;

public class Unit_Info extends BaseModel {
    private int unit_id;
    private String unit_title;
    private String unit_type;
    private int property_id;
    private int floor_number;
    private int number_of_beds;
    private int number_of_bathrooms;
    private int number_of_balcony;
    private int square_footage;
    private Date availability_date;
    private int rent_amount;

    public int getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(int unit_id) {
        this.unit_id = unit_id;
    }

    public String getUnit_title() {
        return unit_title;
    }

    public void setUnit_title(String unit_title) {
        this.unit_title = unit_title;
    }

    public String getUnit_type() {
        return unit_type;
    }

    public void setUnit_type(String unit_type) {
        this.unit_type = unit_type;
    }

    public int getProperty_id() {
        return property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }

    public int getFloor_number() {
        return floor_number;
    }

    public void setFloor_number(int floor_number) {
        this.floor_number = floor_number;
    }

    public int getNumber_of_beds() {
        return number_of_beds;
    }

    public void setNumber_of_beds(int number_of_beds) {
        this.number_of_beds = number_of_beds;
    }

    public int getNumber_of_bathrooms() {
        return number_of_bathrooms;
    }

    public void setNumber_of_bathrooms(int number_of_bathrooms) {
        this.number_of_bathrooms = number_of_bathrooms;
    }

    public int getNumber_of_balcony() {
        return number_of_balcony;
    }

    public void setNumber_of_balcony(int number_of_balcony) {
        this.number_of_balcony = number_of_balcony;
    }

    public int getSquare_footage() {
        return square_footage;
    }

    public void setSquare_footage(int square_footage) {
        this.square_footage = square_footage;
    }

    public Date getAvailability_date() {
        return availability_date;
    }

    public void setAvailability_date(Date availability_date) {
        this.availability_date = availability_date;
    }

    public int getRent_amount() {
        return rent_amount;
    }

    public void setRent_amount(int rent_amount) {
        this.rent_amount = rent_amount;
    }
}
