package com.luka.travel.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.luka.travel.network.DestinationService
import com.luka.travel.paging.DestinationPagingSource
import javax.inject.Inject
import javax.inject.Singleton

class DestinationsRepository  @Inject constructor(private val destinationService: DestinationService)  {


        fun getSearchResults(query: String) =
            Pager(
                config = PagingConfig(
                    pageSize = 20,
                    maxSize = 100,
                    enablePlaceholders = false
                ),
                pagingSourceFactory = { DestinationPagingSource(destinationService, query) }
            ).flow
    }


