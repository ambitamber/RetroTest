package com.example.retrotest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("v2/top-headlines?country=us&apiKey=5b5ab3f933184289a68cae008cd352d1")
    Call<News> getNews();
}
