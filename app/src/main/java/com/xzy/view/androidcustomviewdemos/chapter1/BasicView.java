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
public class BasicView extends View {

    public BasicView(Context context) {
        super(context);
    }

    public BasicView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BasicView(Context context, AttributeSet attrs, int defStyle) {
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

        // 画圆
        canvas.drawCircle(390, 300, 150, paint);
        // 画直线
        canvas.drawLine(140, 50, 100, 150, paint);
        // 画点
        canvas.drawPoint(460, 460, paint);
        // 构造矩形 -- 直接构造制造
        @SuppressLint("DrawAllocation") Rect rect1 = new Rect(10, 10, 100, 100);
        canvas.drawRect(rect1,paint);
        // 构造矩形 -- 间接构造
        @SuppressLint("DrawAllocation") Rect rect2 = new Rect();
        rect2.set(290, 290, 200, 200);
        canvas.drawRect(rect2,paint);
        // 构造矩形 -- 使用 RectF 构造
        @SuppressLint("DrawAllocation") RectF rectF = new RectF(210f,10f,300f,100f);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(rectF,paint);


    }
}
