package id.yudistiro.movies.paging

import androidx.paging.PageKeyedDataSource
import id.yudistiro.data.model.ResultMovie
import id.yudistiro.data.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Created by yudistiro15 on 05/05/20
 *
 */

class MovieSourceFormat (
        private val genreId:String,
        private val repository: MovieRepository
) : PageKeyedDataSource<Int,ResultMovie>(){
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, ResultMovie>) {
         GlobalScope.launch(Dispatchers.IO) {
            val data=  repository.getMovieList(genreId,1)
             callback.onResult(data.resultsMovie,null,2)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ResultMovie>) {
        GlobalScope.launch(Dispatchers.IO) {
            val data=  repository.getMovieList(genreId,params.key)
            var nextKey = params.key
            if (data.totalPages != params.key){
                nextKey +=1
            }
            callback.onResult(data.resultsMovie,nextKey)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ResultMovie>) {
        TODO("Not yet implemented")
    }

}