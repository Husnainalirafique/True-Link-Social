package com.example.truelinksocial.ui.after_Sign_up_onboarding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.truelinksocial.R

class AvatarRecyclerViewAdapter(private val imgList: ArrayList<AvatarRecyclerViewData>,
                                private val itemClickListener: OnImageItemClickListener
                                ) :
    RecyclerView.Adapter<AvatarRecyclerViewAdapter.ViewModel>() {

    interface OnImageItemClickListener {
        fun onItemClick(imageRes:AvatarRecyclerViewData)
    }

    class ViewModel(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.avatarImgView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewModel {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.choose_avatar_item, parent, false)
        return ViewModel(view)
    }

    override fun getItemCount(): Int {
        return imgList.size
    }

    override fun onBindViewHolder(holder: ViewModel, position: Int) {
        val itemPosition = imgList[position]
        holder.img.setImageResource(itemPosition.img)
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(itemPosition)
        }
    }
}










