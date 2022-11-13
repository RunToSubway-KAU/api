package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

var subwayWeekend = mutableMapOf<Int, TimeTo>()

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadTimeInfo(8)
        /*
        binding.btnGetapi.setOnClickListener{
            for()
            binding.textView.text
        }

         */


    }

    private fun loadTimeInfo(dayCd: Int) {
        //HTTP 요청,응답처리  LoadTimeInfo('8'이면 평일, '9'이면 토요일, '10'이면 일요일) 실행해서 response.body()의 정보 사용.
        val call = GyeonguiObject.getApi.ChangeDay(dayCd)

        call.enqueue(object: Callback<Gyeong_ui>{
            override fun onResponse(call: Call<Gyeong_ui>, response: Response<Gyeong_ui>) {
                if(response.isSuccessful()){
                    response.body()?.let{

                        Log.d("MainActivity",it.toString())

                        it.body.forEach{ data ->
                            Log.d("MainActivity", data.toString())
                        }
                    }
                    dataSave(dayCd, response.body()!!.body)

                }else{
                    return
                }
            }

            override fun onFailure(call: Call<Gyeong_ui>, t: Throwable) {
                Log.d("MainActivity", "ErrorMsg: $t")
            }
        })
    }

    fun dataSave(dayCd: Int, body: ArrayList<Body>) {  //메인 액티비티에서 loadTimeInfo 함수를 실행시켰다면 body에 data가 들어있음.
        for (i in 23 until body.size-1 ){   //23부터 시작하는 이유는 데이터에 22까지가 arvTm이 없음.
            val timeTo = TimeTo(body[i].arvTm, body[i].tmnStinCd)  //timeTo에 TimeTo 객체를 넣음.
            subwayWeekend.put(i, timeTo)
            Log.d("MainActivity", "Time: ${subwayWeekend[i]!!.time}, Destination: ${subwayWeekend[i]!!.destination}")
        }

    }
}

class TimeTo(a: Int, b: String){    //해시맵에 timeTo 객체 저장을 위해 클래스 생성.
    val time = a
    val destination = b
}




