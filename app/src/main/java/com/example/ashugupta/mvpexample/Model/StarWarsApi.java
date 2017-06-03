package com.example.ashugupta.mvpexample.Model;

import com.example.ashugupta.mvpexample.Model.FilmResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static android.R.attr.id;

/**
 * Created by ashugupta on 01/06/17.
 */

public interface StarWarsApi {
    @GET("films/")
    Call<FilmResponse> getAllFilms();

    @GET("films/{id}/")
        Call<Film> getFilm(@Path("id") long id);

}
