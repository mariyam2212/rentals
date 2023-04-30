package model;

public class Property_Neighbourhood implements BaseModel {
private int property_id;
private Float nearest_grocery;
private Float nearest_school;
private Float nearest_bus_stop;
private Float nearest_metro;
private Float nearest_atm;
private Float nearest_airport;

    public int getProperty_id() {
        return property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }

    public float getNearest_grocery() {
        return nearest_grocery;
    }

    public void setNearest_grocery(Float nearest_grocery) {
        this.nearest_grocery = nearest_grocery;
    }

    public float getNearest_school() {
        return nearest_school;
    }

    public void setNearest_school(Float nearest_school) {
        this.nearest_school = nearest_school;
    }

    public Float getNearest_bus_stop() {
        return nearest_bus_stop;
    }

    public void setNearest_bus_stop(Float nearest_bus_stop) {
        this.nearest_bus_stop = nearest_bus_stop;
    }

    public Float getNearest_metro() {
        return nearest_metro;
    }

    public void setNearest_metro(Float nearest_metro) {
        this.nearest_metro = nearest_metro;
    }

    public Float getNearest_atm() {
        return nearest_atm;
    }

    public void setNearest_atm(Float nearest_atm) {
        this.nearest_atm = nearest_atm;
    }

    public Float getNearest_airport() {
        return nearest_airport;
    }

    public void setNearest_airport(Float nearest_airport) {
        this.nearest_airport = nearest_airport;
    }
}
