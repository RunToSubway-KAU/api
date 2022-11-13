package com.example.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GyeonguiApi{
    @GET("stationTimetable?serviceKey=$2a$10\$hBdzkL2gV24Q0ygaXISn7eq3IwOT7cgMTYF4a759gWsYQj/4eZhjW&format=json&railOprIsttCd=KR&lnCd=K4&stinCd=k318")
    fun ChangeDay(@Query("dayCd")dayCd:Int): Call<Gyeong_ui>
}