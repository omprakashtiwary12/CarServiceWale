package com.commdel.carservicewale.common.composition

import com.commdel.carservicewale.networking.ApiCaller

class LoginUseCase(private val apiCaller: ApiCaller) {

   suspend fun fetchOtp(mobileNumber: String){
       val response = apiCaller
   }
}