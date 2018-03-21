package com.example.edmonton_tracker;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

import com.google.transit.realtime.GtfsRealtime.FeedMessage;
import com.google.transit.realtime.GtfsRealtime.FeedEntity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * Created by aapae on 3/20/2018.
 */

public class Reader extends Application{
    private static URL url;
    private static Context c;
    private static ArrayList<String> thislist;

    private static FeedMessage feed;
    public void onCreate() {
        super.onCreate();
        c = getApplicationContext();
    }
    public static class getData extends AsyncTask<String, Void, List<FeedEntity>>{
        protected List<FeedEntity> doInBackground(String... from) {
            try {
                if(internet()) {
                    url = new URL(from[0]);
                    FeedMessage feed = FeedMessage.parseFrom(url.openStream());
                    return feed.getEntityList();
                }
                else{
                    return new ArrayList<FeedEntity>();
                }
            } catch (Exception e) {
                return new ArrayList<FeedEntity>();
            }

        }


    }


    public static boolean internet(){
        boolean hasConnection = false;
        Log.e("Error",String.valueOf(c));
        if(c != null){
            try {
                ConnectivityManager cm = (ConnectivityManager) c.getSystemService(CONNECTIVITY_SERVICE);
                if (cm == null) {
                    return false;
                }
                NetworkInfo n = cm.getActiveNetworkInfo();
                if(n != null && n.isConnected()) {
                    hasConnection = true;
                    Log.e("exception",String.valueOf(hasConnection));

                }
            }
            catch(Exception e){
                Log.e("exception",String.valueOf(e));
            }
        }
        hasConnection = true;
        return hasConnection;

    }

}
