package id.yudistiro.detailmovie.ui.review

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.yudistiro.data.model.ReviewList
import id.yudistiro.data.repository.MovieRepository
import id.yudistiro.detailmovie.paging.ReviewSourceFactory

/**
 * Created by yudistiro15 on 05/05/20
 */
class ReviewViewModel (val repository: MovieRepository) : ViewModel(){
    fun getReviewMovie(genreId:String) : LiveData<PagedList<ReviewList>> {
        val movieSourceFactory = ReviewSourceFactory(genreId,repository)
        val config = PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .build()

        return LivePagedListBuilder(movieSourceFactory,config).build()
    }
}