package id.yudistiro.detailmovie.paging

import androidx.paging.DataSource
import id.yudistiro.data.model.ReviewList
import id.yudistiro.data.repository.MovieRepository

/**
 * Created by yudistiro15 on 05/05/20
 */

class ReviewSourceFactory(
        private val genreId: String,
        private val repository: MovieRepository
) : DataSource.Factory<Int, ReviewList>() {
    override fun create(): DataSource<Int, ReviewList> {
        return ReviewSourceFormat(genreId, repository)
    }

}