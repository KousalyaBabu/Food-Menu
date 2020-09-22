package com.example.jankomarket.data.product

data class Product(
    val status : String,
    val common : Common,
    val result_set : List<ResultSet>
)