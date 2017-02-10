package com.example.babarmustafa.retrofir_practise.Interfaces;

import com.example.babarmustafa.retrofir_practise.Models.Example;
import com.example.babarmustafa.retrofir_practise.Url.Urls;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by BabarMustafa on 2/1/2017.
 */

public interface GitHubService {
    //to get from
    @GET("users")
    //for singlwe
    //(@Path("user") String user)
    Call<List<Example>> listrepo ();


    //establishing a connection
    Retrofit retrofit = new Retrofit.Builder()
            //url from we get
            .baseUrl(Urls.urls)
            //converting data
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
