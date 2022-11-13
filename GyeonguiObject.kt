package com.example.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object GyeonguiObject {
    private const val baseUrl = "https://openapi.kric.go.kr/openapi/convenientInfo/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    //getApi는 Gyeongui_Api객체이다.
    val getApi = retrofit.create(GyeonguiApi::class.java)

}