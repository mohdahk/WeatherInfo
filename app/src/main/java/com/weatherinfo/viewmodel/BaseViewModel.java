package com.weatherinfo.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.weatherinfo.service.ApiManager;
import com.weatherinfo.service.ServiceClient;

public class BaseViewModel extends AndroidViewModel {

    protected Application mApplication;
    protected  ApiManager mApiManager;


    public BaseViewModel(@NonNull Application application) {
        super(application);
        this.mApplication = application;
        if(mApiManager == null){
            mApiManager = ServiceClient.getClient().create(ApiManager.class);
        }



    }
}
