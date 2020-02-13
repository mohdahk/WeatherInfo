package com.weatherinfo.service;

import com.weatherinfo.model.Cities;
import com.weatherinfo.model.City;
import com.weatherinfo.model.CityDetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiManager {
    @GET("api/location/search")
    public Call<List<City>> getSearchResult(@Query("query") String searchString);

    @GET("api/location/{woeid}")
    public Call<CityDetail> getCityDetail(@Path("woeid") int woeid);
}