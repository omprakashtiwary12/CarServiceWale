package com.commdel.carservicewale.util

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.provider.Settings
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.commdel.carservicewale.App
import com.commdel.carservicewale.R
import com.google.android.material.textfield.TextInputLayout

object UtilHandler {
    const val COUNTER_TIME: Long = 60000
    private const val RC_HANDLE_GMS = 9001
    var isSetting = false

    @JvmStatic
    fun hideKeyboard(activity: Activity) {
        val view = activity.currentFocus
        if (view != null) {
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    @JvmStatic
    fun startInstalledAppDetailsActivity(context: Activity?) {
        if (context == null) {
            return
        }
        val i = Intent()
        i.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        i.addCategory(Intent.CATEGORY_DEFAULT)
        i.data = Uri.parse("package:" + context.packageName)
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
        isSetting = true
        context.startActivity(i)
    }
    fun getErrorTextWatcher(editText: TextInputLayout): TextWatcher? {
        return object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                // do what you want with your EditText
                editText.isErrorEnabled = false
                editText.error = null
            }

            override fun afterTextChanged(editable: Editable) {}
        }
    }
    @JvmStatic
    fun getGenderFullName(gender: String): String? {
        var gen = ""
        gen = if (gender == "M" || gender == "Male") {
            "Male"
        } else {
            "Female"
        }
        return gen
    }

    fun getHexColor(color: IntArray): Int {
        return Color.rgb(color[0], color[1], color[2])
    }
    fun isEmpty(s: String): Boolean {
        return TextUtils.isEmpty(s) || s.equals("null", ignoreCase = true) || s.equals(
            null,
            ignoreCase = true
        )
    }
    fun showToast(message: String?) {
        if (C.getToast() == null) {
            return
        }
        C.getToast().cancel()
        C.setToast(Toast.makeText(App.getInstance(), message, Toast.LENGTH_SHORT))
        C.getToast().show()
    }

    @JvmStatic
    fun showPermissionNotAllow(
        contxt: Activity, explanation: String?,
        positiveButton: DialogInterface.OnClickListener?,
        onNegativeAction: DialogInterface.OnClickListener?
    ) {
        var positiveButton = positiveButton
        val alertDialogBuilder = AlertDialog.Builder(
            contxt
        )


        // set title
        alertDialogBuilder.setTitle(null)
        var positiveText = contxt.resources.getString(R.string.ok)
        if (positiveButton != null) {
            positiveText = contxt.resources.getString(R.string.open_settings)
            positiveButton = DialogInterface.OnClickListener { dialog, which ->
                UtilHandler.startInstalledAppDetailsActivity(contxt)
                dialog.dismiss()
            }
        }

        // set dialog message
        alertDialogBuilder
            .setMessage(explanation)
            .setCancelable(false)
            .setPositiveButton(positiveText, positiveButton)
            .setNegativeButton(contxt.resources.getString(R.string.Cancel), onNegativeAction)

        // create alert dialog
        val alertDialog = alertDialogBuilder.create()

        // show it
        alertDialog.show()
    }

}