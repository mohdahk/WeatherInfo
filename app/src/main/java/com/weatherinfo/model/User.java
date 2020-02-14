package com.weatherinfo.model;


import android.util.Patterns;

import com.weatherinfo.common.AppConstants;

import java.util.regex.Pattern;

public class User {

    private String mEmail;
    private String mPassword;


    public User(String email, String password) {
        mEmail = email;
        mPassword = password;
    }

    public String getEmail() {
        if (mEmail == null) {
            return "";
        }
        return mEmail;
    }


    public String getPassword() {

        if (mPassword == null) {
            return "";
        }
        return mPassword;
    }

    public boolean isEmailValid() {
        return Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches();
    }


    public boolean isValidPassword() {
        return Pattern.compile(AppConstants.PASSWORD_PATTERN).matcher(getPassword()).matches();
    }

}

