package com.kodmap.app.kmrecyclerviewstickyheader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.kodmap.library.kmrecyclerviewstickyheader.KmHeaderItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private KmHeaderItemDecoration kmHeaderItemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initAdapter();
        initData();
    }

    private void initAdapter() {
        adapter = new RecyclerViewAdapter();
        layoutManager = new LinearLayoutManager(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        kmHeaderItemDecoration = new KmHeaderItemDecoration(adapter);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        List<Model> modelList = new ArrayList<>();
        for (Integer i = 1; i < 10; i++) {
            Model headerModel = new Model("Header " + i, ItemType.Header);
            modelList.add(headerModel);
            for (Integer j = 1; j < 8; j++) {
                Model model = new Model("Post " + i + " " + j, ItemType.Post);
                modelList.add(model);
            }
        }
        adapter.submitList(modelList);
    }
}
