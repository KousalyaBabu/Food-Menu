package com.example.jankomarket.data.product

data class Subcategories (

	val pro_cate_name : String,
	val pro_cate_sequence : Int,
	val pro_cate_status : String,
	val pro_cate_slug : String,
	val pro_cate_id : String,
	val pro_cate_primary_id : Int,
	val pro_cate_short_description : String,
	val pro_cate_description : String,
	val cate_availability_id : String,
	val pro_subcate_primary_id : Int,
	val pro_subcate_category_primary_id : Int,
	val pro_subcate_id : String,
	val pro_subcate_name : String,
	val pro_subcate_sequence : Int,
	val pro_subcate_status : String,
	val pro_subcate_slug : String,
	val pro_subcate_active_image : String,
	val pro_subcate_default_image : String,
	val pro_subcate_image : String,
	val products : List<Products>
)