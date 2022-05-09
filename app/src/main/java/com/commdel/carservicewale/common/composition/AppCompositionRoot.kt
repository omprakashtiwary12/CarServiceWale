package com.commdel.carservicewale.common.composition

import android.app.Application
import com.commdel.carservicewale.common.Constants
import com.commdel.carservicewale.networking.ApiCaller
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppCompositionRoot(val application: Application) {
    private lateinit var compositionRoot:ActivityCompositionRoot
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiCaller: ApiCaller by lazy {
        retrofit.create(ApiCaller::class.java)
    }
}