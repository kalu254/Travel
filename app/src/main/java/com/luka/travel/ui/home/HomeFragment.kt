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
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.luka.travel.R
import com.luka.travel.databinding.FragmentHomeBinding
import com.luka.travel.model.CountryInfo
import com.luka.travel.model.CountryResponse
import com.luka.travel.model.Metadata
import com.luka.travel.ui.adapters.CountryAdapter
import com.luka.travel.utils.DummyDestinationData

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null


    private lateinit var adapter: CountryAdapter
    private lateinit var models: List<CountryInfo>
    private lateinit var viewPager: ViewPager
    var sliderDotspanel: LinearLayout? = null
    private var dotscount = 0

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
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

    override fun onResume() {
        super.onResume()
        binding.tvExplore.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_countryDetails)
        }

    }

    private fun viewPagerSetUp() {
        viewPager = binding.viewPagerCountries
        sliderDotspanel = binding.sliderDots

        val countryData = DummyDestinationData.dummyCountryResponse.dataInfo

        adapter = CountryAdapter(countryData, requireContext())
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
