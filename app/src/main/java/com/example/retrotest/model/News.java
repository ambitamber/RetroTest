package com.example.retrotest.model;

import java.util.List;

public class News {

    private String status;
    private int totalResults;
    private List<Articles> articles;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    //For total results
    public int getTotalResults() {
        return totalResults;
    }
    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    //For list all of the news articles
    public List<Articles> getArticles() {
        return articles;
    }
    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

}