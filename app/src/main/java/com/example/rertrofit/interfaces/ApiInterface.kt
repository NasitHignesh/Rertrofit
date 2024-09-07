package com.example.rertrofit.interfaces

import com.example.rertrofit.model.MyData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiInterface {

    @GET("products")
    fun getProductData(): Call<MyData>

}