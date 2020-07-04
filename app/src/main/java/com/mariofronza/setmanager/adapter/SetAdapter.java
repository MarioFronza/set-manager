package com.mariofronza.setmanager.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mariofronza.setmanager.R;
import com.mariofronza.setmanager.data.Set;

import java.util.List;

public class SetAdapter extends RecyclerView.Adapter<SetAdapter.MyViewHolder> {

    private List<Set> sets;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView firstTeamName;
        public TextView secondTeamName;
        public TextView setFirstPlayerPoints;
        public TextView setSecondPlayerPoints;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            firstTeamName = itemView.findViewById(R.id.tvSetFirstPlayerName);
            secondTeamName = itemView.findViewById(R.id.tvSetSecondPlayerName);
            setFirstPlayerPoints = itemView.findViewById(R.id.tvSetFirstPlayerPoints);
            setSecondPlayerPoints = itemView.findViewById(R.id.tvSetSecondPlayerPoints);
        }
    }

    public SetAdapter(List<Set> sets) {
        this.sets = sets;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.set_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Set set = sets.get(position);
        holder.firstTeamName.setText(set.getFirstTeamName());
        holder.secondTeamName.setText(set.getSecondTeamName());
        holder.setFirstPlayerPoints.setText(Integer.toString(set.getFirstTeamPoints()));
        holder.setSecondPlayerPoints.setText(Integer.toString(set.getSecondTeamPoints()));

        if (set.getWinnerName().equals(set.getFirstTeamName())) {
            holder.firstTeamName.setBackgroundResource(R.color.winnerColor);
            holder.secondTeamName.setBackgroundResource(R.color.loserColor);
        } else {
            holder.secondTeamName.setBackgroundResource(R.color.winnerColor);
            holder.firstTeamName.setBackgroundResource(R.color.loserColor);
        }
    }

    @Override
    public int getItemCount() {
        return sets.size();
    }


}
