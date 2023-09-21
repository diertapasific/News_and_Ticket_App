package com.example.mcs_uts;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ScheduleViewHolder extends RecyclerView.ViewHolder {
    ImageView scheduleImageFlag;
    TextView rLetter, scheduleDate, scheduleCountry, scheduleCity;

    public ScheduleViewHolder(@NonNull View itemView,  ScheduleInterface scheduleInterface) {
        super(itemView);
        rLetter = itemView.findViewById(R.id.scheduleRletter);
        scheduleDate = itemView.findViewById(R.id.scheduleDate);
        scheduleCountry = itemView.findViewById(R.id.scheduleCountry);
        scheduleCity = itemView.findViewById(R.id.scheduleCity);
        scheduleImageFlag = itemView.findViewById(R.id.scheduleImageFlag);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(scheduleInterface != null){
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        scheduleInterface.onScheduleClick(position);
                    }
                }
            }
        });
    }
}
