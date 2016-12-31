package com.example.android.topmovies;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by chaitanya on 15/08/16.
 */
public class Utitlities {
    public static URL makeURL(String url){
        URL movieURL = null;
        try {
            movieURL = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return movieURL;
    }

    public static String CollectResponse(URL url){
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;
        String jsonResponse = "";
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            StringBuilder output = new StringBuilder();
            String line = reader.readLine();
            while (line != null){
                output.append(line);
                line = reader.readLine();
            }
            jsonResponse = output.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return jsonResponse;
    }

    public static ArrayList<Movie> fetchJson(String json){
        ArrayList<Movie> movieTitle = new ArrayList<Movie>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray results = jsonObject.optJSONArray("results");
            for (int i = 0; i < results.length(); i++){
                JSONObject movie = results.getJSONObject(i);
                int movie_id = movie.getInt("id");
                String title = movie.getString("original_title");
                String image_url = movie.getString("poster_path");
                String synopsis = movie.getString("overview");
                String date = movie.getString("release_date");
                Bitmap image = downloadImage("https://image.tmdb.org/t/p/w370_and_h556_bestv2" + image_url);
                movieTitle.add(new Movie(image, movie_id, title, synopsis, date));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return movieTitle;
    }

    public static Bitmap downloadImage(String url){
        URL image_url = makeURL(url);
        Bitmap bmp = null;
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = (HttpURLConnection) image_url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            bmp = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return bmp;
    }
}
