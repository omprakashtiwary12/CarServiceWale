package com.commdel.carservicewale.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;


import com.commdel.carservicewale.App;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;


public class DeviceUtils {

    public static Point getDisplaySize() {
        WindowManager wm = (WindowManager) App.getInstance().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point out = new Point();
        display.getSize(out);
        return out;
    }

    public static float getDisplayAspect() {
        Point p = getDisplaySize();
        return ((float) p.x) / ((float) p.y);
    }

    public static int dpToPixels(float dps) {
        final float scale = App.getInstance().getResources().getDisplayMetrics().density;
        return (int) (dps * scale + 0.5f);
    }

    public static float convertPixelsToDp(int px) {
        DisplayMetrics metrics = App.getInstance().getResources().getDisplayMetrics();
        float dp = px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }

    public static float dpToPixelsF(float dps) {
        final float scale = App.getInstance().getResources().getDisplayMetrics().density;
        return dps * scale;
    }

    public static int calculateInSampleSize(int width, int height, int reqWidth, int reqHeight) {
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and
            // keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }


    public static int calculateInSampleSize(int original, int required) {
        int inSampleSize = 1;
        if (original > required) {

            final int half = original / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and
            // keeps both dimension larger than requested
            while ((half / inSampleSize) > required) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    public static boolean hasCamera() {
        if (App.getInstance().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)) {
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }

    public static int getDeviceWidth() {
        DisplayMetrics metrics = App.getInstance().getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        return width;
    }

    public static int getDeviceHeight() {
        DisplayMetrics metrics = App.getInstance().getResources().getDisplayMetrics();
        int height = metrics.heightPixels;
        return height;
    }


    public static int getRelativeX(View myView) {
        if (myView.getParent() == myView.getRootView())
            return myView.getLeft();
        else
            return myView.getLeft() + getRelativeX((View) myView.getParent());
    }

    public static int getRelativeY(View myView) {
        if (myView.getParent() == myView.getRootView())
            return myView.getTop();
        else
            return myView.getTop() + getRelativeY((View) myView.getParent());
    }

    public static int getStatusBarHeight() {
        int result = 0;
        int resourceId = App.getInstance().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = App.getInstance().getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static int getPixelSize(int dp) {
        return Math.round(App.getInstance().getResources().getDisplayMetrics().density * dp);
    }

    public static int[] getResolution(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

        return new int[]{metrics.widthPixels, metrics.heightPixels};
    }

    public static Boolean isDeviceRooted(Context context) {
        boolean isRooted = isrooted1() || isrooted2();
        return isRooted;
    }

    public static boolean isrooted1() {
        String buildTags = android.os.Build.TAGS;
        return buildTags != null && buildTags.contains("test-keys");
    }

    // try executing commands
    public static boolean isrooted2() {
        String[] paths = { "/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su",
                "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (String path : paths) {
            if (new File(path).exists()) return true;
        }
        return false;
    }

    // executes a command on the system
    private static boolean canExecuteCommand(String command) {
        /*boolean executedSuccesfully;
        try {
            Runtime.getRuntime().exec(command);
            executedSuccesfully = true;
        } catch (Exception e) {
            executedSuccesfully = false;
        }

        return executedSuccesfully;*/
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(new String[] { "/system/xbin/which", "su" });
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            if (in.readLine() != null) return true;
            return false;
        } catch (Throwable t) {
            return false;
        } finally {
            if (process != null) process.destroy();
        }
    }
}
