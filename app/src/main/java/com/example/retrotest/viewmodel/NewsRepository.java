package com.example.retrotest.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.example.retrotest.Utils.ApiClient;
import com.example.retrotest.Utils.ApiService;
import com.example.retrotest.model.News;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {

    private static NewsRepository newsRepository;

    public static NewsRepository getInstance(){
        if (newsRepository == null){
            newsRepository = new NewsRepository();
        }
        return newsRepository;
    }

    private ApiService apiService;

    public NewsRepository(){
        apiService = ApiClient.cteateService(ApiService.class);
    }

    public MutableLiveData<News> getNews(){

        MutableLiveData<News> newsData = new MutableLiveData<>();
        apiService.getNews().enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if (response.isSuccessful()){
                    newsData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                newsData.setValue(null);
            }
        });

        return newsData;
    }
}
