package com.example.workliteadmin


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workliteadmin.databinding.LayoutProfileItemBinding


class ProfileAdapter(private val context: Context, private val list: List<ProfileItem>) :
    RecyclerView.Adapter<ProfileAdapter.CartViewHolder>() {

    inner class CartViewHolder(val binding: LayoutProfileItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = LayoutProfileItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val currentItem = list[position]
        holder.binding.textView11.text = currentItem.name
        holder.binding.textView12.text = currentItem.phoneNumber
        holder.binding.imageView4.setImageResource(currentItem.imageResourceId)
        // Load image if you have any
        // Glide.with(context).load(currentItem.image).into(holder.binding.imageView4)

        // You can set click listeners or any other functionality here
        // holder.itemView.setOnClickListener { /* Handle item click */ }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}
