package com.luka.travel.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.paging.map
import androidx.viewpager.widget.ViewPager
import com.luka.travel.R
import com.luka.travel.databinding.FragmentHomeBinding
import com.luka.travel.model.DestinationPhoto
import com.luka.travel.ui.adapters.CountryAdapter
import com.luka.travel.ui.dashboard.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null


    private lateinit var adapter: CountryAdapter
    private lateinit var models: List<DestinationPhoto>
    private lateinit var viewPager: ViewPager
    var sliderDotspanel: LinearLayout? = null
    private var dotscount = 0
    private val binding get() = _binding!!

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel.text.observe(viewLifecycleOwner) {
        }
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPagerSetUp()
    }


    private fun viewPagerSetUp() {

        lifecycleScope.launch {


            homeViewModel.getDestination().collectLatest {

                val destinationPhotos = mutableListOf<DestinationPhoto>()

                it.map {
                    Log.d(
                        "receiving locations", it.description!!
                    )

                    destinationPhotos.add(it)
                }

                adapter = CountryAdapter(destinationPhotos, requireContext())

            }
        }

        viewPager = binding.viewPagerCountries
        sliderDotspanel = binding.sliderDots


        viewPager.adapter = adapter


        dotscount = adapter.count

        val dots = arrayOfNulls<ImageView>(dotscount)

        for (i in 0 until dotscount) {
            dots[i] = ImageView(requireContext())
            dots[i]!!.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.inactive_dot
                )
            )
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(8, 0, 8, 0)
            sliderDotspanel!!.addView(dots[i], params)
        }
        dots[0]?.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(), R.drawable.active_dot
            )
        )


        viewPager.clipToPadding = false;
        viewPager.setPadding(100, 0, 100, 0)
        viewPager.pageMargin = 20;

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                for (i in 0 until dotscount) {
                    dots[i]?.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(), R.drawable.inactive_dot
                        )
                    )
                }
                dots[position]?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(), R.drawable.active_dot
                    )
                )
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
