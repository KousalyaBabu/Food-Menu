package com.example.jankomarket

import com.example.jankomarket.data.category.Category
import com.example.jankomarket.data.product.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface EndPointInterface {

    @GET("getMenuNavigation?")
    fun getCategory(@QueryMap categoryQuery:Map<String,String>):Call<Category>

    @GET("getAllProducts?")
    fun getProduct(@QueryMap productQuery:Map<String,String>):Call<Product>
}