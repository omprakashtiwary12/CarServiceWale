package com.commdel.carservicewale.base

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

open class ASActivity: AppCompatActivity() {


     open var clickable: Boolean = true

    companion object {
     protected val LOG_TAG = this.javaClass.simpleName
     protected val LIFE_TAG = "[LIFECYCLE] $LOG_TAG"
     protected var isFirstLaunch = true
 }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        isFirstLaunch = savedInstanceState == null
    }
    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
    }
    override fun setContentView(view: View?) {
        super.setContentView(view)
    }
    override fun setContentView(view: View?, params: ViewGroup.LayoutParams?) {
        super.setContentView(view, params)
    }
    override fun onAttachFragment(fragment: Fragment?) {
        super.onAttachFragment(fragment)
        Log.v(LIFE_TAG, "onAttachFragment: " + fragment!!.javaClass.simpleName)
    }
    override fun onContentChanged() {
        super.onContentChanged()
        Log.v(LIFE_TAG, "onContentChanged")
    }
    override fun onRestart() {
        super.onRestart()
        Log.v(LIFE_TAG, "onRestart")
    }
    override fun onStart() {
        super.onStart()
        Log.v(LIFE_TAG, "onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.v(LIFE_TAG, "onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.v(LIFE_TAG, "onPause")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.v(LIFE_TAG, "onSaveInstanceState")
    }

    override fun onStop() {
        super.onStop()
        Log.v(LIFE_TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(LIFE_TAG, "onDestroy")
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)

    }
}