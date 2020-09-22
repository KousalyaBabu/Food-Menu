package com.example.jankomarket.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jankomarket.R
import com.example.jankomarket.EndPointInterface
import com.example.jankomarket.Utils
import com.example.jankomarket.data.product.Product
import com.example.jankomarket.data.product.Subcategories
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductActivity:AppCompatActivity() {
    companion object{
        const val CATEGORY_KEY="com.example.jankomarket.ui.categoryKey"
        const val SUB_CATEGORY_KEY="com.example.jankomarket.ui.subCategoryKey"
    }

    private var productRecView:RecyclerView?=null
    private lateinit var productQuery:MutableMap<String,String>
    private var subCategories:Subcategories?=null
    private var productAdapter:ProductAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_layout)

        if(null!=intent){
            val categoryName=intent.getStringExtra(CATEGORY_KEY)
            val subCategoryName=intent.getStringExtra(SUB_CATEGORY_KEY)
            if(null!=categoryName)
                if(null!=subCategoryName)
                    productQuery=mutableMapOf(Pair("app_id", Utils.API_ID),Pair("availability",Utils.AVAIL_ID), Pair("outletId",""),
                        Pair("category_slug",categoryName),Pair("subcate_slug",subCategoryName))
        }
        initView()
        initService()
    }

    private fun initView() {
        productRecView=findViewById(R.id.productRecView)
        productRecView?.layoutManager=LinearLayoutManager(this)
        productAdapter=ProductAdapter(this)
        productRecView?.adapter=productAdapter
    }

    private fun initService() {
        val serviceInterface=RetrofitInstance.getInstance().create(EndPointInterface::class.java)
        val product=serviceInterface.getProduct(productQuery)
        product.enqueue(object : Callback<Product> {
            override fun onResponse(call: Call<Product>?, response: Response<Product>?) {
                subCategories = response?.body()?.result_set?.get(0)?.subcategorie?.get(0)
                subCategories?.products?.let { productAdapter?.setProduct(it) }
            }

            override fun onFailure(call: Call<Product>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }
}