package com.luka.travel.ui.country_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.luka.travel.network.UserService

class CountryDetailsViewModelFactory(private val apiService: UserService) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountryDetailsViewModel::class.java)) {
            return CountryDetailsViewModel(apiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
