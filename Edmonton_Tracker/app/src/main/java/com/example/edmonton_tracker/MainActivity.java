package com.example.edmonton_tracker;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    protected void busClick(View view){
        Intent intent = new Intent(this, bus.class);
        startActivity(intent);
    }
    protected void alertsClick(View view){
        Intent intent = new Intent(this, CityAlerts.class);
        startActivity(intent);
    }


}
