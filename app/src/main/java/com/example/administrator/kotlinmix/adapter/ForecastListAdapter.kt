package com.example.administrator.kotlinmix.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.example.administrator.kotlinmix.domain.Forecast
import com.example.administrator.kotlinmix.domain.ForecastList

/**
 * Created by Administrator on 2017/5/22 0022.
 * author:momo
 *创建RecyclerView的Adapter
 */


class ForecastListAdapter(val weekForecast : ForecastList) :RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastListAdapter.ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast[position]){
            holder.textView.text = "$date - $description - $high/$low"
        }
    }


    override fun getItemCount(): Int = weekForecast.size()


    class ViewHolder(val textView :TextView) : RecyclerView.ViewHolder(textView)

    public interface OnItemClickListener{
        operator fun invoke(forecast: Forecast)
    }
}