package com.example.android.quakereport;

/**
 * Created by chaitanya on 31/07/16.
 */
public class QuakeInfo {
    private String mPlace;
    private double mMagnitude;
    private long mDate;
    private String mUrl;

    public QuakeInfo(double mag, String place, long date, String url){
        mDate = date;
        mMagnitude = mag;
        mPlace = place;
        mUrl = url;
    }
    public String getPlace(){
        return mPlace;
    }

    public long getDate(){
        return mDate;
    }

    public double getMagnitude(){
        return mMagnitude;
    }

    public String getUrl(){
        return mUrl;
    }
}
