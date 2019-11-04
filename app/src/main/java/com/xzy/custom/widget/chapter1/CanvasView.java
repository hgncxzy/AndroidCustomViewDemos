package com.xzy.custom.widget.chapter1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * 基本图形绘制
 */
public class CanvasView extends View {

    public CanvasView(Context context) {
        super(context);
    }

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CanvasView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 设置画笔的基本属性
        @SuppressLint("DrawAllocation") Paint paint = new Paint();
        paint.setColor(Color.RED); // 设置画笔颜色
        paint.setStyle(Paint.Style.STROKE); // 设置填充样式
        paint.setStrokeWidth(10); // 设置画笔宽度

        // 画圆
        canvas.drawCircle(150, 150, 100, paint);
        // 平移 translate
        paint.setColor(Color.GREEN);
        canvas.translate(100, 100);
        canvas.drawCircle(150, 150, 100, paint);
        // 裁剪 clip
        canvas.clipRect(new Rect(180,180,220,220));
        canvas.drawColor(Color.BLACK);

    }
}
