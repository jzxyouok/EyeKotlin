package com.qyh.eyekotlin.model

import android.content.Context
import com.qyh.eyekotlin.model.bean.HomeBean
import com.qyh.eyekotlin.network.RetrofitClient
import com.qyh.eyekotlin.network.api.ApiService
import io.reactivex.Observable

/**
 * @author 邱永恒
 *
 * @time 2018/2/25  13:23
 *
 * @desc 主页数据类
 *
 */
class HomeModel {
    fun loadData(isFirst: Boolean, data: String): Observable<HomeBean> {
        val apiService = RetrofitClient.instance!!.create(ApiService::class.java)
        return when (isFirst) {
            true -> apiService.getHomeData()
            false -> apiService.getHomeMoreData(data, "2")
        }
    }
}