package com.example.android.topmovies;


import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.security.PublicKey;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList<Movie>> {
    public static final String MOVIE_LIST_URL = "http://api.themoviedb.org/3/movie/popular?api_key=" + BuildConfig.THE_MOVIES_DB_API;
    private MoviesAdapter mAdapter;
    private View rootView;
    public MoviesFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final ArrayList<Movie> movies = new ArrayList<Movie>();
        mAdapter = new MoviesAdapter(getActivity(), movies);
        rootView =  inflater.inflate(R.layout.fragment_movies, container, false);
        GridView gridView = (GridView) rootView.findViewById(R.id.movies_grid_view);
        gridView.setAdapter(mAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Movie movieInfo = movies.get(i);
                int movieId = movieInfo.getmId();
                String movieTitle = movieInfo.getTitle();
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("movieId", movieId);
                intent.putExtra("movieTitle", movieTitle);
                intent.putExtra("synopsis", movieInfo.getSynopsis());
                intent.putExtra("releaseDate", movieInfo.getDate());
                startActivity(intent);

                
            }
        });
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_details, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings){
            Intent intent = new Intent(getActivity(), SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(0 ,null, this);
    }

    @Override
    public Loader<ArrayList<Movie>> onCreateLoader(int id, Bundle args) {
        return new MoviesLoader(getActivity(), MOVIE_LIST_URL);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Movie>> loader, ArrayList<Movie> movs) {
        View loadingIndicator = rootView.findViewById(R.id.loading_spinner);
        loadingIndicator.setVisibility(View.GONE);
        mAdapter.clear();
        if (movs != null && !movs.isEmpty()) {
            mAdapter.addAll(movs);
        }
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<Movie>> loader) {
        mAdapter.clear();
    }
}
