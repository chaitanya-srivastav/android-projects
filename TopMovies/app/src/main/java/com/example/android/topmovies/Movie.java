package com.example.android.topmovies;

import android.graphics.Bitmap;

/**
 * Created by chaitanya on 16/08/16.
 */
public class Movie {
    private Bitmap mImageUrl;
    private int mId;
    private String mtitle;
    private String mSynopsis;
    private String mDate;

    public Movie(Bitmap image, int id, String title, String synopsis, String date){
        mId = id;
        mImageUrl = image;
        mtitle = title;
        mSynopsis = synopsis;
        mDate = date;
    }
    public Bitmap getmImageUrl(){
        return mImageUrl;
    }
    public int getmId(){
        return mId;
    }
    public String getSynopsis(){
        return mSynopsis;
    }
    public String getDate(){
        return mDate;
    }
    public String getTitle(){
        return mtitle;
    }
}
