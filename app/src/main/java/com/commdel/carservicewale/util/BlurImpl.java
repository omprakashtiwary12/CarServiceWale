/*
 * Copyright (c)
 * 30/4/21 10:55 AM
 * 2021
 * User
 */

package com.commdel.carservicewale.util;

import android.content.Context;
import android.graphics.Bitmap;

interface BlurImpl {

    boolean prepare(Context context, Bitmap buffer, float radius);

    void release();

    void blur(Bitmap input, Bitmap output);

}