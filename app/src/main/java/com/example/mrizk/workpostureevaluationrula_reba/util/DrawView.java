package com.example.mrizk.workpostureevaluationrula_reba.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

public class DrawView extends AppCompatImageView {

    private Paint pointPaint;
    private Paint trunkPointPaint;
    private Paint trunkLinePaint;
    private Paint neckPointPaint;
    private Paint neckLinePaint;
    private Paint upperArmPointPaint;
    private Paint upperArmLinePaint;
    private Paint lowerArmPointPaint;
    private Paint lowerArmLinePaint;
    private Paint wristPointPaint;
    private Paint wristLinePaint;
    private Paint legsPointPaint;
    private Paint legsLinePaint;
    private Paint linePaint;
    private List<Point> pointList;
    private List<Line> lineList;

    private String type;

    public DrawView(Context context) {
        super(context);
        pointList = new ArrayList<>();
        lineList = new ArrayList<>();
        initPaint();
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        pointList = new ArrayList<>();
        lineList = new ArrayList<>();
        initPaint();
    }

    public DrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        pointList = new ArrayList<>();
        lineList = new ArrayList<>();
        initPaint();
    }

    private void initPaint() {
        pointPaint = new Paint();
        linePaint = new Paint();
        
        trunkPointPaint = new Paint();
        trunkPointPaint.setColor(Color.RED);
        trunkPointPaint.setStyle(Paint.Style.FILL);
        trunkLinePaint = new Paint();
        trunkLinePaint.setColor(Color.RED);
        trunkLinePaint.setStyle(Paint.Style.STROKE);
        trunkLinePaint.setStrokeWidth(10f);

        neckPointPaint = new Paint();
        neckPointPaint.setColor(Color.BLUE);
        neckPointPaint.setStyle(Paint.Style.FILL);
        neckLinePaint = new Paint();
        neckLinePaint.setColor(Color.BLUE);
        neckLinePaint.setStyle(Paint.Style.STROKE);
        neckLinePaint.setStrokeWidth(10f);

        upperArmPointPaint = new Paint();
        upperArmPointPaint.setColor(Color.YELLOW);
        upperArmPointPaint.setStyle(Paint.Style.FILL);
        upperArmLinePaint = new Paint();
        upperArmLinePaint.setColor(Color.YELLOW);
        upperArmLinePaint.setStyle(Paint.Style.STROKE);
        upperArmLinePaint.setStrokeWidth(10f);

        lowerArmPointPaint = new Paint();
        lowerArmPointPaint.setColor(Color.GREEN);
        lowerArmPointPaint.setStyle(Paint.Style.FILL);
        lowerArmLinePaint = new Paint();
        lowerArmLinePaint.setColor(Color.GREEN);
        lowerArmLinePaint.setStyle(Paint.Style.STROKE);
        lowerArmLinePaint.setStrokeWidth(10f);

        wristPointPaint = new Paint();
        wristPointPaint.setColor(Color.MAGENTA);
        wristPointPaint.setStyle(Paint.Style.FILL);
        wristLinePaint = new Paint();
        wristLinePaint.setColor(Color.MAGENTA);
        wristLinePaint.setStyle(Paint.Style.STROKE);
        wristLinePaint.setStrokeWidth(10f);

        legsPointPaint = new Paint();
        legsPointPaint.setColor(Color.parseColor("#81D4FA"));
        legsPointPaint.setStyle(Paint.Style.FILL);
        legsLinePaint = new Paint();
        legsLinePaint.setColor(Color.parseColor("#81D4FA"));
        legsLinePaint.setStyle(Paint.Style.STROKE);
        legsLinePaint.setStrokeWidth(10f);
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
        for (int i = 0; i < pointList.size(); i++) {
            if (type.equalsIgnoreCase("RULA") && i >= 15) {
                break;
            } else if (type.equalsIgnoreCase("REBA") && i >= 18) {
                break;
            }
            if (i < 3) {
                pointPaint = trunkPointPaint;
                linePaint = trunkLinePaint;
            } else if (i >= 3 && i < 6) {
                pointPaint = neckPointPaint;
                linePaint = neckLinePaint;
            } else if (i >= 6 && i <  9) {
                pointPaint = upperArmPointPaint;
                linePaint = upperArmLinePaint;
            } else if (i >= 9 && i < 12) {
                pointPaint = lowerArmPointPaint;
                linePaint = lowerArmLinePaint;
            } else if (i >= 12 && i < 15) {
                pointPaint = wristPointPaint;
                linePaint = wristLinePaint;
            } else if (i >= 15) {
                pointPaint = legsPointPaint;
                linePaint = legsLinePaint;
            }
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

    public List<Line> getLineList() {
        return lineList;
    }

    public void setLineList(List<Line> lineList) {
        this.lineList = lineList;
    }

    public void clear() {
        lineList.clear();
        pointList.clear();
        invalidate();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
