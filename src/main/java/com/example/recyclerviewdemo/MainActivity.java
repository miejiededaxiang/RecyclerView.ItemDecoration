package com.example.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	private RecyclerView mRecyclerView;
	private List<String> mStringList;
	private MyAdapter mMyAdapter;
	private MyItemDeraction mMyItemDeraction;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mRecyclerView = (RecyclerView) findViewById(R.id.recycler);

		mStringList = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			mStringList.add(i+"text");
		}


		mMyAdapter = new MyAdapter(mStringList,this);
		mMyItemDeraction = new MyItemDeraction();
		DrawOverDecoration  drawOverDecoration = new DrawOverDecoration(this);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
		mRecyclerView.setAdapter(mMyAdapter);
		mRecyclerView.addItemDecoration(mMyItemDeraction);
//		mRecyclerView.addItemDecoration(drawOverDecoration);
	}
}
