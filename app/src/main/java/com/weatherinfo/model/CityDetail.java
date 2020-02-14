
package com.weatherinfo.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CityDetail {

    @SerializedName("consolidated_weather")
    private List<ConsolidatedWeather> consolidatedWeather = null;
    private String time;
    private String sun_rise;
    private String sun_set;
    private String timezoneName;
    private String title;
    private String locationType;
    private Integer woeid;
    private String lattLong;
    private String timezone;

    public List<ConsolidatedWeather> getConsolidatedWeather() {
        return consolidatedWeather;
    }

    public void setConsolidatedWeather(List<ConsolidatedWeather> consolidatedWeather) {
        this.consolidatedWeather = consolidatedWeather;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSun_rise() {
        return sun_rise;
    }

    public void setSun_rise(String sun_rise) {
        this.sun_rise = sun_rise;
    }

    public String getSun_set() {
        return sun_set;
    }

    public void setSun_set(String sun_set) {
        this.sun_set = sun_set;
    }

    public String getTimezoneName() {
        return timezoneName;
    }

    public void setTimezoneName(String timezoneName) {
        this.timezoneName = timezoneName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public Integer getWoeid() {
        return woeid;
    }

    public void setWoeid(Integer woeid) {
        this.woeid = woeid;
    }

    public String getLattLong() {
        return lattLong;
    }

    public void setLattLong(String lattLong) {
        this.lattLong = lattLong;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

}
