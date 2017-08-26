package com.example.administrator.kotlinmix

import android.app.DownloadManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.administrator.kotlinmix.adapter.ForecastListAdapter
import com.example.administrator.kotlinmix.util.RequestForecastCommand
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity() {

    //使用listOf()创建一个常量的list

    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Web 6/24 - Cloudy - 22/17",
            "Thurs 6/24 - Foggy - 18/8",
            "Fri 6/24 - Foggy - 21/8",
            "Sat 6/24 - TRAPPD  - 21/8",
            "Sun 6/24 - Sunny - 20/7"

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val forecastList : RecyclerView = findViewById(R.id.forecast_list) as RecyclerView
        val forecastList : RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)// 创建对象实例化
        forecastList.adapter = ForecastListAdapter(items)

        async(){
            val result = RequestForecastCommand("94043").execute()
            uiThread{
                forecastList.adapter = ForecastListAdapter(result)
            }
        }

    }
}
