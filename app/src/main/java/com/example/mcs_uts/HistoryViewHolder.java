package com.example.mcs_uts;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryViewHolder extends RecyclerView.ViewHolder {
    ImageView historyImage;
    TextView historyTitle, historyPrice, historyDate, historyTotal;

    public HistoryViewHolder(@NonNull View itemView, HistoryInterface historyInterface) {
        super(itemView);
        historyImage = itemView.findViewById(R.id.historyCircuitImage);
        historyTitle = itemView.findViewById(R.id.historyCircuitTitle);
        historyPrice = itemView.findViewById(R.id.historyTotalPrice);
        historyDate = itemView.findViewById(R.id.historyPurchaseDate);
        historyTotal = itemView.findViewById(R.id.historyTotalTicket);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(historyInterface != null){
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        historyInterface.onHistoryClick(position);
                    }
                }
            }
        });
    }

}
