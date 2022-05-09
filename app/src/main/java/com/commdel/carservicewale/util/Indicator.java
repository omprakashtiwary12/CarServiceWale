package com.commdel.carservicewale.util;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jack Wang on 2016/8/5.
 */

public abstract class Indicator extends Drawable implements Animatable, Animator.AnimatorListener {
     int[] widthRightArr = new int[]{20,
            10,
            0};

     int[] top = new int[]{-10,
            5,
            20};

     int[] bottom = new int[]{0,
            15,
            30};

     int[] widthLeftArr = new int[]{-20,
            -50,
            -40};
    int[] delays = new int[]{120, 2240, 4360};


    private int[] getDelay() {
        int duration=getDuration();
        return new int[]{120, duration+240, duration+duration+360};
    }

    public void setDelays() {
        this.delays = getDelay();
    }

    private int WIDTH;
//    private final int HEIGHT=(int) (DeviceUtils.getDeviceHeight()/1.9);
     int[] x_=new int[] {WIDTH,WIDTH,WIDTH};
//     int[] y_=new int[]{HEIGHT,HEIGHT,HEIGHT};
    private static final Rect ZERO_BOUNDS_RECT = new Rect();
    protected Rect drawBounds = ZERO_BOUNDS_RECT;
    private HashMap<ValueAnimator, ValueAnimator.AnimatorUpdateListener> mUpdateListeners = new HashMap<>();
    private ArrayList<ValueAnimator> mAnimators;
    private int alpha = 255;
    private int animationsEnded=0;
    private boolean mHasAnimators;
    private int duration=8000;

    private Paint mPaint = new Paint();

    public int getDuration() {
        return duration/3;
    }

    public void setDuration(int duration) {
        this.duration = duration;
        setDelays();
    }

    public Indicator() {
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
        x_=new int[] {WIDTH,WIDTH,WIDTH};
    }

    public void reset(){
         widthRightArr = new int[]{20,
                10,
                0};

        widthLeftArr = new int[]{-20,
                -50,
                -40};
          x_=new int[] {WIDTH,WIDTH,WIDTH};
          setDelays();
//         y_=new int[]{HEIGHT,HEIGHT,HEIGHT};
    }

    public int getColor() {
        return mPaint.getColor();
    }

    public void setColor(int color) {
        mPaint.setColor(color);
    }

    @Override
    public int getAlpha() {
        return alpha;
    }

    @Override
    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public void draw(Canvas canvas) {
        draw(canvas, mPaint);
    }

    public abstract void draw(Canvas canvas, Paint paint);
    private boolean isStarted=false;

    @Override
    public void start() {
//        if(isStarted){
//            return;
//        }

        stopAnimators();
        animationsEnded=0;
        reset();
//        setDelays();

        ensureAnimators();

        if (mAnimators == null) {
            return;
        }

        // If the animators has not ended, do nothing.
        if (isStarted()) {
            return;
        }
        startAnimators();
        isStarted=true;
        invalidateSelf();
    }

    private void startAnimators() {
        for (int i = 0; i < mAnimators.size(); i++) {
            ValueAnimator animator = mAnimators.get(i);

            //when the animator restart , add the updateListener again because they
            // was removed by animator stop .
            ValueAnimator.AnimatorUpdateListener updateListener = mUpdateListeners.get(animator);
            if (updateListener != null) {
                animator.addUpdateListener(updateListener);
                animator.addListener(this);
            }

            animator.start();
        }
    }

    private void stopAnimators() {
        if (mAnimators != null) {
            for (ValueAnimator animator : mAnimators) {
                if (animator != null && animator.isStarted()) {
                    animator.removeAllUpdateListeners();
                    animator.end();
                }
            }
        }
    }

    private void ensureAnimators() {
//        if (!mHasAnimators) {
            mAnimators = getAnimators();
//            mHasAnimators = true;
//        }
    }

