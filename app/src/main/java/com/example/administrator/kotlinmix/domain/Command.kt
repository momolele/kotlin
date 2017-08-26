package com.example.administrator.kotlinmix.domain

/**
 * Created by Administrator on 2017/8/12 0012.
 */
public  interface Command<T> {
    fun execute():T
}