package com.revature.models;

public class Personal {
    private int personal_id;
    private String personal_name;
    private int years_in_service;
    private int squa_id_fk;
    private Squadron squadron;

    public Personal() {
    }

    public Personal(int personal_id, String personal_name, int years_in_service, Squadron squadron) {
        this.personal_id = personal_id;
        this.personal_name = personal_name;
        this.years_in_service = years_in_service;
        this.squadron = squadron;
    }

    public Personal(String personal_name, int years_in_service, Squadron squadron) {
        this.personal_name = personal_name;
        this.years_in_service = years_in_service;
        this.squadron = squadron;
    }

    public Personal(String personal_name, int years_in_service, int squa_id_fk) {
        this.personal_name = personal_name;
        this.years_in_service = years_in_service;
        this.squa_id_fk = squa_id_fk;
    }

    public int getPersonal_id() {
        return personal_id;
    }

    public void setPersonal_id(int personal_id) {
        this.personal_id = personal_id;
    }

    public String getPersonal_name() {
        return personal_name;
    }

    public void setPersonal_name(String personal_name) {
        this.personal_name = personal_name;
    }

    public int getYears_in_service() {
        return years_in_service;
    }

    public void setYears_in_service(int years_in_service) {
        this.years_in_service = years_in_service;
    }

    public int getSqua_id_fk() {
        return squa_id_fk;
    }

    public void setSqua_id_fk(int squa_id_fk) {
        this.squa_id_fk = squa_id_fk;
    }

    public Squadron getSquadron() {
        return squadron;
    }

    public void setSquadron(Squadron squadron) {
        this.squadron = squadron;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "personal_id=" + personal_id +
                ", personal_name='" + personal_name + '\'' +
                ", years_in_service=" + years_in_service +
                ", squadron=" + squadron +
                '}';
    }
}
