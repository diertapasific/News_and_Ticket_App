package com.example.mcs_uts;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ScheduleTeamActivity extends AppCompatActivity implements ScheduleInterface {

    BottomNavigationView bottomNavigationView;
    private RecyclerView recyclerView;
    static List<Schedule> schedules = new ArrayList<Schedule>();

    LinearLayoutManager linearLayoutManager;
    ScheduleAdapter scheduleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_team);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(R.layout.action_bar_custom);
        }

        recyclerView = findViewById(R.id.scheduleRecycleView);

        if(schedules.isEmpty()){
            schedules.add((new Schedule("R1","03 - 05 Mar", "BAHRAIN","SAKHIR","$170 / person", R.drawable.sakhir_layout , R.drawable.bahrain)));
            schedules.add((new Schedule("R2","17 - 19 Mar", "SAUDI ARABIA","JEDDAH","$297 / person", R.drawable.jeddah_layout, R.drawable.saudi_arabia)));
            schedules.add((new Schedule("R3","31 Mar - 02 Apr", "AUSTRALIA","MELBOURNE","$176 / person",R.drawable.melbourne_layout, R.drawable.australia)));
            schedules.add((new Schedule("R4","14 - 16 Apr", "CHINA","SHANGHAI","$165 / person",R.drawable.shanghai_layout, R.drawable.china)));
            schedules.add((new Schedule("R5","28 - 30 Apr", "AZERBAIJAN","BAKU","$135 / person", R.drawable.baku_layout, R.drawable.azerbaijan)));
            schedules.add((new Schedule("R6","05 - 07 May", "USA","MIAMI","$640 / person", R.drawable.miami_layout, R.drawable.usa)));
            schedules.add((new Schedule("R7","19 - 21 May", "ITALY","IMOLA","$260 / person",R.drawable.imola_layout ,R.drawable.italy)));
            schedules.add((new Schedule("R8","26 - 28 May", "MONACO","MONACO","$677 / person", R.drawable.monaco_layout ,R.drawable.monaco)));
            schedules.add((new Schedule("R9","02 - 04 Jun", "SPAIN","BARCELONA","$241 / person",R.drawable.barcelona_layout ,R.drawable.spain)));
            schedules.add((new Schedule("R10","16 - 18 Jun", "CANADA","MONTREAL","$204 / person",R.drawable.montreal_layout, R.drawable.canada)));
            schedules.add((new Schedule("R11","30 Jun - 02 Jul", "AUSTRIA","SPIELBERG","$313 / person",R.drawable.spielberg_layout, R.drawable.austria)));
            schedules.add((new Schedule("R12","07- 09 Jul", "UNITED KINGDOM","SILVERSTONE","$556 / person", R.drawable.silverstone_layout, R.drawable.united_kingdom)));
            schedules.add((new Schedule("R13","21- 23 Jul", "HUNGARY","BUDAPEST","$184 / person",R.drawable.budapest_layout ,R.drawable.hungary)));
            schedules.add((new Schedule("R14","28- 30 Jul", "BELGIUM","SPA-FRANCORCHAMPS","$393 / person",R.drawable.spa_layout, R.drawable.belgium)));
            schedules.add((new Schedule("R15","25 - 27 Aug", "NETHERLANDS","ZANDVOORT","$479 / person",R.drawable.zandvoort_layout, R.drawable.netherlands)));
            schedules.add((new Schedule("R16","01 - 03 Sep", "ITALY","MONZA","$350 / person",R.drawable.monza_layout, R.drawable.italy)));
            schedules.add((new Schedule("R17","15 - 17 Sep", "SINGAPORE","SINGAPORE","$527 / person",R.drawable.singapore_layout, R.drawable.singapore)));
            schedules.add((new Schedule("R18","22 - 24 Sep", "JAPAN","SUZUKA","$341 / person",R.drawable.suzuka_layout, R.drawable.japan)));
            schedules.add((new Schedule("R19","06 - 08 Oct", "QATAR","LOSAIL","$422 / person", R.drawable.losail_layout, R.drawable.qatar)));
            schedules.add((new Schedule("R20","20 - 22 Oct", "USA","AUSTIN","$667 / person", R.drawable.austin_layout, R.drawable.usa)));
            schedules.add((new Schedule("R21","27 - 29 Oct", "MEXICO","MEXICO CITY","$688 / person",R.drawable.mexico_city_layout, R.drawable.mexico)));
            schedules.add((new Schedule("R22","03 - 05 Nov", "BRAZIL","SAO PAULO","$390 / person",R.drawable.sao_paulo_layout,R.drawable.brazil)));
            schedules.add((new Schedule("R23","16 - 18 Nov", "USA","LAS VEGAS","$1667 / person",R.drawable.las_vegas_layout, R.drawable.usa)));
            schedules.add((new Schedule("R24","24 - 26 Nov", "ABU DHABI","YAS MARINA","$546 / person", R.drawable.yas_marina_layout, R.drawable.abu_dhabi)));
        }



        linearLayoutManager = new LinearLayoutManager(ScheduleTeamActivity.this, LinearLayoutManager.VERTICAL,false);

        scheduleAdapter = new ScheduleAdapter(this, schedules, this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(scheduleAdapter);



        bottomNavigationView = findViewById(R.id.bottomNavBar);
        bottomNavigationView.setSelectedItemId(R.id.schedule);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.news:
                    startActivity(new Intent(getApplicationContext(),NewsActivity.class));
                    finish();
                    return true;
                case R.id.schedule:
                    return true;
                case R.id.history:
                    startActivity(new Intent(getApplicationContext(),HistoryActivity.class));
                    finish();
                    return true;
            }
            return false;
        });

    }

    @Override
    public void onScheduleClick(int position) {
        Intent intent = new Intent(ScheduleTeamActivity.this, ScheduleDetailActivity.class);

        intent.putExtra("scheduleCity",schedules.get(position).getScheduleCity());
        intent.putExtra("scheduleCountry",schedules.get(position).getScheduleCountry());
        intent.putExtra("scheduleDate",schedules.get(position).getScheduleDate());
        intent.putExtra("schedulePrice",schedules.get(position).getPrice());
        intent.putExtra("circuitLayout",schedules.get(position).getScheduleImageCircuit());
        intent.putExtra("scheduleFlag",schedules.get(position).getScheduleImageFlag());

        startActivity(intent);

    }
}