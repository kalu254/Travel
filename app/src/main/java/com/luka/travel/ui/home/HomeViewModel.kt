package com.luka.travel.ui.home

import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.luka.travel.model.LocationResponse
import com.luka.travel.network.PokedexService
import com.luka.travel.paging.LocationPagerSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val retrofit: Retrofit,
    private val pokedexService: PokedexService
) :
    ViewModel() {


    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text


    private val _locationResponse = MutableLiveData<LocationResponse>()

    val lRes: LiveData<LocationResponse> = _locationResponse


    suspend fun getLocationStupidly() {
        viewModelScope.launch {
            try {


                val list = pokedexService.fetchPokemonList()
                _locationResponse.value = list

            } catch (e: Exception) {

                e.message?.let { Timber.d("****************************************************${it}") }

            }
        }

    }

  fun getSearchResults()  = Pager(PagingConfig(pageSize = 6)) {
        LocationPagerSource(pokedexService)
    }.liveData





//        Pager(
//            config = PagingConfig(
//                pageSize = 20,
//                maxSize = 100,
//                enablePlaceholders = false
//            ),
//            pagingSourceFactory = { LocationPagerSource(pokedexService) }
//        ).flow

}
