
package com.weatherinfo.model;

import com.google.gson.annotations.SerializedName;


public class ConsolidatedWeather {

    @SerializedName("weather_state_name")
    private String weatherStateName;
    @SerializedName("wind_direction_compass")
    private String windDirectionCompass;
    @SerializedName("min_temp")
    private Float minTemp;
    @SerializedName("max_temp")
    private Float maxTemp;
    private Float windDirection;
    @SerializedName("humidity")
    private Integer humidity;

    public String getWeatherStateName() {
        return weatherStateName;
    }

    public void setWeatherStateName(String weatherStateName) {
        this.weatherStateName = weatherStateName;
    }
    public String getWindDirectionCompass() {
        return windDirectionCompass;
    }
    public void setWindDirectionCompass(String windDirectionCompass) {
        this.windDirectionCompass = windDirectionCompass;
    }

    public Float getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Float minTemp) {
        this.minTemp = minTemp;
    }

    public Float getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Float maxTemp) {
        this.maxTemp = maxTemp;
    }
    public Float getWindDirection() {
        return windDirection;
    }
    public void setWindDirection(Float windDirection) {
        this.windDirection = windDirection;
    }
    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }
}
