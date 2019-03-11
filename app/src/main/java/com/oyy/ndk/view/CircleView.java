package com.oyy.ndk.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * create by ouyangyi@manqian.cn
 * on 2019/3/6 14:16
 * Description: ${DESCRIPTION}
 */
public class CircleView extends View {

    private Paint mPaintPoint;

    private Paint mPaintCircle;
    private int mCircleRadius;  //半径

    private int centerX;
    private int centerY;   //圆心坐标


    private List<PointF> mPointDatas; //放置四个数据点的集合
    private List<PointF> mPointControlls;//方式8个控制点的集合


    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化
     */
    public void init() {
        mPaintPoint = new Paint();
        mPaintPoint.setStrokeWidth(5);
        mPaintPoint.setColor(Color.BLACK);
        mPaintPoint.setStyle(Paint.Style.FILL);
        mPaintPoint.setAntiAlias(true);

        mPaintCircle = new Paint();
        mPaintCircle.setColor(Color.RED);
        mPaintCircle.setStrokeWidth(10);
        mPaintCircle.setStyle(Paint.Style.STROKE);
        mPaintCircle.setAntiAlias(true);

        mCircleRadius = 150;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = getWidth() / 2;
        centerY = getHeight() / 2;

        mPointDatas = new ArrayList<>();
        mPointControlls = new ArrayList<>();

        mPointDatas.add(new PointF(centerX - mCircleRadius, centerY));
        mPointDatas.add(new PointF(centerX, centerY - mCircleRadius));
        mPointDatas.add(new PointF(centerX + mCircleRadius, centerY));
        mPointDatas.add(new PointF(centerX, centerY + mCircleRadius));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        //绘制x,y轴
        canvas.drawLine(0, centerY, getWidth(), centerY, mPaintPoint);
        canvas.drawLine(centerX, 0, centerX, getHeight(), mPaintPoint);

        mPaintPoint.setColor(Color.RED);
        //绘制数据点
        for (int i = 0; i < mPointDatas.size(); i++) {

            canvas.drawPoint(mPointDatas.get(i).x, mPointDatas.get(i).y, mPaintPoint);

        }
    }
}
