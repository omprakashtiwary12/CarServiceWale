package com.commdel.carservicewale.networking

import retrofit2.http.POST

interface ApiCaller {
  @POST("api/sendOtp")
   fun otpMessage()
}