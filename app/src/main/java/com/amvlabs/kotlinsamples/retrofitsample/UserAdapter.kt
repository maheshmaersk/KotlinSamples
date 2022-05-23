package com.amvlabs.kotlinsamples.retrofitsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.amvlabs.kotlinsamples.R
import com.squareup.picasso.Picasso

class UserAdapter(private val mList: List<Datum>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val userImage: AppCompatImageView = itemView.findViewById(R.id.contactImage)
        val userName: AppCompatTextView = itemView.findViewById(R.id.contactName)
        val userEmail: AppCompatTextView = itemView.findViewById(R.id.contactEmail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]
        Picasso.get().load(ItemsViewModel.avatar)
            .placeholder(R.drawable.ic_movie_placeholder)
            .error(R.drawable.ic_movie_error).into(holder.userImage);
        // sets the text to the textview from our itemHolder class
        holder.userName.text = ItemsViewModel.firstName
        holder.userEmail.text = ItemsViewModel.email
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}