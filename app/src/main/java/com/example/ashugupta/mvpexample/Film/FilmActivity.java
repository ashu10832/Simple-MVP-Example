package com.example.ashugupta.mvpexample.Film;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ashugupta.mvpexample.R;

public class FilmActivity extends AppCompatActivity implements FilmContract.FilmView{

    ProgressBar progressBar;
    TextView crawl;
    FilmContract.FilmPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        crawl = (TextView) findViewById(R.id.crawl);
        presenter = new FilmPresenter(getIntent().getIntExtra("EpisodeId",0),this);
        presenter.getFilm();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
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
    public void showCrawl(String crawl) {
        this.crawl.setText(crawl);
    }
}
