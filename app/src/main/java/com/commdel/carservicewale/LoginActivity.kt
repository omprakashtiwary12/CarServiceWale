package com.commdel.carservicewale

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.commdel.carservicewale.base.BaseActivity
import com.commdel.carservicewale.databinding.ActivityLoginBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob


class LoginActivity : BaseActivity(), LoginViewMvc.Listener {
   lateinit var binding: ActivityLoginBinding
    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    private lateinit var loginViewMvc: LoginViewMvc
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        loginViewMvc = LoginViewMvc(LayoutInflater.from(this),null)
        setContentView(loginViewMvc.rootView)


//        binding.txtMobileNumber.addTextChangedListener(object: TextWatcher{
//
//            override fun afterTextChanged(s: Editable?) {
//
//            }
//
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                if (s != null) {
//                    if (s.length >= 10){
//                        sendSms()
//                    }
//                }
//
//            }
//
//        })
//        binding.doneTxt.setOnClickListener {
//            val intent = Intent(this,MainActivity::class.java)
//            startActivity(intent)
//
//        }
    }

    private fun sendSms() {
//        if (NetworkUtils.isOnline()){
//            val retrofitClient = RetrofitClient()
//            val headerList = ArrayList<Pair<String, String>>()
//            headerList.add(Pair("Content-Type", "application/json"))
//            val retrofit = retrofitClient.getRetrofitClient(headerList, C.BASE_URL,false,RetrofitClient.TIMEOUTTYPE.NORMAL)
//            val api = retrofit.create(ApiCaller::class.java)
//            val call = api.otpMessage()
//
//
//        }
    }

    override fun onButtonClicked() {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

}