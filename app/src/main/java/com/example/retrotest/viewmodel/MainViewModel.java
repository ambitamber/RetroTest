package com.example.retrotest.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrotest.model.News;

public class MainViewModel extends ViewModel {

    private MutableLiveData<News> mutableLiveData;
    private NewsRepository newsRepository;

    public void init(){
        if (mutableLiveData != null){
            return;
        }
        newsRepository = NewsRepository.getInstance();
        mutableLiveData = newsRepository.getNews();
    }

    public LiveData<News> getNewsRepository() {
        return mutableLiveData;
    }
}
