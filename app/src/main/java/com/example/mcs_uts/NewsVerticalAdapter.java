package com.example.mcs_uts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsVerticalAdapter extends RecyclerView.Adapter<NewsVerticalViewHolder> {

    private  final NewsInterface newsInterface;
    Context context;
    List<NewsVertical> newsVerticals;

    public NewsVerticalAdapter(Context context, List<NewsVertical> newsVerticals, NewsInterface newsInterface) {
        this.context = context;
        this.newsVerticals = newsVerticals;
        this.newsInterface = newsInterface;
    }

    @NonNull
    @Override
    public NewsVerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsVerticalViewHolder(LayoutInflater.from(context).inflate(R.layout.news_card_vertical,parent,false), newsInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsVerticalViewHolder holder, int position) {
        holder.newsTitleVertical.setText(newsVerticals.get(position).getNewsTitleVertical());
        holder.dateNewsVertical.setText(newsVerticals.get(position).getDateNewsVertical());
        holder.previewNewsVertical.setText(newsVerticals.get(position).getPreviewNewsVertical());
        holder.newsImageVertical.setImageResource(newsVerticals.get(position).getNewsImageVertical());
    }

    @Override
    public int getItemCount() {
        return newsVerticals.size();
    }
}
