package com.luka.travel.ui.country_details

import DestinationsAdapter
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.lifecycleScope
import androidx.paging.map
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.luka.travel.R
import com.luka.travel.databinding.CountryDetailsFragmentBinding
import com.luka.travel.network.UserService
import com.luka.travel.ui.adapters.ProfileImagesAdapter
import com.luka.travel.utils.MarginItemDecoration
import com.luka.travel.utils.OverlapDecoration
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

class CountryDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = CountryDetailsFragment()
        val TAG = "***************CountryDetailsFragment******************"
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
        setupViewModel()
        binding.imgBackArrow.setOnClickListener {
            requireActivity().onBackPressed()
        }
        backPressCustomImplimentation()
        setUpLikedUsers()
        setUpPlacesToVisit()

    }


    private fun setupViewModel() {
        viewModel =
            ViewModelProvider(
                this,
                CountryDetailsViewModelFactory(UserService.getApiService())
            )[CountryDetailsViewModel::class.java]
    }


    private fun setUpPlacesToVisit() {
//        destinationsList.adapter =
//            DestinationsAdapter(DummyDestinationData.dummyCountryResponse.dataInfo)
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
//        val userImages = arrayListOf(
//            R.drawable.user_1,
//            R.drawable.user_2,
//            R.drawable.user_3,
//        )
        val profilePicturesAdapter = ProfileImagesAdapter()
            viewModel.listData().observe(viewLifecycleOwner) {
                viewLifecycleOwner.lifecycleScope.launch {
//                    it.map {
//                        Log.d(TAG,it.avatar)
//
//                    }
                    profilePicturesAdapter.submitData(it)
                }
            }
            likedUserProfileImagesList.apply {
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                addItemDecoration(OverlapDecoration())
                adapter = profilePicturesAdapter
            }


    }

}
