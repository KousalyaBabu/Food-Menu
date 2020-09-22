package com.example.jankomarket.data.product

data class Products (

	val product_primary_id : Int,
	val product_id : String,
	val product_name : String,
	val product_alias : String,
	val product_sku : String,
	val product_sequence : Int,
	val product_thumbnail : String,
	val product_short_description : String,
	val product_long_description : String,
	val product_status : String,
	val product_slug : String,
	val product_price : Double,
	val product_type : Int,
	val product_stock : Int,
	val product_minimum_quantity : Int,
	val product_overall_rating : Int,
	val product_availability_id : String,
	val product_department : List<String>,
	val product_tag : List<ProductTag>
)