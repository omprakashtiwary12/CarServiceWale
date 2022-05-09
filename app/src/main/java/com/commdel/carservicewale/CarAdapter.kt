package com.commdel.carservicewale

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.commdel.carservicewale.model.CarList
import com.commdel.carservicewale.util.MyClickListener
import me.zhanghai.android.materialratingbar.MaterialRatingBar

class CarAdapter(
    private val mList: List<CarList>,
    val mContext: Context,
    val listener: MyClickListener
): RecyclerView.Adapter<CarAdapter.CarViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarAdapter.CarViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.servicecenter_list_item,parent,false)
       return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarAdapter.CarViewHolder, position: Int) {
       val carViewModel = mList[position]
       holder.imageView.setImageResource(carViewModel.image)
        holder.placeText.text = carViewModel.placeName
        holder.cityText.text = carViewModel.cityName
        holder.locationText.text = carViewModel.location
        holder.kilometerText.text = carViewModel.kms.toString()+ " " + "KM"
        holder.locationOnMapText.text = carViewModel.locationOnMap
        holder.ratingTextView.rating = carViewModel.rating
        holder.btnDone.setOnClickListener {
           listener.callback(mContext)
        }

    }

    override fun getItemCount(): Int {
     return mList.size
    }
    inner class CarViewHolder(carView: View): RecyclerView.ViewHolder(carView) {

        val imageView: ImageView = carView.findViewById(R.id.carImage)
        val placeText: TextView = carView.findViewById(R.id.textPlace)
        val cityText: TextView = carView.findViewById(R.id.txt_city)
        val locationText: TextView = carView.findViewById(R.id.txt_location)
        val kilometerText: TextView = carView.findViewById(R.id.txt_km)
        val locationOnMapText: TextView = carView.findViewById(R.id.txt_locationMap)
        val ratingTextView: MaterialRatingBar = carView.findViewById(R.id.txt_rating)
        val btnDone: TextView = carView.findViewById(R.id.btn)
        }

}