package com.example.mcs_uts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryViewHolder>{
    private final HistoryInterface historyInterface;
    Context context;
    List<History> histories;

    public  HistoryAdapter(Context context, List<History> histories, HistoryInterface historyInterface){
        this.context = context;
        this.histories = histories;
        this.historyInterface = historyInterface;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HistoryViewHolder(LayoutInflater.from(context).inflate(R.layout.history_card,parent,false),historyInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        holder.historyTitle.setText(histories.get(position).getTitle());
        holder.historyPrice.setText(histories.get(position).getPrice());
        holder.historyDate.setText(histories.get(position).getDate());
        holder.historyTotal.setText(histories.get(position).getTotal());
        holder.historyImage.setImageResource(histories.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return histories.size();
    }
}
