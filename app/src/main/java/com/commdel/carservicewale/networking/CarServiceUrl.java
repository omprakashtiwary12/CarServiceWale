package com.commdel.carservicewale.networking;

import android.net.Uri;
import android.text.TextUtils;

import com.commdel.carservicewale.App;
import com.commdel.carservicewale.BuildConfig;
import com.commdel.carservicewale.R;

public class CarServiceUrl {
    private final Uri.Builder mBuilder;

    public CarServiceUrl(String base) {
        mBuilder = new Uri.Builder().encodedPath(base);
    }



    private Uri.Builder getBuilder() {
        return mBuilder;
    }

    public String toUrl() {
        return getBuilder().toString().trim();
    }
}
