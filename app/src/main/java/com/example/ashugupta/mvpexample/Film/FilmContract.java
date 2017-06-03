package com.example.ashugupta.mvpexample.Film;

/**
 * Created by ashugupta on 01/06/17.
 */

public interface FilmContract {
    interface FilmPresenter{

        void getFilm();


    }
    interface FilmView{
        void showLoading();

        void hideLoading();

        void showMessage(String message);

        void showTitle(String title);

        void showCrawl(String crawl);

    }
}
