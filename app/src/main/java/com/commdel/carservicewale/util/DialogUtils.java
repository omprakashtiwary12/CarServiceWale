package com.commdel.carservicewale.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.commdel.carservicewale.App;
import com.commdel.carservicewale.R;
import com.commdel.carservicewale.base.BaseActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;


public class DialogUtils {

    public static void showDialog(Context context, String title, String message, String positiveButton, String negativeButton,
                                  DialogInterface.OnClickListener onClickListener) {
        DialogUtils.showDialog(context,title,message,positiveButton,negativeButton,onClickListener);
    }

    public static void showDialog(Context context, String messageBody, String positiveButton, String negativeButton,
                                  View.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.cardRemoveDialog);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(
                R.layout.item_dialog_remove,
                null);
        TextView tvMessage = view.findViewById(R.id.tv_message);
        tvMessage.setText(messageBody);
        builder.setView(view);
        AlertDialog dialog = builder.create();
//        if(title!=null){
//            dialog.setTitle(title);
//        }

        TextView btnRemove = view.findViewById(R.id.remove);
        TextView btnCancel = view.findViewById(R.id.tv_card_cancel);
        if (!TextUtils.isEmpty(positiveButton)) {
            btnRemove.setText(positiveButton);
            btnRemove.setVisibility(View.VISIBLE);
        } else {
            btnRemove.setVisibility(View.GONE);
        }
        if ( !TextUtils.isEmpty(negativeButton)) {
            btnCancel.setText(negativeButton);
            btnCancel.setVisibility(View.VISIBLE);
        } else {
            btnCancel.setVisibility(View.GONE);
        }

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                    dialog.dismiss();
                }
            }
        });
        btnCancel.setOnClickListener(view1 -> {
            dialog.dismiss();
        });
        dialog.setCancelable(false);
        dialog.show();
    }

    public static void showAlertDialogClicked(Context context, String titleText, String messageBody) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(App.getAppContext());
//        android.app.AlertDialog.Builder dialogBuilder = new android.app.AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) App.getAppContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(
                R.layout.payment_alert_dialog,
                null);
        dialogBuilder.setView(dialogView);
//        android.app.AlertDialog alertDialog = dialogBuilder.create();
        AlertDialog alertDialog = dialogBuilder.create();

        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView ok = dialogView.findViewById(R.id.btn_submit);
        TextView title = dialogView.findViewById(R.id.title_text);
        if (titleText.isEmpty()) {
            title.setVisibility(View.GONE);
        }
        title.setText(titleText);
        TextView message = dialogView.findViewById(R.id.content_text);
        message.setText(messageBody);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();

            }
        });
        alertDialog.show();
        alertDialog.setCancelable(false);

    }


    public static void showAlertDialogClicked(Context context, String titleText, String messageBody, Activity activity) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(App.getAppContext());
//        android.app.AlertDialog.Builder dialogBuilder = new android.app.AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) App.getAppContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(
                R.layout.payment_alert_dialog,
                null);
        dialogBuilder.setView(dialogView);
//        android.app.AlertDialog alertDialog = dialogBuilder.create();
        AlertDialog alertDialog = dialogBuilder.create();

        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView ok = dialogView.findViewById(R.id.btn_submit);
        TextView title = dialogView.findViewById(R.id.title_text);
        if (titleText.isEmpty()) {
            title.setVisibility(View.GONE);
        }
        title.setText(titleText);
        TextView message = dialogView.findViewById(R.id.content_text);
        message.setText(messageBody);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                if (activity != null && !activity.isFinishing()) {
                    activity.onBackPressed();
                }
            }
        });
        alertDialog.show();
        alertDialog.setCancelable(false);

    }
    public static void showAlertDialogClickedNew(Context context, String titleText, String messageBody) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(App.getAppContext());
//        android.app.AlertDialog.Builder dialogBuilder = new android.app.AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) App.getAppContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(
                R.layout.payment_alert_dialog,
                null);
        dialogBuilder.setView(dialogView);
//        android.app.AlertDialog alertDialog = dialogBuilder.create();
        AlertDialog alertDialog = dialogBuilder.create();

        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView ok = dialogView.findViewById(R.id.btn_submit);
        TextView title = dialogView.findViewById(R.id.title_text);
        if (titleText.isEmpty()) {
            title.setVisibility(View.GONE);
        }
        title.setText(titleText);
        TextView message = dialogView.findViewById(R.id.content_text);
        message.setText(messageBody);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
//                if (activity != null && !activity.isFinishing()) {
//                    activity.onBackPressed();
//                }
            }
        });
        alertDialog.show();
        alertDialog.setCancelable(false);

    }

    public static void showAlertDialogClickedAF(Context context, String titleText, String messageBody) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(App.getAppContext());
//        android.app.AlertDialog.Builder dialogBuilder = new android.app.AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) App.getAppContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(
                R.layout.payment_alert_dialog,
                null);
        dialogBuilder.setView(dialogView);
