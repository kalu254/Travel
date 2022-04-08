package com.luka.travel.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.luka.travel.model.ResultsItem
import com.luka.travel.network.PokedexService
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException


private const val Result_STARTING_PAGE_INDEX = 1;

class LocationPagerSource(
    private val pokedexService: PokedexService
) : PagingSource<Int, ResultsItem>() {

    override fun getRefreshKey(state: PagingState<Int, ResultsItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultsItem> {

        val position = params.key ?: 1
        return try {

            println("loading operations -----------")

            val results = mutableListOf<ResultsItem>()
            val response = pokedexService.fetchPokemonList()

            results.addAll(response.results)
            response.results.forEach {
                Timber.d("#######################${it.name + " " + it.url}")
            }

//            response.suspendOnSuccess {
//                Results = data.Results
//            }


            LoadResult.Page(
                data = results,
                prevKey = if (position == Result_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (response.results.isEmpty()) null else position + 1
            )
        } catch (e: IOException) {

            Timber.d("*************io exception*****************${e.message}")
            LoadResult.Error(e);

        } catch (e: HttpException) {
            Timber.d("**********http exception********************${e.message}")

            LoadResult.Error(e);
        }
    }
}
