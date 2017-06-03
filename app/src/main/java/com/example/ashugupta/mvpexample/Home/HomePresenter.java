package com.example.ashugupta.mvpexample.Home;

import android.util.Log;

import com.example.ashugupta.mvpexample.Home.HomeContract;
import com.example.ashugupta.mvpexample.Model.Apis;
import com.example.ashugupta.mvpexample.Model.Film;
import com.example.ashugupta.mvpexample.Model.FilmResponse;
import com.example.ashugupta.mvpexample.Model.StarWarsApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by ashugupta on 01/06/17.
 */

public class HomePresenter implements HomeContract.HomePresenter {


    private HomeContract.HomeView view;
    private StarWarsApi api;

    HomePresenter(HomeContract.HomeView view)
    {
        this.view  = view;
        api = Apis.getStarWarsApi();
        view.showTitle("All Star Wars Film");
    }


    @Override
    public void getAllFilms() {
        view.showLoading();
        api.getAllFilms().enqueue(new Callback<FilmResponse>() {
            @Override
            public void onResponse(Call<FilmResponse> call, Response<FilmResponse> response) {
                Log.i(TAG, "onResponse: Films Loaded Succesfully" );
                view.showAllFilms((ArrayList)response.body().getResults());
                view.hideLoading();

            }

            @Override
            public void onFailure(Call<FilmResponse> call, Throwable t) {
                view.showMessage(t.getMessage());
                view.hideLoading();
            }
        });
    }

    @Override
    public void onFilmItemClicked(Film film) {
        view.navigateToFilmPage(film);
    }
}
