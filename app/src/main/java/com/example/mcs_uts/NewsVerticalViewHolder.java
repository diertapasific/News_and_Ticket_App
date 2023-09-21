package com.example.mcs_uts;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class NewsVerticalViewHolder extends RecyclerView.ViewHolder {

    TextView newsTitleVertical, dateNewsVertical, previewNewsVertical;
    ImageView newsImageVertical;
    public NewsVerticalViewHolder(View itemView, NewsInterface newsInterface) {
        super(itemView);
        newsTitleVertical = itemView.findViewById(R.id.titleNewsVertical);
        dateNewsVertical = itemView.findViewById(R.id.dateNewsVertical);
        previewNewsVertical = itemView.findViewById(R.id.previewNewsVertical);
        newsImageVertical = itemView.findViewById(R.id.imageNewsVertical);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(newsInterface != null){
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        newsInterface.onNewsClickVertical(position);
                    }
                }
            }
        });
    }
}
