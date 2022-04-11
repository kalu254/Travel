package com.luka.travel.ui.country_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.luka.travel.network.UserService
import com.luka.travel.paging.UserPagerSource

class CountryDetailsViewModel(private val userService: UserService) : ViewModel() {

    fun listData() = Pager(PagingConfig(pageSize = 6)) {
        UserPagerSource(userService)
    }.liveData.cachedIn(viewModelScope)
}
