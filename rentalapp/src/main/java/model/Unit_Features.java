package model;

public class Unit_Features extends BaseModel {
    private int unit_id;
    private Boolean has_heating;
    private Boolean has_hardwood_floor;
    private Boolean has_carpet_floor;
    private Boolean has_pets_allowed;
    private Boolean has_no_of_parking;

    public int getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(int unit_id) {
        this.unit_id = unit_id;
    }

    public Boolean getHas_heating() {
        return has_heating;
    }

    public void setHas_heating(Boolean has_heating) {
        this.has_heating = has_heating;
    }

    public Boolean getHas_hardwood_floor() {
        return has_hardwood_floor;
    }

    public void setHas_hardwood_floor(Boolean has_hardwood_floor) {
        this.has_hardwood_floor = has_hardwood_floor;
    }

    public Boolean getHas_carpet_floor() {
        return has_carpet_floor;
    }

    public void setHas_carpet_floor(Boolean has_carpet_floor) {
        this.has_carpet_floor = has_carpet_floor;
    }

    public Boolean getHas_pets_allowed() {
        return has_pets_allowed;
    }

    public void setHas_pets_allowed(Boolean has_pets_allowed) {
        this.has_pets_allowed = has_pets_allowed;
    }

    public Boolean getHas_no_of_parking() {
        return has_no_of_parking;
    }

    public void setHas_no_of_parking(Boolean has_no_of_parking) {
        this.has_no_of_parking = has_no_of_parking;
    }
}
