package com.example.muraliengineertest.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muraliengineertest.R;
import com.example.muraliengineertest.model.Hits;

import java.util.List;

public class HitAdapter extends RecyclerView.Adapter<HitAdapter.HitAdapterHolder> {

    Context mCtx;
    List<Hits> hitList;

    public HitAdapter(Context mCtx,List<Hits> hitsList){
        this.mCtx = mCtx;
        this.hitList = hitsList;
        Log.v("","hitList"+hitList.size());
    }


    @NonNull
    @Override
    public HitAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.card_layout, parent, false);
        return new HitAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HitAdapterHolder holder, int position) {
        Hits hits = hitList.get(position);


        Log.v("","hitList title"+hitList.get(position).getTitle());
        Log.v("","hitList creted"+hitList.get(position).getCreated_at());

        holder.title.setText(hits.getTitle());
        holder.creted_at.setText(hits.getCreated_at());

        holder.toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Log.v("","isChecked true");
                }else {
                    Log.v("","isChecked false");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if(hitList!=null){
            return hitList.size();
        }else {
            return 0;
        }
    }

    public class HitAdapterHolder extends RecyclerView.ViewHolder {

        private ToggleButton toggle;
        private TextView title,creted_at;

        public HitAdapterHolder(@NonNull View itemView) {
            super(itemView);

            toggle = itemView.findViewById(R.id.toggleCheck);
            title = itemView.findViewById(R.id.text_title);
            creted_at = itemView.findViewById(R.id.text_created);
        }
    }

}
