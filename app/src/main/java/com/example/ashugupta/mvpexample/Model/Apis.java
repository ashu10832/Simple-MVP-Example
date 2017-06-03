package com.example.ashugupta.mvpexample.Model;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ashugupta on 01/06/17.
 */

public class Apis {


    public static StarWarsApi getStarWarsApi()
    {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://swapi.co/api/").addConverterFactory(GsonConverterFactory.create(gson)).build();
        return retrofit.create(StarWarsApi.class);
    }
}
