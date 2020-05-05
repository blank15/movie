package id.yudistiro.detailmovie.paging

import androidx.paging.PageKeyedDataSource
import id.yudistiro.data.model.ReviewList
import id.yudistiro.data.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Created by yudistiro15 on 05/05/20
 */

class ReviewSourceFormat(
        private val genreId: String,
        private val repository: MovieRepository
) : PageKeyedDataSource<Int, ReviewList>() {
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, ReviewList>) {
        GlobalScope.launch(Dispatchers.IO) {
            val data = repository.getReview(genreId, 1)
            callback.onResult(data.resultsMovie, null, 2)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ReviewList>) {
        GlobalScope.launch(Dispatchers.IO) {
            val data = repository.getReview(genreId, params.key)
            var nextKey = params.key
            if (data.totalPages != params.key) {
                nextKey += 1
            }
            callback.onResult(data.resultsMovie, nextKey)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ReviewList>) {
        TODO("Not yet implemented")
    }

}