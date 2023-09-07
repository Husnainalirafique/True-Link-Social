package com.example.truelinksocial.ui.after_Sign_up_onboarding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.truelinksocial.R
import com.example.truelinksocial.ui.after_Sign_up_onboarding.data.AvatarRecyclerViewData

class AvatarRecyclerViewAdapter(
    private val imgList: ArrayList<AvatarRecyclerViewData>,
    private val onImgClickListener : OnImageClick ) :
    RecyclerView.Adapter<AvatarRecyclerViewAdapter.ViewModel>() {
    private var selectedItemPosition : Int = -1
    interface OnImageClick {
        fun onClick(imgres : AvatarRecyclerViewData)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewModel {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.choose_avatar_item, parent, false)
        return ViewModel(view)
    }

    override fun getItemCount(): Int {
        return imgList.size
    }

    override fun onBindViewHolder(holder: ViewModel, position: Int) {
        val itemPosition = imgList[position]
        holder.img.setImageResource(itemPosition.image)
        holder.itemView.setOnClickListener {
            onImgClickListener.onClick(itemPosition)
            selectedItemPosition = holder.adapterPosition
            notifyDataSetChanged()
        }
        if (selectedItemPosition == position)
        {
            holder.img.setBackgroundResource(R.drawable.choose_avatar_img_bg_selected)
        }
        else
        {
            holder.img.setBackgroundResource(R.drawable.choose_avatar_img_bg_unselected)
        }
    }

    class ViewModel(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.avatarImgView)
    }
}









