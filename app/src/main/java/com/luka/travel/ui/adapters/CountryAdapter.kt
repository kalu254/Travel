package com.luka.travel.ui.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.viewpager.widget.PagerAdapter
import com.luka.travel.R
import com.luka.travel.model.DestinationPhoto

class CountryAdapter(
    val destinations: List<DestinationPhoto>,
    val context: Context,
) : PagerAdapter() {


    override fun getCount(): Int {

        return destinations.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.item_country, container, false)
        val tvCountry = view.findViewById<TextView>(R.id.tv_country)
        tvCountry.text = destinations[position].description


        container.addView(view, 0)
        return view;
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(container)
    }



}
