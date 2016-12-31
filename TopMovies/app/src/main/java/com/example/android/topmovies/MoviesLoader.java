package com.example.android.topmovies;

import android.app.LoaderManager;
import android.graphics.Bitmap;
import android.support.v4.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;
import android.webkit.URLUtil;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by chaitanya on 15/08/16.
 */
public class MoviesLoader extends AsyncTaskLoader<ArrayList<Movie>> {
    private String mUrl;
    public MoviesLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }
    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public ArrayList<Movie> loadInBackground() {
        URL url = Utitlities.makeURL(mUrl);
        String json = Utitlities.CollectResponse(url);
        return Utitlities.fetchJson(json);
    }
}