package com.example.ashugupta.mvpexample.Model;

import com.example.ashugupta.mvpexample.Model.Film;

import java.util.List;

/**
 * Created by ashugupta on 01/06/17.
 */
public class FilmResponse {
    private List<Film> results;

    public List<Film> getResults() {
        return results;
    }

    public void setResults(List<Film> results) {
        this.results = results;
    }
}
