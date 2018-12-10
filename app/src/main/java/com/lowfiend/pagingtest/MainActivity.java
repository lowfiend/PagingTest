package com.lowfiend.pagingtest;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.lowfiend.pagingtest.adapter.ItemAdapter;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView mEmptyView = findViewById(R.id.emptyView);

        MainVM mainVM = ViewModelProviders.of(this).get(MainVM.class);
        ItemAdapter itemAdapter = new ItemAdapter();
        itemAdapter.setEmptyView(mEmptyView);

        mainVM.mItemLiveData.observe(this, itemAdapter::submitList);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(itemAdapter);
    }
}
