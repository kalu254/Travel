package com.luka.travel.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.luka.travel.model.DestinationPhoto
import com.luka.travel.network.DestinationService
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


private const val STARTING_INDEX = 1;


class DestinationPagingSource @Inject constructor (
    private val service : DestinationService,
    private val querry: String,
) : PagingSource<Int, DestinationPhoto>() {

    override fun getRefreshKey(state: PagingState<Int, DestinationPhoto>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): PagingSource.LoadResult<Int, DestinationPhoto> {
        val position = params.key ?: 1

        return try {
            val response = service.searchPhotos(querry, position, params.loadSize)
            val photos = response.results

            LoadResult.Page(
                data = photos,
                prevKey = if (position == STARTING_INDEX) null else position - 1,
                nextKey = if (photos.isEmpty()) null else position + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e);

        } catch (e: HttpException) {
            LoadResult.Error(e);
        }
    }
}

