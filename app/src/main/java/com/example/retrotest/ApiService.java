package com.example.retrotest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("v2/top-headlines?country=us&apiKey=")
    Call<News> getNews();
}