//        android.app.AlertDialog alertDialog = dialogBuilder.create();
        AlertDialog alertDialog = dialogBuilder.create();

        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView ok = dialogView.findViewById(R.id.btn_submit);
        TextView title = dialogView.findViewById(R.id.title_text);
        if (titleText.isEmpty()) {
            title.setVisibility(View.GONE);
        }
        title.setText(titleText);
        TextView message = dialogView.findViewById(R.id.content_text);
        message.setText(messageBody);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                try{
                    BaseActivity baseActivity= (BaseActivity) context;
                    baseActivity.finishAffinity();
                }catch (Exception e){

                }

            }
        });
        alertDialog.show();
        alertDialog.setCancelable(false);

    }
 public static void showAlertDialogClicked(Context context, String titleText, String messageBody, View.OnClickListener onClickListener) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(App.getAppContext());
//        android.app.AlertDialog.Builder dialogBuilder = new android.app.AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) App.getAppContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(
                R.layout.payment_alert_dialog,
                null);
        dialogBuilder.setView(dialogView);
//        android.app.AlertDialog alertDialog = dialogBuilder.create();
        AlertDialog alertDialog = dialogBuilder.create();

        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView ok = dialogView.findViewById(R.id.btn_submit);
        TextView title = dialogView.findViewById(R.id.title_text);
        if (titleText.isEmpty()) {
            title.setVisibility(View.GONE);
        }
        title.setText(titleText);
        TextView message = dialogView.findViewById(R.id.content_text);
        message.setText(messageBody);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                if(onClickListener!=null){
                    onClickListener.onClick(view);
                }
            }
        });
        alertDialog.show();
        alertDialog.setCancelable(false);
    }

    public static void showDialogFullScreen(Context context) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.success_dialog_full_screen, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        AlertDialog dialog = builder.create();
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        dialog.setCancelable(false);
        dialog.show();

    }


    public static void showConfirmDialog(Context context, String title, String message, String positiveButton, String negativeButton,
                                         DialogInterface.OnClickListener onClickListener) {
       DialogUtils.showDialog(context,title,message,positiveButton,negativeButton,onClickListener);
    }

    public static void showOkDialog(Context context, String title, String message, String positiveButton,
                                    DialogInterface.OnClickListener onClickListener) {
        DialogUtils.showDialog(context,title,message,positiveButton,null,onClickListener);
    }

    public static void showOkCancellableDialog(Context context, String title, String message, String positiveButton,
                                               DialogInterface.OnClickListener onClickListener) {
       DialogUtils.showDialog(context,title,message,positiveButton,null,onClickListener);
    }

    public static void showUncalleableDialog(Context context, String title, String message) {
        DialogUtils.showDialog(context,title,message,null,null);
    }

    public static void showDialogForUsAccount(Context context, String message, String operatorName,
                                              DialogInterface.OnClickListener onClickListener) {
        DialogUtils.showDialog(context,null,message,null,null,onClickListener);
    }

    public static void showUpdateDialog(Context context, String title, String message, String positiveButton, String negativeButton,
                                        DialogInterface.OnClickListener onClickListener) {
        DialogUtils.showDialog(context,title,message,positiveButton,negativeButton,onClickListener);
    }

    public static void showKYCBottomSheet(Context context, View.OnClickListener listener, String content, String header, String buttonText) {
        BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = inflater.inflate(R.layout.bottom_sheet_kyc, null);
        mBottomSheetDialog.setContentView(view1);
        mBottomSheetDialog.setCancelable(false);
        ImageView imgCancel = mBottomSheetDialog.findViewById(R.id.imgCancel);
        imgCancel.setOnClickListener(v -> mBottomSheetDialog.dismiss());
        TextView title_text = mBottomSheetDialog.findViewById(R.id.title_text);
        title_text.setText(header);
        TextView content_text = mBottomSheetDialog.findViewById(R.id.content_text);
        content_text.setText(content);

        TextView proceed_button = (TextView) mBottomSheetDialog.findViewById(R.id.proceed_button);
        proceed_button.setVisibility(View.VISIBLE);
        proceed_button.setText(buttonText);
        proceed_button.setOnClickListener(listener);
        mBottomSheetDialog.show();
    }


    public static void showDialogUPgradeKYC(Context context, String messageBody, String positiveButton, String negativeButton,
                                   View.OnClickListener onClickListener,View.OnClickListener onClickListener1) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.cardRemoveDialog);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(
                R.layout.item_dialog_remove,
                null);
        TextView tvMessage = view.findViewById(R.id.tv_message);
        tvMessage.setText(messageBody);
        builder.setView(view);
        AlertDialog dialog = builder.create();
//        if(title!=null){
//            dialog.setTitle(title);
//        }

        TextView btnRemove = view.findViewById(R.id.remove);
        TextView btnCancel = view.findViewById(R.id.tv_card_cancel);
        if (!TextUtils.isEmpty(positiveButton)) {
            btnRemove.setText(positiveButton);
            btnRemove.setVisibility(View.VISIBLE);
        } else {
            btnRemove.setVisibility(View.GONE);
        }
        if ( !TextUtils.isEmpty(negativeButton)) {
            btnCancel.setText(negativeButton);
            btnCancel.setVisibility(View.VISIBLE);
        } else {
            btnCancel.setVisibility(View.GONE);
        }

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                    dialog.dismiss();
                }
            }
        });
        btnCancel.setOnClickListener(view1 -> {
            if (onClickListener1 != null) {
                onClickListener1.onClick(view);
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        dialog.show();
    }

}
