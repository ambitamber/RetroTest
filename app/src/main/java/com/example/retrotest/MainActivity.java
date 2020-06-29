package com.example.retrotest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.ClickOnItemHandler{

    private News newsList;
    private List<Articles> articlesList;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.error_tv);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<News> call = apiService.getNews();

        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if (!response.isSuccessful()){
                    textView.setText("Code" + response.code());
                    return;
                }
                newsList = response.body();
                textView.setText(newsList.getStatus());
                articlesList = newsList.getArticlesList();
                createView(articlesList);
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });

    }

    private void createView (List<Articles> articlesList){
        recyclerAdapter = new RecyclerAdapter(articlesList,this);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void OnClik(int index) {

    }
}