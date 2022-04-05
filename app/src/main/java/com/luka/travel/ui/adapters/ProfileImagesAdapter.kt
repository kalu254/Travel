package com.luka.travel.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.load
import com.luka.travel.databinding.ItemUserProfileImageBinding

class ProfileImagesAdapter(private val userImages: ArrayList<Int>) :
    RecyclerView.Adapter<ProfileImagesAdapter.ProfileImageViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileImageViewHolder {
        val binding =
            ItemUserProfileImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProfileImageViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ProfileImageViewHolder, position: Int) {

        val item = userImages[position]
        if (item != null) {
            holder.bind(item)
        }
    }

    override fun getItemCount(): Int {

        return userImages.size
    }


    class ProfileImageViewHolder(private val itemUserProfileImageBinding: ItemUserProfileImageBinding) :
        RecyclerView.ViewHolder(itemUserProfileImageBinding.root) {

        fun bind(item: Int) {
//            itemUserProfileImageBinding.profileImage
//            Coil.load(item)

            itemUserProfileImageBinding.profileImage.load(item)
        }

    }
}
