package com.fatsoon.chuohongbaodemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by fanshuo on 15/2/12.
 */
public class TouchView extends SurfaceView implements
        SurfaceHolder.Callback{

    private SurfaceHolder holder;
    private Paint pointPaint;// 红色触摸点

    public TouchView(Context context) {
        super(context);
        initHolder();
    }

    public TouchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initHolder();
    }

    public TouchView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initHolder();
    }

    void initHolder(){
        holder = getHolder();
        holder.addCallback(this);
        holder.setFormat(PixelFormat.TRANSPARENT);
        initPaint();
    }

    void initPaint(){
        this.pointPaint = new Paint();
        this.pointPaint.setAntiAlias(true);
        this.pointPaint.setColor(getResources().getColor(android.R.color.holo_red_dark));
        this.pointPaint.setStrokeWidth(1.0f);
    }

    /**
     * 画一个红点，半径设为和小红人宽度大致相同
     */
    void drawDot(float x, float y){
        Canvas canvas = this.holder.lockCanvas();
        canvas.drawColor(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC);
        canvas.drawCircle(x,y,75, pointPaint);
        this.holder.unlockCanvasAndPost(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                //当被点击的时候画出点击的位置
                drawDot(event.getX(), event.getY());
                break;
        }
        return true;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Canvas canvas = this.holder.lockCanvas();
        canvas.drawColor(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC);
        this.holder.unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
