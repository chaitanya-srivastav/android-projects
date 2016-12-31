package com.example.android.topmovies;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by chaitanya on 15/08/16.
 */
public class MoviesAdapter extends ArrayAdapter<Movie> {

    public MoviesAdapter(Activity context, List<Movie> minfo) {
        super(context, 0 ,minfo);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null){
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.grid_item_movies, parent, false);
        }
        Movie mInfo = getItem(position);
        ImageView imageView = (ImageView) listItem.findViewById(R.id.movies_grid);
        imageView.setImageBitmap(mInfo.getmImageUrl());
        return listItem;
    }
}
