package com.revature.models;

public class Squadron {
    private int squa_id;
    private String squa_name;
    private int active_personal;
    private String base_location;
    private String aircraft_type;

    public Squadron() {
    }

    public Squadron(int squa_id, String squa_name, int active_personal, String base_location, String aircraft_type) {
        this.squa_id = squa_id;
        this.squa_name = squa_name;
        this.active_personal = active_personal;
        this.base_location = base_location;
        this.aircraft_type = aircraft_type;
    }

    public Squadron(String squa_name, int active_personal, String base_location, String aircraft_type) {
        this.squa_name = squa_name;
        this.active_personal = active_personal;
        this.base_location = base_location;
        this.aircraft_type = aircraft_type;
    }

    public int getSqua_id() {
        return squa_id;
    }

    public void setSqua_id(int squa_id) {
        this.squa_id = squa_id;
    }

    public String getSqua_name() {
        return squa_name;
    }

    public void setSqua_name(String squa_name) {
        this.squa_name = squa_name;
    }

    public int getActive_personal() {
        return active_personal;
    }

    public void setActive_personal(int active_personal) {
        this.active_personal = active_personal;
    }

    public String getBase_location() {
        return base_location;
    }

    public void setBase_location(String base_location) {
        this.base_location = base_location;
    }

    public String getAircraft_type() {
        return aircraft_type;
    }

    public void setAircraft_type(String aircraft_type) {
        this.aircraft_type = aircraft_type;
    }

    @Override
    public String toString() {
        return "Squadron{" +
                "squa_id=" + squa_id +
                ", squa_name='" + squa_name + '\'' +
                ", active_personal=" + active_personal +
                ", base_location='" + base_location + '\'' +
                ", aircraft_type='" + aircraft_type + '\'' +
                '}';
    }
}
