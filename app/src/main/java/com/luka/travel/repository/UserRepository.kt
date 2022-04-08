package com.luka.travel.repository
//
//import androidx.paging.Pager
//import androidx.paging.PagingConfig
//import androidx.paging.PagingData
//import com.luka.travel.network.UserService
//import com.luka.travel.paging.UserPagerSource
//import kotlinx.coroutines.flow.Flow
//import timber.log.Timber
//
//private const val NETWORK_PAGE_SIZE = 30
//
//class GithubRepository(private val service: UserService) {
//
//    fun getSearchResultStream(query: String): Flow<PagingData<Repo>> {
//        Timber.d("GithubRepository", "New query: $query")
//        return Pager(
//            config = PagingConfig(
//                pageSize = NETWORK_PAGE_SIZE,
//                enablePlaceholders = false
//            ),
//            pagingSourceFactory = { UserPagerSource(service, query) }
//        ).flow
//    }
//}
