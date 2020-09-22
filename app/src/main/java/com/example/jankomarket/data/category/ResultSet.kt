package com.example.jankomarket.data.category

data class ResultSet (

	val pro_cate_primary_id : Int,
	val category_name : String,
	val pro_cate_slug : String,
	val pro_cate_active_image : String,
	val pro_cate_default_image : String,
	val pro_cate_image : String,
	val cat_availability_id : String,
	val pro_subcate_primary_id : String,
	val pro_subcate_slug : String,
	val pro_subcate_id : String,
	val subcategory_name : String,
	val pro_subcate_active_image : String,
	val pro_subcate_default_image : String,
	val pro_subcate_image : String,
	val subcat_availability_id : String,
	val menu_type : String,
	val menu_category_id : String,
	val menu_custom_title : String,
	val pro_cate_name : String,
	val subcat_list_arr : SubcatListArr,
	val is_sub_list : String
)