    private ArrayList<ValueAnimator> getAnimators() {
        ArrayList<ValueAnimator> animators = new ArrayList<>();



        ValueAnimator scaleAnim = ValueAnimator.ofInt(widthLeftArr[0], 10, 10);

        scaleAnim.setDuration(getDuration());
        scaleAnim.setRepeatCount(0);
        scaleAnim.setStartDelay(delays[0]);

        addUpdateListener(scaleAnim, new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                widthLeftArr[0] = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animators.add(scaleAnim);

        scaleAnim = ValueAnimator.ofInt(widthRightArr[2], -30, -30);

        scaleAnim.setDuration(getDuration());
        scaleAnim.setRepeatCount(0);
        scaleAnim.setStartDelay(delays[0]);

        addUpdateListener(scaleAnim, new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                widthRightArr[2] = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animators.add(scaleAnim);




        scaleAnim = ValueAnimator.ofInt(x_[0], x_[0]-DeviceUtils.dpToPixels(30), x_[0]-DeviceUtils.dpToPixels(30));

        scaleAnim.setDuration(getDuration());
        scaleAnim.setRepeatCount(0);
        scaleAnim.setStartDelay(delays[1]);

        addUpdateListener(scaleAnim, new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                x_[0] = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animators.add(scaleAnim);
        scaleAnim = ValueAnimator.ofInt(widthLeftArr[1], 0, 0);

        scaleAnim.setDuration(getDuration());
        scaleAnim.setRepeatCount(0);
        scaleAnim.setStartDelay(delays[1]);

        addUpdateListener(scaleAnim, new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                widthLeftArr[1] = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animators.add(scaleAnim);


        scaleAnim = ValueAnimator.ofInt(0, -50, -50);

        scaleAnim.setDuration(getDuration());
        scaleAnim.setRepeatCount(0);
        scaleAnim.setStartDelay(delays[2]);

        addUpdateListener(scaleAnim, new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                widthLeftArr[1] = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animators.add(scaleAnim);



        scaleAnim = ValueAnimator.ofInt(widthRightArr[0], 50, 50);

        scaleAnim.setDuration(getDuration());
        scaleAnim.setRepeatCount(0);
        scaleAnim.setStartDelay(delays[2]);

        addUpdateListener(scaleAnim, new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                widthRightArr[0] = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animators.add(scaleAnim);

        scaleAnim = ValueAnimator.ofInt(-30, 0, 0);

        scaleAnim.setDuration(getDuration());
        scaleAnim.setRepeatCount(0);
        scaleAnim.setStartDelay(delays[2]);

        addUpdateListener(scaleAnim, new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                widthRightArr[2] = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animators.add(scaleAnim);
        return animators;
    }



    @Override
    public void stop() {
        animationsEnded=0;
        reset();
        stopAnimators();
    }

    private boolean isStarted() {
        for (ValueAnimator animator : mAnimators) {
            return animator.isStarted();
        }
        return false;
    }

    @Override
    public boolean isRunning() {
        for (ValueAnimator animator : mAnimators) {
            return animator.isRunning();
        }
        return false;
    }

    /**
     * Your should use this to add AnimatorUpdateListener when
     * create animator , otherwise , animator doesn't work when
     * the animation restart .
     *
     * @param updateListener
     */
    public void addUpdateListener(ValueAnimator animator, ValueAnimator.AnimatorUpdateListener updateListener) {
        mUpdateListeners.put(animator, updateListener);
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        setDrawBounds(bounds);
    }

    public void setDrawBounds(int left, int top, int right, int bottom) {
        this.drawBounds = new Rect(left, top, right, bottom);
    }

    public void postInvalidate() {
        invalidateSelf();
    }

    public Rect getDrawBounds() {
        return drawBounds;
    }

    public void setDrawBounds(Rect drawBounds) {
        setDrawBounds(drawBounds.left, drawBounds.top, drawBounds.right, drawBounds.bottom);
    }

    public int getWidth() {
        return drawBounds.width();
    }

    public int getHeight() {
        return drawBounds.height();
    }

    public int centerX() {
        return drawBounds.centerX();
    }

    public int centerY() {
        return drawBounds.centerY();
    }

    public float exactCenterX() {
        return drawBounds.exactCenterX();
    }

    public float exactCenterY() {
        return drawBounds.exactCenterY();
    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
        animationsEnded++;
        if(animationsEnded==mAnimators.size() ){
//            int i=0;
//            for (int delay:delays) {
//
//                if(delay==animation.getStartDelay()){
//                    delays[i] +=7000;
//                    animationsEnded=0;
//                }
//                i++;
//            }
            animationsEnded=0;
            reset();
            stopAnimators();
            ensureAnimators();
            startAnimators();
        }

    }


    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {
    }


}