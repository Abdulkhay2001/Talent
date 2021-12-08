package com.Abdul.ui.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.Abdul.database.UserDB
import com.Abdul.R
import com.Abdul.databinding.UserItemBinding
import com.bumptech.glide.Glide

class UserListAdapter(
    private var list: List<UserDB>,
    val lambda: (Int) -> Unit
) : RecyclerView.Adapter<UserListAdapter.UserHolder>() {

    lateinit var cont: Context

    inner class UserHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = UserItemBinding.bind(item)

        fun bind(user: UserDB) = with(binding) {
            FIO.text = user.FIO
            profes.text = user.opisanie
            //imageView.setImageResource(user.image)
        }

        init {
            item.setOnClickListener {
                lambda(list[0].userId + adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        cont = parent.context
        return UserHolder(view)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}