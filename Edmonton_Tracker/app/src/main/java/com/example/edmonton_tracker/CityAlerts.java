package com.example.edmonton_tracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CityAlerts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_alerts);
    }
    protected void alertBtn(View view) {
        Reader.getData allData = new Reader.getData();
        allData.execute("https://data.edmonton.ca/download/rqaa-jae6/application%2Foctet-stream");

    }
}
