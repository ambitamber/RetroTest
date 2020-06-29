package com.example.retrotest;

import java.util.List;

public class News {

    private String status;
    private int totalResults;
    private List<Articles> articles;

    public News(String status,int totalResults,List<Articles> articlesList){
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articlesList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<Articles> getArticlesList() {
        return articles;
    }

    public void setArticlesList(List<Articles> articlesList) {
        this.articles = articlesList;
    }
}
