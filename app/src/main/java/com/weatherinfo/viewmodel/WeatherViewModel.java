package com.weatherinfo.viewmodel;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.weatherinfo.model.City;
import com.weatherinfo.model.CityDetail;
import com.weatherinfo.model.ConsolidatedWeather;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherViewModel extends BaseViewModel{


    private int mWoeid;

    public MutableLiveData<String> weatherState = new MutableLiveData<>();
    public MutableLiveData<String> windDirection = new MutableLiveData<>();
    public MutableLiveData<String> tempMin = new MutableLiveData<>();
    public MutableLiveData<String> tempMax = new MutableLiveData<>();
    public MutableLiveData<String> humidity = new MutableLiveData<>();

    public WeatherViewModel(@NonNull Application application) {
        super(application);

    }

    public void getWeatherData(){
        mApiManager.getCityDetail(mWoeid).enqueue(new Callback<CityDetail>() {
            @Override
            public void onResponse(Call<CityDetail> call, Response<CityDetail> response) {
                     CityDetail cityDetail = response.body();
                    List<ConsolidatedWeather> consolidatedWeather = cityDetail.getConsolidatedWeather();
                    weatherState.setValue(consolidatedWeather.get(0).getWeatherStateName());
                    windDirection.setValue(consolidatedWeather.get(0).getWindDirectionCompass());
                    tempMin.setValue(consolidatedWeather.get(0).getMinTemp().toString());
                    tempMax.setValue(consolidatedWeather.get(0).getMaxTemp().toString());
                    humidity.setValue(consolidatedWeather.get(0).getHumidity().toString());
            }

            @Override
            public void onFailure(Call<CityDetail> call, Throwable t) {

            }
        });
    }

    public int getWoeid() {
        return mWoeid;
    }

    public void setWoeid(int mWoeid) {
        this.mWoeid = mWoeid;
    }



}
