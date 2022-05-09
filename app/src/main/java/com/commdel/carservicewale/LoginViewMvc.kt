package com.commdel.carservicewale

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginViewMvc(
    private val layoutInflater: LayoutInflater,
    private val parent:ViewGroup?
) {
    interface Listener {
        fun onButtonClicked()
    }
   private val mobile_container: TextInputLayout
   private val txt_mobile_number:TextInputEditText
   private val mobile_otp: TextInputLayout
   private val txt_mobile_otp: TextInputEditText
   private val done_txt: AppCompatButton

   val rootView: View
   val listeners = HashSet<Listener>()


   init {
       rootView = layoutInflater.inflate(R.layout.activity_login,parent,false)
       mobile_container = findViewById(R.id.mobile_container)
       txt_mobile_number = findViewById(R.id.txt_mobile_number)
       mobile_otp = findViewById(R.id.mobile_otp)
       txt_mobile_otp = findViewById(R.id.txt_mobile_otp)
       done_txt = findViewById(R.id.done_txt)

       done_txt.setOnClickListener {
           for (listener in listeners){
               listener.onButtonClicked()
           }
       }
   }

  fun <T: View?>findViewById(@IdRes id: Int): T {
      return rootView.findViewById<T>(id)
  }
  fun onRegisterButtonClicked(listener: Listener){
      listeners.add(listener)
  }
  fun onUnregisterButtonClicked(listener: Listener){
      listeners.remove(listener)
  }

}