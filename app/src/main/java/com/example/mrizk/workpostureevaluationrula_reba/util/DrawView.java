package com.example.mrizk.workpostureevaluationrula_reba.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

public class DrawView extends AppCompatImageView {

    private static final String TAG = "DrawView";

    private Paint pointPaint;
    private Paint linePaint;
    private List<Point> pointList;
    private List<Line> lineList;
    private List<Double> listDegrees;

    public DrawView(Context context) {
        super(context);
        pointList = new ArrayList<>();
        lineList = new ArrayList<>();
        listDegrees = new ArrayList<>();
        initPaint();
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        pointList = new ArrayList<>();
        lineList = new ArrayList<>();
        listDegrees = new ArrayList<>();
        initPaint();
    }

    public DrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        pointList = new ArrayList<>();
        lineList = new ArrayList<>();
        listDegrees = new ArrayList<>();
        initPaint();
    }

    private void initPaint() {
        Log.d(TAG, "initPaint: called");
        pointPaint = new Paint();
        pointPaint.setColor(Color.BLUE);
        pointPaint.setStyle(Paint.Style.FILL);
        linePaint = new Paint();
        linePaint.setColor(Color.BLUE);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(10f);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int eventX = Math.round(event.getX());
        int eventY = Math.round(event.getY());

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            pointList.add(new Point(eventX, eventY));
            invalidate();
        }
        return false;
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        lineList.clear();
        listDegrees.clear();
        for (int i = 0; i < pointList.size(); i++) {
            canvas.drawCircle(pointList.get(i).x, pointList.get(i).y, 20f, pointPaint);
            if (pointList.size() > 1 && i >= 1) {
                if (!(i % 3 == 0)) {
                    canvas.drawLine(pointList.get(i-1).x, pointList.get(i-1).y, pointList.get(i).x, pointList.get(i).y, linePaint);
                    lineList.add(new Line(pointList.get(i-1).x, pointList.get(i-1).y, pointList.get(i).x, pointList.get(i).y));
                }
            }
        }
    }

    public double calculateAngle(Line a, Line b) {
        double pointX1 = a.xStart;
        double pointY1 = a.yStart;
        double pointX2 = b.xFinish;
        double pointY2 = b.yFinish;
        double fixedX = a.xFinish;
        double fixedY = a.yFinish;

        double angle1 = Math.atan2(pointY1 - fixedY, pointX1 - fixedX);
        double angle2 = Math.atan2(pointY2 - fixedY, pointX2 - fixedX);

        double angle = angle1 - angle2;
        return angle;
    }

    public static class Line {
        float xStart;
        float yStart;
        float xFinish;
        float yFinish;

        public Line(float xStart, float yStart, float xFinish, float yFinish) {
            this.xStart = xStart;
            this.yStart = yStart;
            this.xFinish = xFinish;
            this.yFinish = yFinish;
        }
    }
}
