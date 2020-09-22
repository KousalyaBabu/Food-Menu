package com.example.jankomarket.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jankomarket.R
import com.example.jankomarket.EndPointInterface
import com.example.jankomarket.Utils
import com.example.jankomarket.data.category.Category
import com.example.jankomarket.data.category.ResultSet
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener,CategoryAdapter.SelectedCategory {

    private var categorySpinner: Spinner? = null
    private var allCategoryResult: List<ResultSet>? = null
    private var categoryRecView:RecyclerView?=null
    private var categoryAdapter:CategoryAdapter?=null
    private var selectedCategoryName=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_layout)
        initView()
        initService()
    }

    private fun initView() {
        categorySpinner = findViewById(R.id.categorySpinner)
        categorySpinner?.onItemSelectedListener=this
        categoryRecView=findViewById(R.id.categoryRecView)
        categoryAdapter=CategoryAdapter(this)
        categoryRecView?.also {
            it.layoutManager=LinearLayoutManager(this)
            it.adapter= categoryAdapter
        }
    }

    private fun initService() {
        val serviceInterface = RetrofitInstance.getInstance().create(EndPointInterface::class.java)
        val category = serviceInterface.getCategory(mapOf(
            Pair("app_id", Utils.API_ID),
            Pair("availability", Utils.AVAIL_ID),
            Pair("outletId", "")
        ))
        category.enqueue(object : Callback<Category> {
            override fun onResponse(call: Call<Category>?, response: Response<Category>?) {
                allCategoryResult = response?.body()?.result_set
                categorySpinner?.adapter = ArrayAdapter(this@CategoryActivity, android.R.layout.simple_list_item_1, getAllCategoryName())
            }

            override fun onFailure(call: Call<Category>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }

    private fun getAllCategoryName(): List<String> {
        val allCategoryNames = mutableListOf<String>()
        if (null != allCategoryResult) {
            for (result in allCategoryResult!!) {
                allCategoryNames.add(result.category_name)
            }
        }
        return allCategoryNames
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        for (category in allCategoryResult!!) {
            if (category.category_name == getAllCategoryName()[p2]) {
                selectedCategoryName=category.pro_cate_slug
                categoryAdapter?.setSubCategory(category.subcat_list_arr.sub_result_set)
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {}

    override fun getSubCategoryDetails(subCategory: String) {
        val intent=Intent(this,ProductActivity::class.java)
        intent.putExtra(ProductActivity.CATEGORY_KEY,selectedCategoryName)
        intent.putExtra(ProductActivity.SUB_CATEGORY_KEY,subCategory)
        startActivity(intent)
    }
}