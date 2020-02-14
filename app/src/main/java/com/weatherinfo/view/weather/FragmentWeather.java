package com.weatherinfo.view.weather;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weatherinfo.R;
import com.weatherinfo.common.AppConstants;
import com.weatherinfo.databinding.LayoutSearchcityBinding;
import com.weatherinfo.databinding.LayoutWeatherBinding;
import com.weatherinfo.view.BaseFragment;
import com.weatherinfo.view.cities.FragmentSearchCity;
import com.weatherinfo.viewmodel.SearchCityViewModel;
import com.weatherinfo.viewmodel.WeatherViewModel;

public class FragmentWeather extends BaseFragment {

    private WeatherViewModel mWeatherViewModel;
    private int mWoeid;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        LayoutWeatherBinding binding = DataBindingUtil.inflate(inflater,R.layout.layout_weather, container, false);
        binding.setLifecycleOwner(this);
        mWeatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);
        binding.setWeatherViewModel(mWeatherViewModel);
        View view = binding.getRoot();
        mWeatherViewModel.setWoeid(mWoeid);
        mWeatherViewModel.getWeatherData();
        mWeatherViewModel.busy.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean val) {
                if(val)
                    baseActivity.showProgressDialog(getActivity(),getResources().getString(R.string.loading));
                else
                    baseActivity.hideProgressDialog();
            }
        });


        return view;
    }

    public static FragmentWeather newInstance(int woeid) {
        Bundle args = new Bundle();
        args.putInt(AppConstants.WOEID, woeid);
        FragmentWeather fragment = new FragmentWeather();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mWoeid = getArguments().getInt(AppConstants.WOEID);

        }
    }
}
