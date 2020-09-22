package com.example.jankomarket.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jankomarket.R
import com.example.jankomarket.data.category.ResultSet
import com.example.jankomarket.data.category.SubResultSet

class CategoryAdapter(private val context: Context):RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    private var categories:List<SubResultSet>?=null
    private var selectedCategory:SelectedCategory?=null

    fun setSubCategory(categories:List<SubResultSet>){
        this.categories=categories
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.category_item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.categoryName.text=categories?.get(position)?.pro_subcate_name
        holder.itemView.setOnClickListener {
            selectedCategory=context as SelectedCategory
            categories?.get(position)?.pro_subcate_slug?.let { subCategory ->
                selectedCategory?.getSubCategoryDetails(
                    subCategory
                )
            }
        }
    }

    override fun getItemCount(): Int{
        if(null!=categories)
            return categories!!.size
        return 0
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val categoryName:TextView=view.findViewById(R.id.categoryName)
    }

    interface SelectedCategory {
        fun getSubCategoryDetails(subCategory:String)
    }
}