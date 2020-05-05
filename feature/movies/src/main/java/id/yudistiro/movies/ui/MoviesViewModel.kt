package id.yudistiro.movies.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.yudistiro.data.model.ResultMovie
import id.yudistiro.data.repository.MovieRepository
import id.yudistiro.movies.paging.MovieSourceFactory

/**
 * Created by yudistiro15 on 05/05/20
 */

class MoviesViewModel (private val repository: MovieRepository) : ViewModel(){

    fun getListMovie(genreId:String) : LiveData<PagedList<ResultMovie>>{
        val movieSourceFactory = MovieSourceFactory(genreId,repository)
        val config = PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .build()

        return LivePagedListBuilder(movieSourceFactory,config).build()
    }
}