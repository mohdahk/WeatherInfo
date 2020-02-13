package com.weatherinfo.service;

import android.support.annotation.NonNull;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.weatherinfo.common.AppConstants.WEATHER_INFO_URL;

public class ServiceClient {
    @NonNull
    public static Retrofit getClient() {
        return new Retrofit.Builder()
                .baseUrl(WEATHER_INFO_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
