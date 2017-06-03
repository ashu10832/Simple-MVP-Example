package com.example.ashugupta.mvpexample.Home;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;
import com.example.ashugupta.mvpexample.Film.FilmActivity;
import com.example.ashugupta.mvpexample.Model.Film;
import com.example.ashugupta.mvpexample.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeContract.HomeView{
    private static final String TAG = "MainActivity";

    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    FilmAdapter adapter;
    HomePresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        adapter = new FilmAdapter(null, new FilmAdapter.OnFilmItemClickListener() {
            @Override
            public void onFilmClick(Film film) {
                Log.i(TAG, "onFilmClick: " + film.getEpisode_Id());
                presenter.onFilmItemClicked(film);
            }
        });
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getAllFilms();
            }
        });
        presenter = new HomePresenter(this);
        presenter.getAllFilms();
    }

    @Override
    public void showLoading() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showTitle(String title) {
        setTitle(title);
    }



    @Override
    public void showAllFilms(ArrayList<Film> films) {
        Log.i(TAG, "showAllFilms: " + films.size());
        adapter.setFilms(films);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    @Override
    public void navigateToFilmPage(Film film) {
        Intent intent = new Intent(this,FilmActivity.class);
        intent.putExtra("EpisodeId",film.getEpisode_Id());
        Log.i(TAG, "navigateToFilmPage: " + film.getEpisode_Id());
        startActivity(intent);
    }


}
