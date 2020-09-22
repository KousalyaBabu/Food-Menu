package com.example.jankomarket.ui

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private var instance:Retrofit?=null

    fun getInstance():Retrofit{
        val clientBuilder= OkHttpClient.Builder()
        val interceptor= HttpLoggingInterceptor()
        interceptor.level= HttpLoggingInterceptor.Level.HEADERS
        clientBuilder.addInterceptor(interceptor)

        if(null == instance){
            instance=Retrofit.Builder()
                .baseUrl("http://ccpl.jankosoftworks.com/apiv2/products/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(clientBuilder.build())
                .build()
        }
        return instance!!
    }
}