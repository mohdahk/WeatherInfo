package com.weatherinfo.view.login;

import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.arch.lifecycle.ViewModelProviders;

import com.weatherinfo.R;
import com.weatherinfo.databinding.LayoutLoginBinding;
import com.weatherinfo.model.User;
import com.weatherinfo.view.BaseFragment;
import com.weatherinfo.view.cities.FragmentSearchCity;
import com.weatherinfo.viewmodel.LoginViewModel;


public class FragmentLogin extends BaseFragment {

    private LoginViewModel mLoginViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        LayoutLoginBinding binding = DataBindingUtil.inflate(inflater,R.layout.layout_login, container, false);
        binding.setLifecycleOwner(this);
        binding.setLoginViewModel(mLoginViewModel);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        mLoginViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {

                //if(user.isEmailValid() && user.isValidPassword()){
                    replaceFragment(FragmentSearchCity.newInstance());
                //}
            }


        });
    }

    public static FragmentLogin newInstance() {
        return new FragmentLogin();
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mLoginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

    }



}
