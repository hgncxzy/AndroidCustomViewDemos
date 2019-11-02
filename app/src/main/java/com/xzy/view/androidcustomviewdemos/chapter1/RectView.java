package com.xzy.view.androidcustomviewdemos.chapter1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 基本图形绘制
 */
public class RectView extends View {

    public RectView(Context context) {
        super(context);
    }

    public RectView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RectView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 设置画笔的基本属性
        @SuppressLint("DrawAllocation") Paint paint = new Paint();
        paint.setColor(Color.RED); // 设置画笔颜色
        paint.setStyle(Paint.Style.STROKE); // 设置填充样式
        paint.setStrokeWidth(10); // 设置画笔宽度
        // 构造矩形 -- 直接构造制造
        paint.setColor(Color.DKGRAY);
        paint.setStrokeWidth(10);
        @SuppressLint("DrawAllocation") Rect rect1 = new Rect(100, 100, 400, 200);
        canvas.drawRect(rect1,paint);
        // 构造矩形 -- 间接构造
        @SuppressLint("DrawAllocation") Rect rect2 = new Rect();
        rect2.set(100, 200, 300, 300);
        canvas.drawRect(rect2,paint);
        // 构造矩形 -- 使用 RectF 构造
        @SuppressLint("DrawAllocation") RectF rectF = new RectF(130f,300f,450f,400f);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(rectF,paint);
    }
}
