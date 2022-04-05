package com.luka.travel.ui.country_details

import DestinationsAdapter
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.luka.travel.R
import com.luka.travel.databinding.CountryDetailsFragmentBinding
import com.luka.travel.ui.adapters.ProfileImagesAdapter
import com.luka.travel.ui.home.HomeFragment
import com.luka.travel.utils.DummyDestinationData
import com.luka.travel.utils.MarginItemDecoration
import com.luka.travel.utils.OverlapDecoration

class CountryDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = CountryDetailsFragment()
    }

    private lateinit var viewModel: CountryDetailsViewModel
    private lateinit var binding: CountryDetailsFragmentBinding
    private lateinit var likedUserProfileImagesList: RecyclerView
    private lateinit var destinationsList: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            CountryDetailsFragmentBinding.inflate(inflater, container, false)

        likedUserProfileImagesList = binding.likedImageList
        destinationsList = binding.recylerImageDestinationSlide
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CountryDetailsViewModel::class.java]

        binding.linearLayoutBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
        backPressCustomImplimentation()
        setUpLikedUsers()
        setUpPlacesToVisit()

    }

    private fun setUpPlacesToVisit() {
        destinationsList.adapter =
            DestinationsAdapter(DummyDestinationData.dummyCountryResponse.dataInfo)
        destinationsList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        destinationsList.addItemDecoration(MarginItemDecoration(8))
    }

    private fun backPressCustomImplimentation() {
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // Do custom work here

                    // if you want onBackPressed() to be called as normal afterwards
                    if (isEnabled) {
                        isEnabled = false
                        requireActivity().onBackPressed()

                    }
                }
            }
            )
    }

    private fun setUpLikedUsers() {
        val userImages = arrayListOf(
            R.drawable.user_1,
            R.drawable.user_2,
            R.drawable.user_3,
        )

        likedUserProfileImagesList.adapter = ProfileImagesAdapter(userImages)
        likedUserProfileImagesList.addItemDecoration(OverlapDecoration())
        likedUserProfileImagesList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }

}
