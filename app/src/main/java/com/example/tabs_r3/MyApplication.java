package com.example.tabs_r3;

import android.app.Application;

import java.util.ArrayList;

public class MyApplication extends Application {

    public static ArrayList<String> names;

    @Override
    public void onCreate() {
        super.onCreate();
        names = new ArrayList<>();
        names.add("Ali 1");
        names.add("Ali 2");
        names.add("Ali 3");
        names.add("Ali 4");
    }
}
