package com.example.mcs_uts;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ScheduleDetailActivity extends AppCompatActivity {

    Button buttonBuyTicket;
    EditText totalAmountTicket;
    static String schedulePrice;
    SharedPreferences userlogin, userhistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_detail);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(R.layout.action_bar_custom);
        }

        String scheduleCity = getIntent().getStringExtra("scheduleCity");
        String scheduleCountry = getIntent().getStringExtra("scheduleCountry");
        String scheduleDate = getIntent().getStringExtra("scheduleDate");
        schedulePrice = getIntent().getStringExtra("schedulePrice");
        int circuitLayout = getIntent().getIntExtra("circuitLayout",0);
        int scheduleFlag = getIntent().getIntExtra("scheduleFlag",0);

        TextView scheduleCityTV = findViewById(R.id.scheduleCityCircuit);
        TextView scheduleCountryTV = findViewById(R.id.scheduleCountryCircuit);
        TextView scheduleDateTV = findViewById(R.id.scheduleDateCircuit);
        TextView priceCircuitTV = findViewById(R.id.priceCircuit);
        ImageView circuitLayoutIV = findViewById(R.id.imageLayoutCircuit);
        ImageView imageFlagCircuitIV = findViewById(R.id.imageFlagCircuit);

        scheduleCityTV.setText(scheduleCity);
        scheduleCountryTV.setText(scheduleCountry);
        scheduleDateTV.setText(scheduleDate);
        priceCircuitTV.setText(schedulePrice);
        circuitLayoutIV.setImageResource(circuitLayout);
        imageFlagCircuitIV.setImageResource(scheduleFlag);

        buttonBuyTicket = findViewById(R.id.buttonBuyTicket);
        totalAmountTicket = findViewById(R.id.totalAmountTicket);

        buttonBuyTicket.setOnClickListener(view -> {
            if(totalAmountTicket.getText().toString().matches("")){
                Toast toast = Toast.makeText(ScheduleDetailActivity.this, "Input Amount!", Toast.LENGTH_LONG);
            } else if(Integer.parseInt(totalAmountTicket.getText().toString())<1){
                Toast toast = Toast.makeText(ScheduleDetailActivity.this, "Input Valid Amount!", Toast.LENGTH_LONG);
            } else{
                int amount = Integer.parseInt(totalAmountTicket.getText().toString());
                userlogin = getSharedPreferences("userlogin", MODE_PRIVATE);
                String userLogin = userlogin.getString("userlogin","");

                userhistory = getSharedPreferences(userLogin + "history", MODE_PRIVATE);
                SharedPreferences.Editor editor = userhistory.edit();

                Map<String, ?> allEntries = userhistory.getAll();
                int count = allEntries.size();
                String id = Integer.toString(count);

                Date currentDate = new Date();
                DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
                String dateString = dateFormat.format(currentDate);

                int priceInt = Integer.parseInt(schedulePrice.substring(1, 4));

                editor.putString("title"+id,scheduleCity);
                editor.putString("price"+id,"$"+(priceInt*amount));
                editor.putString("date"+id,dateString);
                editor.putString("total"+id,Integer.toString(amount)+ " Tickets");
                editor.putString("image"+id,Integer.toString(scheduleFlag));
                editor.apply();

                Intent intent = new Intent(this, ScheduleTeamActivity.class);
                startActivity(intent);
                Toast toast = Toast.makeText(ScheduleDetailActivity.this, "Purchase Success!", Toast.LENGTH_LONG);
                toast.show();

            }
        });

    }


}