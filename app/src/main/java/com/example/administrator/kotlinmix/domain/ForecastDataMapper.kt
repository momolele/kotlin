package com.example.administrator.kotlinmix.domain

import com.example.administrator.kotlinmix.date.Forecast
import com.example.administrator.kotlinmix.date.ForecastResult
import com.example.administrator.kotlinmix.util.ForecastRequest
import java.text.DateFormat
import java.util.*
import com.example.administrator.kotlinmix.domain.Forecast as ModelForecast

/**
 * Created by Administrator on 2017/8/12 0012.
 */
public class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): ForecastList{
        return ForecastList(forecast.city.name,forecast.city.country,convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return list.map {  convertForecastsItemToDomain(it) }
    }


    private fun convertForecastsItemToDomain(forecast: Forecast): ModelForecast {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return ModelForecast(convertData(forecast.dt),forecast.weather[0].description,
                forecast.temp.max.toInt(),forecast.temp.min.toInt(),generateIconUrl(forecast.weather[0].icon))

    }

    private fun convertData(date: Long):String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }

    private fun generateIconUrl(iconCode:String):String = "http://openweathermap.org/img/w/$iconCode.png"

}