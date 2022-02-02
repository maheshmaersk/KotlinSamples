package com.amvlabs.kotlinsamples

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.widget.AppCompatTextView


/*INFO :  Use reference from : https://www.raywenderlich.com/155-android-listview-tutorial-with-kotlin*/
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

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val productDetail = getItem(position) as Product
        val view:View
        val holder:ViewHolder

        if(convertView == null){
            view= inflater.inflate(R.layout.list_item_product, parent, false)
            holder = ViewHolder()

            holder.title = view.findViewById<AppCompatTextView>(R.id.productTitle)
            holder.desc = view.findViewById<AppCompatTextView>(R.id.productDescription)
            holder.price = view.findViewById<AppCompatTextView>(R.id.productPrice)

            view.tag = holder
        }else{
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val titleTextView = holder.title
        val subtitleTextView = holder.desc
        val detailTextView = holder.price

        titleTextView.text = productDetail.name
        subtitleTextView.text = productDetail.shortDescription
        detailTextView.text = productDetail.salePrice

        return view
    }


    private class ViewHolder {
        lateinit var title: AppCompatTextView
        lateinit var desc: AppCompatTextView
        lateinit var price: AppCompatTextView
    }


}