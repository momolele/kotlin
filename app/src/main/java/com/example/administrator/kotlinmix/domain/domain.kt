package com.example.administrator.kotlinmix.domain

import java.io.FileDescriptor
import java.text.FieldPosition

/**
 * Created by Administrator on 2017/8/12 0012.
 */

data class ForecastList(val city:String,val country:String,val dailyForecast: List<Forecast>){
    operator fun get(position: Int):Forecast = dailyForecast[position]
    fun size():Int = dailyForecast.size
}

data class Forecast(val date:String,val description: String,val high:Int,val low :Int,val iconUrl:String)