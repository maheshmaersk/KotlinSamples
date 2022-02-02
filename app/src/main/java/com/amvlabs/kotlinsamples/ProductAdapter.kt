package com.amvlabs.kotlinsamples

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat

class ProductAdapter(private val context: Context, private val productList: ArrayList<Product>) :
    BaseAdapter() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return productList.size
    }

    override fun getItem(position: Int): Any {
        return productList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val productView = inflater.inflate(R.layout.list_item_product, parent, false)

        val title= productView.findViewById<AppCompatTextView>(R.id.productTitle)
        val desc= productView.findViewById<AppCompatTextView>(R.id.productDescription)
        val price= productView.findViewById<AppCompatTextView>(R.id.productPrice)

        val productDetail= getItem(position) as Product

        title.text = productDetail.name
        desc.text = productDetail.shortDescription
        price.text = productDetail.salePrice

        return productView
    }

}