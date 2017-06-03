package com.example.ashugupta.mvpexample.Model;

/**
 * Created by ashugupta on 01/06/17.
 */

public class Film {
    private String title;
    private String opening_crawl;
    private int episode_id;

    public int getEpisode_Id() {
        return episode_id;
    }

    public void setEpisode_Id(int episode_Id) {
        this.episode_id = episode_Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOpening_crawl() {
        return opening_crawl;
    }

    public void setOpening_crawl(String opening_crawl) {
        this.opening_crawl = opening_crawl;
    }
}
