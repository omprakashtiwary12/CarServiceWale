package com.commdel.carservicewale.util

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.commdel.carservicewale.R
import java.lang.IllegalStateException

const val TAG = "ProgressDialog"
class DialogProgress: DialogFragment() {
    private var avLoadingIndicatorView: AVLoadingIndicatorView? = null
    private val isStopped = false

    fun newInstance(args: Bundle?): DialogProgress? {
        val fragment = DialogProgress()
        fragment.arguments = args
        return fragment
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            val window = dialog.window
            window!!.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT
            )
        }
    }
    companion object {
        @JvmStatic
        fun show(activity: FragmentActivity) {
            val fragment = activity.supportFragmentManager.findFragmentByTag(TAG)
            if (fragment != null) {
                // nothing to do
                return
            }
            Log.d("showingProgress", "Now--------------------->")
            val ft = activity.supportFragmentManager.beginTransaction()
            val newDialog = DialogProgress()
            newDialog.isCancelable = false
            newDialog.setStyle(STYLE_NO_FRAME, android.R.style.Theme_Dialog)
            try {
                newDialog.show(ft, TAG)
            } catch (e: IllegalStateException) {
                // ignore commit failures due to state loss
                Log.e(DialogFragment::class.java.simpleName, "State Loss issue with Progress dialog", e)
            }
        }
        @JvmStatic
        fun showDialogWithCustomText(activity: FragmentActivity, b: Bundle?) {
            val fragment = activity.supportFragmentManager.findFragmentByTag(TAG)
            if (fragment != null) {
                // nothing to do
                return
            }
            Log.d("showingProgress", "Now--------------------->")
            val ft = activity.supportFragmentManager.beginTransaction()
            val newDialog: DialogProgress? = DialogProgress().newInstance(b)
            newDialog?.isCancelable = false
            UtilHandler.hideKeyboard(activity)
            newDialog?.setStyle(STYLE_NO_FRAME,android.R.style.Theme_Dialog)
            try {
                newDialog?.show(ft, TAG)
            } catch (e: IllegalStateException) {
                // ignore commit failures due to state loss
                Log.e(DialogFragment::class.java.simpleName, "State Loss issue with Progress dialog", e)
            }
        }
        @JvmStatic
        fun hide(activity: FragmentActivity?) {
            Log.d("hideProgress", "Now--------------------->")
            if (activity != null) {
                val fragment = activity.supportFragmentManager.findFragmentByTag(TAG)
                if (fragment != null) {
                    activity.supportFragmentManager.beginTransaction().remove(fragment)
                        .commitAllowingStateLoss()
                }
            }
        }
    }






    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // val v: View = inflater.inflate(R.layout.progress_dialog_fragment, container, false)
        val v: View = inflater.inflate(R.layout.progress_dialog_fragment,container,false)
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(0))
        avLoadingIndicatorView = v.findViewById(R.id.progress_bar)
        return v
    }


    fun setProgress(progress: String?) {

//        mheader.setText(progress);
    }
}