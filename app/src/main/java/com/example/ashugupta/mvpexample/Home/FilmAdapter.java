package com.example.ashugupta.mvpexample.Home;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ashugupta.mvpexample.Model.Film;
import com.example.ashugupta.mvpexample.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by ashugupta on 01/06/17.
 */

class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {

    private ArrayList<Film> films;
    private OnFilmItemClickListener onFilmItemClickListener;

    FilmAdapter(ArrayList<Film> films,OnFilmItemClickListener onFilmItemClickListener)
    {
        this.films  = films;
        this.onFilmItemClickListener = onFilmItemClickListener;
    }

    @Override
    public FilmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_film_item,parent,false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FilmViewHolder holder, final int position) {
        holder.title.setText(films.get(position).getTitle() + films.get(position).getEpisode_Id());
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: " + films.get(position).getTitle() + " Clicked");
                onFilmItemClickListener.onFilmClick(films.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        if (films==null)
        {
            return 0;
        }
        else
        return films.size();
    }

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

    class FilmViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        FilmViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }

    interface OnFilmItemClickListener
    {
        void onFilmClick(Film film);
    }
}
