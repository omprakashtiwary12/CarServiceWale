package com.commdel.carservicewale

import android.app.Application
import android.content.Context
import android.content.res.Resources
import com.commdel.carservicewale.common.composition.AppCompositionRoot
import dagger.hilt.android.HiltAndroidApp

var context: Context? = null

@HiltAndroidApp
class App: Application() {

    lateinit var appCompositionRoot: AppCompositionRoot
    override fun onCreate() {
        appCompositionRoot  = AppCompositionRoot(this)
        super.onCreate()
        context = getAppContext()
        instance = this
    }


    companion object {
        private var instance: App? = null
        private val sApp: Context? = null
        @JvmStatic
        fun getInstance(): App {
            if (instance == null){
                throw IllegalStateException()
            }
            return instance as App
        }
        @JvmStatic
        fun getAppContext(): Context? {

            return context
        }
        @JvmStatic
        fun appContext(): Context? {
            return sApp
        }
        @JvmStatic
        fun R(): Resources? {
            return sApp?.getResources()
        }

    }
}