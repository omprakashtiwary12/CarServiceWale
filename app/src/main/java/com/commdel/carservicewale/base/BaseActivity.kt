package com.commdel.carservicewale.base

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.split
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.Toolbar
import com.commdel.carservicewale.R
import com.commdel.carservicewale.util.DialogProgress
import com.commdel.carservicewale.util.UtilHandler

abstract class BaseActivity: ASActivity()
{
    protected var mToolbar: Toolbar? = null
    override var clickable: Boolean = true
    private val theme: String? = null
    private  var color:kotlin.String? = null

    open fun showProgress(){
      DialogProgress.show(this)
  }
    open fun showProgressCustomText(bundle: Bundle?){
        if (bundle == null){
            DialogProgress.showDialogWithCustomText(this,null)
        }else{
            DialogProgress.showDialogWithCustomText(this,bundle)
        }
    }
    open fun hideProgress(){
        DialogProgress.hide(this)
    }
    protected open fun init() {
        mToolbar = findViewById(R.id.toolbar)
        if (mToolbar != null) {
            setSupportActionBar(mToolbar)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowTitleEnabled(true)
            if (theme != null && theme == "1") {
                if (color != null && color != "") {
                    val arr_color: Array<String> = color!!.split(",".toRegex()).toTypedArray()
                    val numbers = IntArray(arr_color.size)
                    for (i in arr_color.indices) {
                        numbers[i] = arr_color[i].toInt()
                    }
                    mToolbar!!.setBackgroundColor(UtilHandler.getHexColor(numbers))
                }
            }
        }
    }
    open fun hideKeyboard(){
        val view = this.currentFocus
        if (view != null){
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken,0)
        }
    }
    open fun showKeyboard() {
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    override fun onBackPressed() {
        super.onBackPressed()
        UtilHandler.hideKeyboard(this@BaseActivity)
    }
    open fun startActivityWithAnimations(intent: Intent?, enterAnim: Int, exitAnim: Int) {
        super.startActivity(intent)
        overridePendingTransition(enterAnim, exitAnim)
    }

}