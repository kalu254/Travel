package com.luka.travel.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.luka.travel.model.LocationResponse
import com.luka.travel.repository.DestinationsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

    private val destinationsRepository: DestinationsRepository
) :
    ViewModel() {


    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text


    private val _locationResponse = MutableLiveData<LocationResponse>()

    val lRes: LiveData<LocationResponse> = _locationResponse

//
//    suspend fun getLocationStupidly() {
//        viewModelScope.launch {
//            try {
//
//
//                val list = destinationsRepository.fetchPokemonList(2,1)
//                _locationResponse.value = list
//
//
//
//            } catch (e: Exception) {
//
//                e.message?.let { Timber.d("****************************************************${it}") }
//
//            }
//        }
//
//    }

    fun getDestination() = destinationsRepository.getSearchResults("mountain")

//
//    fun  getLocation() =
//        locationRepository.getSearchResults()
//            .cachedIn(viewModelScope)

}
