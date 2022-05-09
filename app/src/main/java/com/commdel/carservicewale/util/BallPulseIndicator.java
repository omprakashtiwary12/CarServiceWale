package com.commdel.carservicewale.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by Jack on 2015/10/16.
 */
public class BallPulseIndicator extends Indicator {


    //scale x ,y

    private Canvas mCanvas;
    private Paint mPaintl;

    public Canvas getmCanvas() {
        return mCanvas;
    }

    public void setmCanvas(Canvas mCanvas) {
        this.mCanvas = mCanvas;
    }

    public Paint getmPaintl() {
        return mPaintl;
    }

    public void setmPaintl(Paint mPaintl) {
        this.mPaintl = mPaintl;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
//        paint.setColor(ge);
        if(getWIDTH()==0){
            setWIDTH(canvas.getWidth()/2);
        }


        for (int i = 0; i <3 ; i++) {

            canvas.save();
            canvas.translate( x_[i],canvas.getHeight()/2);
            canvas.drawPath(RoundedRect(  DeviceUtils.dpToPixels(widthLeftArr[i]),
                    DeviceUtils.dpToPixels(top[i]),
                    DeviceUtils.dpToPixels(widthRightArr[i])
                    ,  DeviceUtils.dpToPixels(bottom[i])
                    , DeviceUtils.dpToPixels(5)
                    , DeviceUtils.dpToPixels(5)
                    , false), paint);
            canvas.restore();

        }
        this.mCanvas=canvas;
        this.mPaintl=paint;




//        canvas.save();
//        canvas.drawPath(RoundedRect(
//                x - DeviceUtils.dpToPixels(50)
//                , y + DeviceUtils.dpToPixels(15)
//                , x + DeviceUtils.dpToPixels(10)
//                , y + DeviceUtils.dpToPixels(25)
//                , DeviceUtils.dpToPixels(5)
//                , DeviceUtils.dpToPixels(5)
//                , false), paint);
//        canvas.restore();
//        canvas.save();
//
//        canvas.drawPath(RoundedRect(
//                x - DeviceUtils.dpToPixels(40)
//                , y + DeviceUtils.dpToPixels(30)
//                , widthRightArr[2] > 0 ? x + DeviceUtils.dpToPixels(widthRightArr[2]) : x - DeviceUtils.dpToPixels(Math.abs(widthRightArr[2]))
//                , y + DeviceUtils.dpToPixels(40)
//                , DeviceUtils.dpToPixels(5)
//                , DeviceUtils.dpToPixels(5), false), paint);
//        canvas.restore();

    }

    Path RoundedRect(float left, float top, float right, float bottom, float rx, float ry, boolean conformToOriginalPost) {
        Path path = new Path();
        if (rx < 0) rx = 0;
        if (ry < 0) ry = 0;
        float width = right - left;
        float height = bottom - top;
        if (rx > width / 2) rx = width / 2;
        if (ry > height / 2) ry = height / 2;
        float widthMinusCorners = (width - (2 * rx));
        float heightMinusCorners = (height - (2 * ry));

        path.moveTo(right, top + ry);
        path.rQuadTo(0, -ry, -rx, -ry);//top-right corner
        path.rLineTo(-widthMinusCorners, 0);
        path.rQuadTo(-rx, 0, -rx, ry); //top-left corner
        path.rLineTo(0, heightMinusCorners);

        if (conformToOriginalPost) {
            path.rLineTo(0, ry);
            path.rLineTo(width, 0);
            path.rLineTo(0, -ry);
        } else {
            path.rQuadTo(0, ry, rx, ry);//bottom-left corner
            path.rLineTo(widthMinusCorners, 0);
            path.rQuadTo(rx, 0, rx, -ry); //bottom-right corner
        }

        path.rLineTo(0, -heightMinusCorners);

        path.close();//Given close, last lineto can be removed.

        return path;
    }

//    @Override
//    public ArrayList<ValueAnimator> onCreateAnimators() {
//
//
//
//
//
////        }
//        return animators;
//    }


}