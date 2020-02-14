package com.weatherinfo.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.weatherinfo.model.City;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchCityViewModel extends BaseViewModel {

    public MutableLiveData<String> searchString = new MutableLiveData<>();
    public MutableLiveData<List<City>> mCities = new MutableLiveData<>();
    public SearchCityViewModel(@NonNull Application application) {
        super(application);
    }

    public void onSearchClick() {
        busy.setValue(true);
        mApiManager.getSearchResult(searchString.getValue()).enqueue(new Callback<List<City>>() {
            @Override
            public void onResponse(Call<List<City>> call, Response<List<City>> response) {

                if(response.code() == 200){
                    List<City> cities = response.body();
                    mCities.setValue(cities);
                    searchString.setValue("");
                }
                busy.setValue(false);
            }

            @Override
            public void onFailure(Call<List<City>> call, Throwable t) {
                busy.setValue(false);
            }
        });

    }

    public LiveData<List<City>> getCityList(){
        return  mCities;
    }
}
