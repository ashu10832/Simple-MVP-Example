package com.example.ashugupta.mvpexample.Film;

import android.util.Log;
import android.view.View;

import com.example.ashugupta.mvpexample.Model.Apis;
import com.example.ashugupta.mvpexample.Model.Film;
import com.example.ashugupta.mvpexample.Model.StarWarsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by ashugupta on 01/06/17.
 */

public class FilmPresenter implements FilmContract.FilmPresenter {
    int id;
    FilmContract.FilmView view;
    StarWarsApi api;

    FilmPresenter(int id,FilmContract.FilmView view)
    {
        this.id = id;
        this.view = view;
    }
    @Override
    public void getFilm() {
        view.showLoading();
        api = Apis.getStarWarsApi();
        Log.i(TAG, "getFilm: " + id);
        api.getFilm(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                Film film =  response.body();
                view.showTitle(film.getTitle());
                view.showCrawl(film.getOpening_crawl());
                view.showMessage("Film Loaded!");
                view.hideLoading();
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                view.hideLoading();
                view.showMessage(t.getMessage());
            }
        });
    }
}
