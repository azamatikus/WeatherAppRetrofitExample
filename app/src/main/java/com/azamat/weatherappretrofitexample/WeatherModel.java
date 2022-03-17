package com.azamat.weatherappretrofitexample;

public class WeatherModel {

    private Double temp;
    private Double temp_min;
    private Double temp_max;
    private Integer pressure;
    private Integer humidity;

    public Double getTemp() {
        return temp;
    }

    public Double getTemp_min() {
        return temp_min;
    }

    public Double getTemp_max() {
        return temp_max;
    }

    public Integer getPressure() {
        return pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }
}
