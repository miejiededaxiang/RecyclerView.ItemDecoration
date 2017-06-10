package com.example.recyclerviewdemo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by htl on 2017/6/9.
 */

public class MyItemDeraction extends RecyclerView.ItemDecoration {


	private Paint mPaint;
	private int mDividerHeight,mOffsetLeft;
	private float mRadiu;

	public MyItemDeraction() {

		mPaint = new Paint();
		mPaint.setColor(Color.BLUE);
		mPaint.setAntiAlias(true);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setStrokeWidth(5);
		mRadiu = 10;
	}

	@Override
	public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
		super.getItemOffsets(outRect, view, parent, state);

		if (parent.getChildAdapterPosition(view) == 0) {
			outRect.top = 0;
		} else {
			outRect.top = 5;
			mDividerHeight = 5;
		}

		//view的左右的padding
		outRect.left = 60;
		mOffsetLeft = 60;

	}


	/**
	 * 在item下方画
	 * @param c
	 * @param parent
	 * @param state
	 */

	@Override
	public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
		super.onDraw(c, parent, state);

		if (parent.getChildCount() == 0) return;

		float circleX = (parent.getPaddingLeft() + mOffsetLeft)/2;



		for (int i = 0; i < parent.getChildCount(); i++) {
			View view = parent.getChildAt(i);
			int top = view.getTop() - mDividerHeight;
			int left = view.getLeft();
			int right = parent.getWidth()-parent.getPaddingRight() ;
			c.drawRect(left, top, right, view.getTop(), mPaint);

			float circleY = view.getTop() + mRadiu;

			c.drawCircle(circleX,circleY,mRadiu,mPaint);

			float upLineStartY = top;
			float uPLineEndY = circleY - mRadiu;

			c.drawLine(circleX,upLineStartY,circleX,uPLineEndY,mPaint);

			float downLineStartY = circleY + mRadiu;
			float downLineEndY =  view.getBottom();

			c.drawLine(circleX,downLineStartY,circleX,downLineEndY,mPaint);
		}
	}
}
