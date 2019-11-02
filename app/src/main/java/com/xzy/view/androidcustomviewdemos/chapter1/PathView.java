package com.xzy.view.androidcustomviewdemos.chapter1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 基本图形绘制
 */
public class PathView extends View {

    public PathView(Context context) {
        super(context);
    }

    public PathView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PathView(Context context, AttributeSet attrs, int defStyle) {
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
        // 画直线路径 -- 画三角形
        @SuppressLint("DrawAllocation") Path path1 = new Path();
        path1.moveTo(100, 100);
        path1.lineTo(100, 400);
        path1.lineTo(500, 400);
        path1.close();
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path1, paint);
        // 画弧线 1
        @SuppressLint("DrawAllocation") Path path2 = new Path();
        path2.moveTo(260, 400);
        @SuppressLint("DrawAllocation") RectF rectF2 = new RectF(100, 440, 300, 640);
        path2.arcTo(rectF2, 0, 90);
        canvas.drawPath(path2, paint);
        // 画弧线 2 -- 使用了 forceMoveTo 属性，强制将弧的起点设置为绘制的起点
        @SuppressLint("DrawAllocation") Path path3 = new Path();
        path3.moveTo(370, 190);
        @SuppressLint("DrawAllocation") RectF rectF3 = new RectF(300, 80, 500, 200);
        path3.arcTo(rectF3, 0, 60, true);
        canvas.drawPath(path2, paint);
    }
}
