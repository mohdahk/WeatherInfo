package com.weatherinfo.view.cities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.weatherinfo.R;
import com.weatherinfo.model.City;
import java.util.ArrayList;
import java.util.List;

public class CityListAdapter  extends RecyclerView.Adapter<CityListAdapter.CityItemHolder> {

    private Context context;
    private List<City> mCities = new ArrayList<>();
    private cityItemClickCallback mCityItemClickCallback;

    public CityListAdapter(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public CityListAdapter.CityItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.layout_cityitem, viewGroup, false);
        return new CityItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CityListAdapter.CityItemHolder holder, final int position) {
        City city  = mCities.get(position);
        holder.tv_city.setText(mCities.get(position).getTitle());
        holder.tv_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    mCityItemClickCallback.onItemClick(mCities.get(position).getWoeid());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mCities == null ? 0 : mCities.size();
    }

    public void setCities(List<City> cities) {
        mCities = cities;
        notifyDataSetChanged();
    }

    public void setItemClickCallBack(cityItemClickCallback callback) {
        this.mCityItemClickCallback = callback;
    }

    public interface cityItemClickCallback {
        public void onItemClick(int woeid);
    }

    class CityItemHolder extends RecyclerView.ViewHolder {
        AppCompatTextView tv_city;
        private CityItemHolder(View itemView) {
            super(itemView);
            tv_city = itemView.findViewById(R.id.cityitem);
        }
    }
}

