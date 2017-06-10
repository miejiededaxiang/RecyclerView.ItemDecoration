package com.example.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by htl on 2017/6/9.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHodler> {



	private List<String> mStringList;
	private Context mContext;

	public MyAdapter(List<String> stringList, Context context) {
		mStringList = stringList;
		mContext = context;
	}

	@Override
	public MyHodler onCreateViewHolder(ViewGroup parent, int viewType) {

		View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_item,parent,false);
		MyHodler hodler = new MyHodler(view);
		return hodler;
	}

	@Override
	public int getItemCount() {
		return mStringList.size();
	}

	@Override
	public void onBindViewHolder(MyHodler holder, int position) {

		String s = mStringList.get(position);
		holder.mTextView.setText(s);

	}



	class MyHodler extends RecyclerView.ViewHolder {

		TextView mTextView;

		public MyHodler(View itemView) {
			super(itemView);

			mTextView = (TextView) itemView.findViewById(R.id.text);
		}
	}
}
