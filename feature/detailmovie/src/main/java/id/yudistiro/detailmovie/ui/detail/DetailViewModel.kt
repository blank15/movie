package id.yudistiro.detailmovie.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import id.yudistiro.data.model.ResultMovie
import id.yudistiro.data.model.VideoModel
import id.yudistiro.data.repository.MovieRepository
import kotlinx.coroutines.Dispatchers

/**
 * Created by yudistiro15 on 05/05/20
 */

class DetailViewModel (val repository: MovieRepository) : ViewModel(){

    fun getDetail(idMovie:String) : LiveData<ResultMovie> =
            liveData(Dispatchers.IO) {
                emit(repository.getDetailMovie(idMovie))
            }
    fun getVideoData(idMovie: String) : LiveData<VideoModel> =
            liveData(Dispatchers.IO) {
                emit(repository.getVideoData(idMovie))
            }
}