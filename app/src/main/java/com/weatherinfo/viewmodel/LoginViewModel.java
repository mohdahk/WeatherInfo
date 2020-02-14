package com.weatherinfo.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.weatherinfo.R;
import com.weatherinfo.model.Cities;
import com.weatherinfo.model.City;
import com.weatherinfo.model.User;
import com.weatherinfo.service.ApiManager;
import com.weatherinfo.service.ServiceClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends BaseViewModel {

    public MutableLiveData<String> errorPassword = new MutableLiveData<>();
    public MutableLiveData<String> errorEmail = new MutableLiveData<>();
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    private MutableLiveData<User> userMutableLiveData;

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<User> getUser() {
        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;
    }


    public void onLoginClicked() {
        User user = new User(email.getValue(), password.getValue());
        if (!user.isEmailValid()) {
            errorEmail.setValue(mApplication.getResources().getString(R.string.invalidemail));
        } else {
            errorEmail.setValue(null);
        }
        if (!user.isValidPassword())
            errorPassword.setValue(mApplication.getResources().getString(R.string.invalidpasswprd));
        else {
            errorPassword.setValue(null);
        }
        userMutableLiveData.setValue(user);
    }
}
