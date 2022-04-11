package com.luka.travel.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import coil.Coil
import coil.load
import com.luka.travel.databinding.ItemUserProfileImageBinding
import com.luka.travel.model.Data

class ProfileImagesAdapter :
    PagingDataAdapter<Data, ProfileImagesAdapter.ProfileImageViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileImageViewHolder {
        val binding =
            ItemUserProfileImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProfileImageViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ProfileImageViewHolder, position: Int) {

        getItem(position)?.let { holder.bind(it) }
    }

    class ProfileImageViewHolder(private val itemUserProfileImageBinding: ItemUserProfileImageBinding) :
        RecyclerView.ViewHolder(itemUserProfileImageBinding.root) {

        fun bind(item: Data) {
//            itemUserProfileImageBinding.profileImage
//            Coil.load(item)

            Log.d("*******************",item.avatar)

            itemUserProfileImageBinding.profileImage.load(item.avatar)
        }

    }


    object DiffCallback : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }
}
