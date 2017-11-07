package com.cris.capo;

import java.awt.*;
import java.util.Date;

public class DataPoint {
    private int value;
    private Date datetime;
    private String color;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public DataPoint(int value, Date datetime) {
        this.value = value;
        this.datetime = datetime;
    }
}
