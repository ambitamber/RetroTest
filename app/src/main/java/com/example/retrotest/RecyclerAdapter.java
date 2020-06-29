package com.example.retrotest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerAdapterHolder>{
    private List<Articles> articlesList;
    private ClickOnItemHandler clickOnItemHandler;

    public RecyclerAdapter(List<Articles> articlesList,ClickOnItemHandler clickOnItemHandler){
        this.articlesList = articlesList;
        this.clickOnItemHandler = clickOnItemHandler;
    }

    public interface ClickOnItemHandler{
        void OnClik(int index);
    }
    public class RecyclerAdapterHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;

        public RecyclerAdapterHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textview);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            clickOnItemHandler.OnClik(position);
        }
    }
    @NonNull
    @Override
    public RecyclerAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutForItem = R.layout.list;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(layoutForItem,parent,false);
        return new RecyclerAdapterHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterHolder holder, int position) {
        holder.textView.setText(articlesList.get(position).getAuthor()+ " " +
                articlesList.get(position).getPublishedAt() );
    }

    @Override
    public int getItemCount() {
        if (articlesList == null){
            return 0;
        }
        return articlesList.size();
    }

}
