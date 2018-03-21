package com.example.edmonton_tracker;

import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.transit.realtime.GtfsRealtime;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class bus extends AppCompatActivity {
    private List<GtfsRealtime.FeedEntity> busList;
    private List<GtfsRealtime.FeedEntity> tripList;
    private Object trips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);
    }
    protected void busBtn(View view) {
        URL url;
        if(Reader.internet()) {
            try {
                url = new URL("https://data.edmonton.ca/resource/qguy-a9de.json");

                busList = getAsList("https://data.edmonton.ca/download/7qed-k2fc/application%2Foctet-stream");
                tripList = getAsList("https://data.edmonton.ca/download/uzpc-8bnm/application%2Foctet-stream");
//                Log.e("busList", String.valueOf(busList));


                vehicles(busList);
                //vehicles(tripList);
            }catch(Exception e){

            }
        }
        else{
            Toast toasty = Toast.makeText(bus.this, "No Internet connection.", Toast.LENGTH_LONG);
            toasty.setGravity(Gravity.CENTER, 0, 300);
            toasty.show();
        }
    }
    private void vehicles(List<GtfsRealtime.FeedEntity> allBus){
        for(int i = 0; i < allBus.size();i++){
            GtfsRealtime.VehiclePosition thisBus = allBus.get(i).getVehicle();
            thisBus.getPosition().getLatitude();
            thisBus.getPosition().getLongitude();
            thisBus.getPosition().getBearing();


        }

    }
    private List<GtfsRealtime.FeedEntity> getAsList(String url){
        try {
            Reader.getData allData = new Reader.getData();
            allData.execute(url);
            return allData.get();
        }
        catch(Exception e){
            Toast toasty = Toast.makeText(bus.this, "Error getting data from City of Edmonton open data", Toast.LENGTH_LONG);
            toasty.setGravity(Gravity.CENTER, 0, 300);
            toasty.show();
            return new ArrayList<GtfsRealtime.FeedEntity>();
        }
    }


}
