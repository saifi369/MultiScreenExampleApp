package com.example.multiscreenexampleapp;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;

public class ScreenUtility {


    public float dpheight;
    public float dpwidth;

    public ScreenUtility(Activity activity) {

        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();

        display.getMetrics(outMetrics);

        //these are absolute pixels
        int heightPixels = outMetrics.heightPixels;
        int widthPixels = outMetrics.widthPixels;

        //these are device independent pixels
        float density = activity.getResources().getDisplayMetrics().density;

        Log.d("MyTag", "ScreenUtility: Density: " + density);

        dpheight = outMetrics.heightPixels / density;
        dpwidth = outMetrics.widthPixels / density;

        Log.d("MyTag", "ScreenUtility: " + dpheight + " x " + dpwidth);

    }

    public String getDeviceDensity(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();

        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        float density = displayMetrics.densityDpi;

        if (density == DisplayMetrics.DENSITY_MEDIUM)
            return "mdpi";
        else if (density == DisplayMetrics.DENSITY_HIGH)
            return "hdpi";
        else if (density == DisplayMetrics.DENSITY_XXHIGH)
            return "xxhdpi";
        return "";
    }

    private String showScreenSize(Activity a) {

        int screenSize = a.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;

        switch (screenSize) {

            case Configuration.SCREENLAYOUT_SIZE_SMALL:
                return "Small Screen";
            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                return "Normal Screen";
            case Configuration.SCREENLAYOUT_SIZE_LARGE:
                return "Large Screen";
            case Configuration.SCREENLAYOUT_SIZE_XLARGE:
                return "Extra Large Screen";
        }
        return "";
    }

    public float getDpheight() {
        return dpheight;
    }

    public float getDpwidth() {
        return dpwidth;
    }
}
