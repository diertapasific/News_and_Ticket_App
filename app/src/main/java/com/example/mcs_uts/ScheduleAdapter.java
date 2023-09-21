package com.example.mcs_uts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleViewHolder> {
    private final  ScheduleInterface scheduleInterface;
    Context context;
    List<Schedule> schedules;

    public ScheduleAdapter(Context context, List<Schedule> schedules,  ScheduleInterface scheduleInterface) {
        this.context = context;
        this.schedules = schedules;
        this.scheduleInterface = scheduleInterface;
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ScheduleViewHolder(LayoutInflater.from(context).inflate(R.layout.schedule_card,parent,false),scheduleInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
        holder.rLetter.setText(schedules.get(position).getrLetter());
        holder.scheduleDate.setText(schedules.get(position).getScheduleDate());
        holder.scheduleCountry.setText(schedules.get(position).getScheduleCountry());
        holder.scheduleCity.setText(schedules.get(position).getScheduleCity());
        holder.scheduleImageFlag.setImageResource(schedules.get(position).getScheduleImageFlag());
        holder.scheduleImageFlag.setImageResource(schedules.get(position).getScheduleImageFlag());
    }

    @Override
    public int getItemCount() {
        return schedules.size();
    }
}
