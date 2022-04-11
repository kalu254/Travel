package com.luka.travel.repository
//
//import androidx.paging.Pager
//import androidx.paging.PagingConfig
//import com.luka.travel.paging.LocationPagerSource
//import javax.inject.Inject
//import javax.inject.Singleton
//
//@Singleton
//class LocationRepository @Inject constructor(private val pokedexService: PokedexService) {
//    fun getSearchResults() =
//        Pager(
//            config = PagingConfig(
//                pageSize = 2,
//                maxSize = 100,
//                enablePlaceholders = false
//            ),
//            pagingSourceFactory = { LocationPagerSource(pokedexService = pokedexService) }
//        ).flow
//}
