package com.example.mcs_uts;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsHorizontalViewHolder extends RecyclerView.ViewHolder {
    ImageView newsHorizontalImage;
    TextView newsHorizontalTitle,newsHorizontalDate;

    public NewsHorizontalViewHolder(@NonNull View itemView, NewsInterface newsInterface) {
        super(itemView);
        newsHorizontalImage = itemView.findViewById(R.id.imageNewsHorizontal);
        newsHorizontalTitle = itemView.findViewById(R.id.titleNewsHorizontal);
        newsHorizontalDate = itemView.findViewById(R.id.dateNewsHorizontal);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(newsInterface != null){
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        newsInterface.onNewsClick(position);
                    }
                }
            }
        });
    }
}
