package model;


public class Property extends BaseModel{
    private int property_id;
    private String property_name;
    private int total_units;
    private int total_floors;
    private String street_name;
    private String city;
    private String state;
    private String country;
    private String zip_code;
    private String address;
    private Boolean has_parking;
    private Boolean has_laundry;
    private Boolean is_pet_friendly;
    private int rating;

    public Property(int property_id, String property_name, int total_units, int total_floors, String street_name,
                    String city, String state, String country, String zip_code, String address, Boolean has_parking,
                    Boolean has_laundry, Boolean is_pet_friendly, int rating) {
        super();
        this.property_id = property_id;
        this.property_name = property_name;
        this.total_units = total_units;
        this.total_floors = total_floors;
        this.street_name = street_name;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip_code = zip_code;
        this.address = address;
        this.has_parking = has_parking;
        this.has_laundry = has_laundry;
        this.is_pet_friendly = is_pet_friendly;
        this.rating = rating;
    }

    public Property() {
        super();
    }


    public int getProperty_id() {
        return property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }

    public String getProperty_name() {
        return property_name;
    }

    public void setProperty_name(String property_name) {
        this.property_name = property_name;
    }

    public int getTotal_units() {
        return total_units;
    }

    public void setTotal_units(int total_units) {
        this.total_units = total_units;
    }

    public int getTotal_floors() {
        return total_floors;
    }

    public void setTotal_floors(int total_floors) {
        this.total_floors = total_floors;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getHas_parking() {
        return has_parking;
    }

    public void setHas_parking(Boolean has_parking) {
        this.has_parking = has_parking;
    }

    public Boolean getHas_laundry() {
        return has_laundry;
    }

    public void setHas_laundry(Boolean has_laundry) {
        this.has_laundry = has_laundry;
    }

    public Boolean getIs_pet_friendly() {
        return is_pet_friendly;
    }

    public void setIs_pet_friendly(Boolean is_pet_friendly) {
        this.is_pet_friendly = is_pet_friendly;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


}
