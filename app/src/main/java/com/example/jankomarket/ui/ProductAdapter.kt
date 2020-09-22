package com.example.jankomarket.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jankomarket.R
import com.example.jankomarket.data.product.Products

class ProductAdapter(private val context: Context):RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    private var productList:List<Products>?=null

    fun setProduct(productList:List<Products>){
        this.productList=productList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.product_item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.productName.text=productList?.get(position)?.product_alias
        holder.productPrice.text= "$${productList?.get(position)?.product_price.toString()} "
        holder.productId.text= "ID: ${productList?.get(position)?.product_primary_id?.toString()}"
    }

    override fun getItemCount(): Int{
        if(null!=productList)
            return productList!!.size
        return 0
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val productName:TextView=view.findViewById(R.id.productName)
        val productPrice:TextView=view.findViewById(R.id.productPrice)
        val productId:TextView=view.findViewById(R.id.productId)
    }
}