package com.example.ashugupta.mvpexample.Home;
import com.example.ashugupta.mvpexample.Model.Film;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashugupta on 01/06/17.
 */

public interface HomeContract {

    interface HomeView{
        void showLoading();

        void hideLoading();

        void showMessage(String message);

        void showTitle(String title);

        void showAllFilms(ArrayList<Film> films);

        void navigateToFilmPage(Film film);

    }
    interface HomePresenter{

        void getAllFilms();

        void onFilmItemClicked(Film film);

    }
}
