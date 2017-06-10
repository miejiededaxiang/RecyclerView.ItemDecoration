package com.example.recyclerviewdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by htl on 2017/6/10.
 *
 * 覆盖在view上的装饰
 */

public class DrawOverDecoration extends RecyclerView.ItemDecoration {

	private Paint mPaint;
	private int mDividerHeight;
	private Bitmap mBitmap;


	public DrawOverDecoration(Context mContext) {

		mPaint = new Paint();
		mPaint.setColor(Color.BLUE);
		mPaint.setAntiAlias(true);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setStrokeWidth(5);

		mBitmap = BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.ic_launcher);
	}


	/**
	 * item的偏移，在上下左右都可以 top为在item上方，偏移构成矩形
	 * @param outRect 偏移后构成矩形
	 * @param view
	 * @param parent
	 * @param state
	 */

	@Override
	public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
		super.getItemOffsets(outRect, view, parent, state);


		//当是第一个item时，不进行偏移
		if (parent.getChildAdapterPosition(view) == 0) {
			outRect.top = 0;
		} else {
			outRect.top = 100;
			mDividerHeight = 100;
		}


	}


	/**
	 * 在item上方画
	 * @param c
	 * @param parent
	 * @param state
	 */
	@Override
	public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
		super.onDrawOver(c, parent, state);


		for (int i = 0; i < parent.getChildCount(); i++) {
			View childAt = parent.getChildAt(i);
			int childAdapterPosition = parent.getChildAdapterPosition(childAt);
			if(childAdapterPosition < 3){
				c.drawBitmap(mBitmap,childAt.getLeft(),childAt.getTop(),mPaint);
			}
		}

	}
}
