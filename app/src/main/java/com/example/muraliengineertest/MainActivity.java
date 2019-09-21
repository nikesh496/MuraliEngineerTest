package com.example.muraliengineertest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.muraliengineertest.adapter.HitAdapter;
import com.example.muraliengineertest.model.Hits;
import com.example.muraliengineertest.viewmodels.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    HitAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MainViewModel model = ViewModelProviders.of(this).get(MainViewModel.class);

        model.getHits().observe(this, new Observer<List<Hits>>() {
            @Override
            public void onChanged(@Nullable List<Hits> heroList) {
                Log.v("","MainActivity"+heroList.size());
                adapter = new HitAdapter(MainActivity.this, heroList);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
