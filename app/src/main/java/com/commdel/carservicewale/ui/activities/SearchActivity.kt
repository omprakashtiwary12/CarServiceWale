package com.commdel.carservicewale.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.commdel.carservicewale.R
import com.commdel.carservicewale.base.BaseActivity
import com.commdel.carservicewale.databinding.ActivitySearchBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchActivity : BaseActivity(){
    var carModelList: ArrayList<String>? = null
    private lateinit var binding: ActivitySearchBinding
    private val cityList = arrayListOf("Delhi","Kolkata")
    private val vehicleList = arrayListOf("Test","Car")
    private val brandList = arrayListOf("BMW","Maruti Suzuki","Hundai","Ford","Honda","Mercedes","Audi",
         "Volvo","Volkesvagen","Toyota","Tesla","ISUZU","Rolls Royce","Porche","Nissan","Mitsubishi","Mini","Kia",
        "Lexus","Land Rover","Lotus","Lincoln","Mazda","Maserati","Renault","Tata","Mahindra","Jeep","Jaguar","Scuderia Ferrari",
        "Aston Martin","Bentley","Cadilac","Chevrolet","Fiat","General Motors Company","Lamborghini","Citroen","Force Motors",
        "Bugatti","Datsun","McLaren","Skoda","MG","DC","Haval","Ora"
        )
    private val modelList = arrayListOf("720 LD","Swift","Alto 800","Baleno","Celerio","Celerio X","Ciaz","Dzire",
                            "Eeco","Ertiga","Ignis","S Cross","S Presso","Vitara Brezza","Wagon R","XL6","Elantra",
                             "Alcazar","Aura","Creta","Grand i10 Nios","Kona Electric","Tucson","Venue","Verna","Xcent",
                             "i 20","Santro"
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        val cities = resources.getStringArray(R.array.cities)
        val cityAdapter = ArrayAdapter(this@SearchActivity,R.layout.dropdown_item,cityList)
        binding.autoCity.setAdapter(cityAdapter)
        val vehicleAdapter = ArrayAdapter(this@SearchActivity,R.layout.dropdown_item,vehicleList)
        binding.autoVehicle.setAdapter(vehicleAdapter)
        val brandAdapter = ArrayAdapter(this@SearchActivity,R.layout.dropdown_item,brandList)
        binding.autoBrand.setAdapter(brandAdapter)
        binding.btnDone.setOnClickListener {
            showProgress()
            CoroutineScope(Dispatchers.Main).launch {
                delay(2800)
                hideProgress()
                startActivity(Intent(this@SearchActivity, ServiceCenterList::class.java))
            }
        }
        binding.autoBrand.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, _, _ ->
               // Toast.makeText(this@SearchActivity,binding.autoBrand.text, Toast.LENGTH_LONG).show()
                val brand = binding.autoBrand.text.toString()
                if (brand == "BMW"){
                    carModelList = arrayListOf("720 LD","Test")
                }else if (brand == "Maruti Suzuki"){
                    carModelList = arrayListOf("Swift","Alto","Baleno","Celerio","Celerio X","Ciaz","Dzire","Eeco","Ertiga",
                        "Ignis","S Cross","S Presso","Vitara Brezza","Wagon R","XL6")

                }
                val carModelAdapter = ArrayAdapter(this@SearchActivity,R.layout.dropdown_item,carModelList!!)
                carModelAdapter.notifyDataSetChanged()
                binding.autoModel.setAdapter(carModelAdapter)
            }
       val fuelTypeList = arrayListOf("Diesel","Petrol","CNG","LPG","ELECTRIC")
       val fuelTypeAdapter = ArrayAdapter(this@SearchActivity,R.layout.dropdown_item,fuelTypeList)
       binding.autoFuel.setAdapter(fuelTypeAdapter)
    }


}