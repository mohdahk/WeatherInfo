package com.weatherinfo.view.cities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weatherinfo.R;
import com.weatherinfo.databinding.LayoutSearchcityBinding;
import com.weatherinfo.model.City;
import com.weatherinfo.view.BaseFragment;
import com.weatherinfo.view.weather.FragmentWeather;
import com.weatherinfo.viewmodel.SearchCityViewModel;

import java.util.List;


public class FragmentSearchCity extends BaseFragment implements CityListAdapter.cityItemClickCallback {

    private SearchCityViewModel mSearchCityViewModel;
    private CityListAdapter mCityListAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        LayoutSearchcityBinding binding = DataBindingUtil.inflate(inflater,R.layout.layout_searchcity, container, false);
        binding.setLifecycleOwner(this);
        mSearchCityViewModel = ViewModelProviders.of(this).get(SearchCityViewModel.class);
        binding.setSearchCityViewModel(mSearchCityViewModel);
        View view = binding.getRoot();
        RecyclerView citylist = view.findViewById(R.id.rv_citylist);
        citylist.setLayoutManager(new LinearLayoutManager(getActivity()));
        citylist.setHasFixedSize(true);
        citylist.addItemDecoration(new DividerItemDecoration(citylist.getContext(), DividerItemDecoration.VERTICAL));
        mCityListAdapter = new CityListAdapter(getActivity());
        citylist.setAdapter(mCityListAdapter);
        mCityListAdapter.setItemClickCallBack(this);
        mSearchCityViewModel.getCityList().observe(this, new Observer<List<City>>() {
            @Override
            public void onChanged(@Nullable List<City> cities) {

                if (cities != null || !cities.isEmpty()) {
                    mCityListAdapter.setCities(cities);
                }
                Handler h = new Handler();
            }
        });

        mSearchCityViewModel.busy.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if(aBoolean)
                    baseActivity.showProgressDialog(getActivity(),getResources().getString(R.string.loading));
                else
                    baseActivity.hideProgressDialog();
            }
        });
        return view;
    }

    public static FragmentSearchCity newInstance() {
        return new FragmentSearchCity();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onItemClick(int woeid) {
            replaceFragment(FragmentWeather.newInstance(woeid));
    }
}
