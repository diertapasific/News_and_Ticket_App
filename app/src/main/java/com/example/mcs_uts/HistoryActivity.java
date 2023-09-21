package com.example.mcs_uts;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HistoryActivity extends AppCompatActivity implements HistoryInterface{
    BottomNavigationView bottomNavigationView;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    HistoryAdapter historyAdapter;
    SharedPreferences userlogin, userhistory;
    String image, title, price, date, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(R.layout.action_bar_custom);
        }
        
        List<History> histories = new ArrayList<History>();

        userlogin = getSharedPreferences("userlogin", MODE_PRIVATE);
        String userLogin = userlogin.getString("userlogin","");
        userhistory = getSharedPreferences(userLogin+"history", MODE_PRIVATE);

        Map<String, ?> allEntries = userhistory.getAll();
        int count = allEntries.size();

        recyclerView = findViewById(R.id.historyRecyclerView);
        for (int i = 0; i < count; i++){
            String id = Integer.toString(i);
            if (userhistory.getString("title"+id,"").equals("")){
                continue;
            }
            title = userhistory.getString("title"+id,"");
            image = userhistory.getString("image"+id,"");
            price = userhistory.getString("price"+id,"");
            date = userhistory.getString("date"+id,"");
            total = userhistory.getString("total"+id,"");

            Log.d("dipa", title);
            Log.d("dipa", image);
            Log.d("dipa", price);
            Log.d("dipa", date);
            Log.d("dipa", total);

            histories.add(new History(title,Integer.parseInt(image),price,date,total));
        }

        linearLayoutManager = new LinearLayoutManager(HistoryActivity.this, LinearLayoutManager.VERTICAL,false);

        historyAdapter = new HistoryAdapter(this, histories, this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(historyAdapter);

        bottomNavigationView = findViewById(R.id.bottomNavBar);
        bottomNavigationView.setSelectedItemId(R.id.history)
        ;
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.news:
                    startActivity(new Intent(getApplicationContext(),NewsActivity.class));
                    finish();
                    return true;
                case R.id.schedule:
                    startActivity(new Intent(getApplicationContext(),ScheduleTeamActivity.class));
                    finish();
                    return true;
                case R.id.history:
                    return true;
            }
            return false;
        });


    }


    @Override
    public void onHistoryClick(int position) {

    }
}