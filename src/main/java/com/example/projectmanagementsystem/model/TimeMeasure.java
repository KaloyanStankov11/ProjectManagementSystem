package com.example.projectmanagementsystem.model;


public class TimeMeasure {
    private Integer number;
    private String unit;

    public TimeMeasure(Integer number, String unit) {
        this.number = number;
        this.unit = unit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
