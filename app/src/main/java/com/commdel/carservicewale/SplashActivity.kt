package com.commdel.carservicewale

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.os.HandlerCompat.postDelayed
import android.content.Intent
import com.commdel.carservicewale.base.BaseActivity
import com.commdel.carservicewale.ui.activities.SearchActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


/** Duration of wait  */
private const val SPLASH_DISPLAY_LENGTH = 1000

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        progressMethod()
    }

    private fun progressMethod() {
        showProgress()
        goToSearchActivity()
    }

    private fun goToSearchActivity() {
        CoroutineScope(Dispatchers.Main).launch {
            delay(1200)
            hideProgress()
            startActivity(Intent(this@SplashActivity, SearchActivity::class.java))
        }
    }
}