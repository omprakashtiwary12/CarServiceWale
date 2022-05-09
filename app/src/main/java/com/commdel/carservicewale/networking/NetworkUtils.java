package com.commdel.carservicewale.networking;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.commdel.carservicewale.App;
import com.commdel.carservicewale.base.BaseActivity;


public class NetworkUtils {
    private Context context;
    private ConnectivityManager connManager;

    public NetworkUtils(Context ctx) {
        this.context = ctx;
    }

    public static boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) App.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public static boolean isSerVerReachable() {
        return isOnline();
    }



    public boolean getConnectivityStatus() {
        connManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo info = connManager.getActiveNetworkInfo();
        if (info != null)
            return info.isConnected(); // WIFI connected
        else
            return false; // no info object implies no connectivity
    }
}
