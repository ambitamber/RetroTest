package com.example.retrotest.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrotest.Utils.ApiClient;
import com.example.retrotest.Utils.ApiService;
import com.example.retrotest.model.News;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private MutableLiveData<News> newsMutableLiveData;

    //we will call this method to get the data
    public LiveData<News> getNews() {
        //if the list is null
        if (newsMutableLiveData == null) {
            newsMutableLiveData = new MutableLiveData<News>();
            //we will load it asynchronously from server in this method
            loadHeroes();
        }

        //finally we will return the list
        return newsMutableLiveData;
    }

    private void loadHeroes() {
        ApiService apiService = ApiClient.getRetrofit().create(ApiService.class);

        Call<News> call = apiService.getNews();

        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                newsMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });
    }
}
