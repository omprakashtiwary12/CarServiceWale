package com.commdel.carservicewale.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.commdel.carservicewale.CarAdapter
import com.commdel.carservicewale.LoginActivity
import com.commdel.carservicewale.R
import com.commdel.carservicewale.base.BaseActivity
import com.commdel.carservicewale.model.CarList
import com.commdel.carservicewale.util.DialogProgress
import com.commdel.carservicewale.util.MyClickListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ServiceCenterList : BaseActivity(), MyClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_center_list)
        toolbar = findViewById(R.id.mToolbar)
        recyclerView = findViewById(R.id.car_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<CarList>()
        for(i in 1..20){
            data.add(
                CarList(R.drawable.car_repairing,"Uttam Nagar Center","New Delhi",
                "Delhi",2.0 ,"LocationOnMap",5.0f))
        }
        val adapter = CarAdapter(data, this@ServiceCenterList, this)
        recyclerView.adapter = adapter

    }

    override fun callback(view: Context) {
        showProgress()
        CoroutineScope(Dispatchers.Main).launch {
            delay(2800)
            hideProgress()
            startActivity(Intent(this@ServiceCenterList, LoginActivity::class.java))
        }
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}