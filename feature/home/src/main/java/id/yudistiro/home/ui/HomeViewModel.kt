package id.yudistiro.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.ViewModel
import id.yudistiro.data.model.GenresModel
import id.yudistiro.data.repository.MovieRepository
import kotlinx.coroutines.Dispatchers

/**
 * Created by yudistiro15 on 05/05/20
 */

class HomeViewModel (private val repository: MovieRepository) :  ViewModel() {

    fun getGenre() : LiveData<GenresModel> =
            liveData(Dispatchers.IO) {
                emit(repository.getMovieGenre())
            }
}