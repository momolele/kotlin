package com.example.administrator.kotlinmix.util

import android.util.Log
import com.example.administrator.kotlinmix.date.ForecastResult
import com.google.gson.Gson
import java.net.URL

/**
 * Created by Administrator on 2017/8/12 0012.
 */

public class Request(val url :String){

    public fun  run(){
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName,forecastJsonStr);

    }

}

public class ForecastRequest(val zipCode:String){
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute():ForecastResult{
        val forecastJsonStr= URL(COMPLETE_URL+zipCode).readText();
        return Gson().fromJson(forecastJsonStr,ForecastResult::class.java)
    }
}