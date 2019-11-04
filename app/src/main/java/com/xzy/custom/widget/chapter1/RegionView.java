package com.xzy.custom.widget.chapter1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.util.AttributeSet;
import android.view.View;

/**
 * Region 本意不是用来绘图的，是用来构造一个区域的
 */
public class RegionView extends View {

    public RegionView(Context context) {
        super(context);
    }

    public RegionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RegionView(Context context, AttributeSet attrs, int defStyle) {
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

        // 构造一个矩形，但是完全可以用 Rect 代替
        @SuppressLint("DrawAllocation") Region region1 = new Region(new Rect(50, 0, 200, 100));
        drawRegion(canvas, region1, paint);

        // 构造一条椭圆路径
        @SuppressLint("DrawAllocation") Path path = new Path();
        @SuppressLint("DrawAllocation") RectF rectF = new RectF(150, 150, 300, 500);
        path.addOval(rectF, Path.Direction.CCW);
        // 在 setPath 函数中传入一个比椭圆区域小的矩形区域，让其取交集
        @SuppressLint("DrawAllocation") Region region2 = new Region();
        region2.setPath(path, new Region(150, 150, 300, 200));
        // 画出路径
        paint.setStyle(Paint.Style.FILL);
        drawRegion(canvas,region2,paint);

        // 区域相交
        Region region3 = new Region(60,10,250,100);
        // 合并
        region3.union(new Rect(60,10,100,300));
        drawRegion(canvas,region3,paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        // 构造两个矩形
        Rect rect1 = new Rect(400,100,700,200);
        Rect rect2 = new Rect(500,0,600,300);

        canvas.drawRect(rect1,paint);
        canvas.drawRect(rect2,paint);
        // 通过矩形构造两个区域
        Region region11 = new Region(rect1);
        Region region22 = new Region(rect2);
        // 取两个区域的交集
        region11.op(region22, Region.Op.INTERSECT);
        // 构造填充画笔，将所选区域用绿色填充
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        drawRegion(canvas,region11,paint);
    }

    private void drawRegion(Canvas canvas, Region region, Paint paint) {
        RegionIterator iter = new RegionIterator(region);
        Rect rect = new Rect();
        while (iter.next(rect)) {
            canvas.drawRect(rect, paint);
        }
    }
}
