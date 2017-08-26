package com.example.administrator.kotlinmix.util

import com.example.administrator.kotlinmix.domain.Command
import com.example.administrator.kotlinmix.domain.ForecastDataMapper
import com.example.administrator.kotlinmix.domain.ForecastList

/**
 * Created by Administrator on 2017/8/12 0012.
 */
class RequestForecastCommand(val zipCode:String):Command<ForecastList> {

    override fun execute(): ForecastList {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}