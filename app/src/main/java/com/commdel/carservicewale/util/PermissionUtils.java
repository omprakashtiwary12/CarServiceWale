package com.commdel.carservicewale.util;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.commdel.carservicewale.App;
import com.commdel.carservicewale.R;


public class PermissionUtils {
    public static final int CAMERA_PERMISSION_REQUEST_CODE = 999;
    public static final int CONTACT_READ_PERMISSION_REQUEST_CODE = 998;
    public static final int READ_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE = 997;
    public static final int LOCATION_PERMISSION_REQUEST_CODE = 996;
    public static final int WRITE_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE = 995;
    public static final int READ_PHONE_STATE_REQUEST_CODE = 994;
    public static final int READ_CONTACT_CODE = 9940;
    public static final int READ_PERMISSIONS_FOR_SMILE_ID = 993;

    public static final String READ_CONTACT = Manifest.permission.READ_CONTACTS;
    public static final String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    public static final String READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    public static final String CAMERA_REQUIRED = Manifest.permission.CAMERA;
    public static final String READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE;
    public static final String ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    public static final String ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    public static final String ACCESS_RECORD_AUDIO = Manifest.permission.RECORD_AUDIO;

    public static boolean isPermissionGranted(Context context, String permission) {
        return ActivityCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }

    public static boolean isPermissionPreviouslyDenied(Activity activity, String permission) {
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, permission);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static boolean allPermissionsGranted(String[] permissions, Activity activity) {
        for (String permission : permissions) {
            if (activity.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    @TargetApi(Build.VERSION_CODES.M)
    public static boolean getPermission(final AppCompatActivity context, String permission, int requestCode, boolean showDialog) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!isPermissionGranted(context, permission)) {
                context.requestPermissions(new String[]{permission}, requestCode);
                return false;
            }
            return true;
        } else return true;
    }

    public static boolean getPermission(final Fragment context, String permission, int requestCode, boolean showDialog) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!isPermissionGranted(context.getActivity(), permission)) {
                (context).requestPermissions(new String[]{permission}, requestCode);
                return false;
            }
            return true;
        } else return true;
    }

    public static void showDialog(final Activity activity, String permission,
                                  @Nullable DialogInterface.OnClickListener positiveClickListener) {
        String explaination = App.R().getString(R.string.err_generic_permission);
        switch (permission) {
            case READ_CONTACT:
                explaination = App.R().getString(R.string.err_contact_permission);
                break;
            case READ_EXTERNAL_STORAGE:
                explaination = App.R().getString(R.string.err_read_permission);
                break;
            case CAMERA_REQUIRED:
                explaination = App.R().getString(R.string.err_camera_permission);
                break;
            case WRITE_EXTERNAL_STORAGE:
                explaination = App.getInstance().getString(R.string.err_write_permission);
                break;
            case READ_PHONE_STATE:
                explaination = App.getInstance().getString(R.string.err_phone_permission);
                break;
        }
        UtilHandler.showPermissionNotAllow(activity, explaination, positiveClickListener,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DialogUtils.showAlertDialogClicked(activity, "",
                                activity.getResources().getString(R.string.permission_alert), new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog.dismiss();
                                    }
                                });
                        dialog.dismiss();
                    }
                });
    }
}
