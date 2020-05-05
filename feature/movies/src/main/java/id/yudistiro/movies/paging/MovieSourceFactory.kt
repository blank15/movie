package id.yudistiro.movies.paging

import androidx.paging.DataSource
import id.yudistiro.data.model.ResultMovie
import id.yudistiro.data.repository.MovieRepository

/**
 * Created by yudistiro15 on 05/05/20
 */

class MovieSourceFactory (
        private val genreId:String,
        private val repository: MovieRepository
) : DataSource.Factory<Int,ResultMovie>(){
    override fun create(): DataSource<Int, ResultMovie> {
        return MovieSourceFormat(genreId, repository)
    }

}