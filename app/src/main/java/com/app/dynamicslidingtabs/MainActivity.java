package com.app.dynamicslidingtabs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.app.dynamicslidingtabs.adapter.ViewPagerAdapter;
import com.app.dynamicslidingtabs.model.Country;
import com.app.dynamicslidingtabs.model.WorldpopulationItem;
import com.app.dynamicslidingtabs.retrofit.ApiClient;
import com.app.dynamicslidingtabs.retrofit.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //private ArrayList<ActorsItem> arrayList = new ArrayList();
    //private ArrayList<AlbumList> arrayList = new ArrayList();
    private ArrayList<WorldpopulationItem> arrayList = new ArrayList();
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private ArrayList<String> stringArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initViews() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        getActorList();
    }

    private void setupViewPager(ViewPager viewPager) {
        for (int i = 0; i < arrayList.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(arrayList.get(i).getCountry() + String.valueOf(i + 1)));
            stringArrayList.add(arrayList.get(i).getCountry());
        }

        Log.e("MainActivity", "setupViewPager: tabLayout count : " + tabLayout.getTabCount());
        Log.e("MainActivity", "setupViewPager: arrayList.size() : " + arrayList.size());

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), arrayList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        adapter.notifyDataSetChanged();
    }

    private void getActorList() {

        ApiInterface service = ApiClient.getClient().create(ApiInterface.class);


        Call<Country> call = service.getCountry();
        call.enqueue(new Callback<Country>() {
            @Override
            public void onResponse(Call<Country> call, Response<Country> response) {
                arrayList.addAll(response.body().getWorldpopulation());
                Log.e("MainActivity", "onResponse: population : " + arrayList.get(0).getCountry() + " ");

                setupViewPager(viewPager);
            }

            @Override
            public void onFailure(Call<Country> call, Throwable t) {
                Log.e("MainActivity", "onFailure: error : " + t);
            }
        });
    }
}