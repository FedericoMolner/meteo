package com.dto;

import java.util.List;

public class meteoDTO {
    private List<String> date;
    private List<Double> temperature;

    public List<String> getDate() {
        return date;
    }

    public void setDate(List<String> date) {
        this.date = date;
    }

    public List<Double> getTemperature() {
        return temperature;
    }

    public void setTemperature(List<Double> temperature) {
        this.temperature = temperature;
    }
}