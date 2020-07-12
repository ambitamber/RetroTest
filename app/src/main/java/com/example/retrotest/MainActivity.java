package com.example.retrotest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.retrotest.adapter.RecyclerAdapter;
import com.example.retrotest.Utils.ApiClient;
import com.example.retrotest.Utils.ApiService;
import com.example.retrotest.model.Articles;
import com.example.retrotest.model.News;
import com.example.retrotest.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.ClickOnItemHandler{

    ArrayList<Articles> articlesArrayList;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        articlesArrayList = new ArrayList<>();
        textView = findViewById(R.id.error_tv);

        MainViewModel mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
       mainViewModel.init();
       mainViewModel.getNewsRepository().observe(this, new Observer<News>() {
           @Override
           public void onChanged(News news) {
               List<Articles> articlesList = news.getArticles();
               articlesArrayList.addAll(articlesList);
               setupRecyclerView(articlesArrayList);
           }
       });
    }

    private void setupRecyclerView(ArrayList<Articles> articles) {

            recyclerAdapter = new RecyclerAdapter(articles,this);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(recyclerAdapter);

    }

    @Override
    public void OnClik(int index) {

    }
}