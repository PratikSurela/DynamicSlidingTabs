package com.app.dynamicslidingtabs.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.dynamicslidingtabs.R;
import com.app.dynamicslidingtabs.adapter.RecyclerViewAdapter;
import com.app.dynamicslidingtabs.interfaces.Updateable;
import com.app.dynamicslidingtabs.model.Country;
import com.app.dynamicslidingtabs.model.WorldpopulationItem;
import com.app.dynamicslidingtabs.retrofit.ApiClient;
import com.app.dynamicslidingtabs.retrofit.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Pratik Surela on 14/6/17.
 */

public class MainFragment extends Fragment implements Updateable {

    private View rootView;
    private ArrayList<WorldpopulationItem> worldpopulationItems = new ArrayList<>();
    private int position;

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private RecyclerViewAdapter adapter;
    private ArrayList<WorldpopulationItem> arrayList = new ArrayList<>();

    public MainFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, null);

        initViews(rootView);

        ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
        Call<Country> call = service.getCountry();
        call.enqueue(new Callback<Country>() {
            @Override
            public void onResponse(Call<Country> call, Response<Country> response) {
                arrayList.addAll(response.body().getWorldpopulation());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Country> call, Throwable t) {
                Log.e("MainActivity", "onFailure: error : " + t);
            }
        });

        return rootView;
    }

    private void initViews(View view) {

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new RecyclerViewAdapter(getContext(), arrayList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void update(ArrayList<WorldpopulationItem> worldpopulationItems, int position) {
        arrayList = new ArrayList<>();
        this.worldpopulationItems = worldpopulationItems;
        this.position = position;
    }
}