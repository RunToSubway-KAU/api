package com.example.retrofit

import com.google.gson.annotations.SerializedName

//body의 내용은 어레이리스트 형식 그 안에 data class Body를 가짐.
data class Gyeong_ui(
    @SerializedName("body")val body: ArrayList<Body>
    )

//Body 데이터 클래스 안에는 평일인지 주말인지 확인하는 dayCd, 출발시간, 도착시간, 종점역이 있음.
data class Body (
    @SerializedName("dayCd")val dayCd: Int,
    @SerializedName("arvTm")val arvTm: Int,
    @SerializedName("dptTm")val dptTm: Int,
    @SerializedName("tmnStinCd")val tmnStinCd: String
    )