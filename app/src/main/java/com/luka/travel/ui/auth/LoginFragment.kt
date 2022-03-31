package com.luka.travel.ui.auth

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.luka.travel.R
import com.luka.travel.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {


    private lateinit var viewModel: LoginViewModel

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.lgnbtn2.setOnClickListener {
            navigateHome()
        }

    }

    private fun navigateHome() {
//            val directions = ProductListDirections.navigateToProductDetail(productId)

        findNavController().navigate(R.id.action_loginFragment_to_mainActivity)
        requireActivity().finish()

    }

}
