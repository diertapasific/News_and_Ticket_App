package com.example.mcs_uts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsHorizontalAdapter extends RecyclerView.Adapter<NewsHorizontalViewHolder> {
    private  final NewsInterface newsInterface;
    Context context;
    List<NewsHorizontal> newsHorizontals;

    public NewsHorizontalAdapter(Context context, List<NewsHorizontal> newsHorizontals, NewsInterface newsInterface) {
        this.context = context;
        this.newsHorizontals = newsHorizontals;
        this.newsInterface = newsInterface;
    }

    @NonNull
    @Override
    public NewsHorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsHorizontalViewHolder(LayoutInflater.from(context).inflate(R.layout.news_card_horizontal,parent,false), newsInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHorizontalViewHolder holder, int position) {
        holder.newsHorizontalTitle.setText(newsHorizontals.get(position).getNewsTitleHorizontal());
        holder.newsHorizontalDate.setText(newsHorizontals.get(position).getDateNewsHorizontal());
        holder.newsHorizontalImage.setImageResource(newsHorizontals.get(position).getNewsImageHorizontal());
    }

    @Override
    public int getItemCount() {
        return newsHorizontals.size();
    }
}
