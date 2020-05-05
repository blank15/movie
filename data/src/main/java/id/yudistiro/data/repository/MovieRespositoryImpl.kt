package id.yudistiro.data.repository

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.yudistiro.data.model.*
import id.yudistiro.data.service.MovieService
import retrofit2.HttpException

/**
 * Created by yudistiro15 on 05/05/20
 */

class MovieRespositoryImpl (private val movieService: MovieService) : MovieRepository{
    val gson = Gson()
    override suspend fun getMovieGenre(): GenresModel {
        return try {
            movieService.getMovieGenre()
        } catch (e: HttpException) {
            var data = ""
            e.response()?.errorBody()?.let {
                data = String(it.bytes())
            }
            return gson.fromJson(data, object : TypeToken<GenresModel>() {}.type)

        }
    }

    override suspend fun getMovieList(genreId: String,page:Int): BaseResult {
        return try {
            movieService.getListMovie(genreId,page)
        } catch (e: HttpException) {
            var data = ""
            e.response()?.errorBody()?.let {
                data = String(it.bytes())
            }
            return gson.fromJson(data, object : TypeToken<BaseResult>() {}.type)

        }
    }

    override suspend fun getDetailMovie(idMovie: String): ResultMovie {
        return try {
            movieService.getDetailMovie(idMovie)
        } catch (e: HttpException) {
            var data = ""
            e.response()?.errorBody()?.let {
                data = String(it.bytes())
            }
            return gson.fromJson(data, object : TypeToken<ResultMovie>() {}.type)

        }
    }

    override suspend fun getVideoData(idMovie: String): VideoModel {
        return try {
            movieService.getVideo(idMovie)
        } catch (e: HttpException) {
            var data = ""
            e.response()?.errorBody()?.let {
                data = String(it.bytes())
            }
            return gson.fromJson(data, object : TypeToken<VideoModel>() {}.type)

        }
    }

    override suspend fun getReview(idMovie: String,page:Int): ReviewModel {
        return try {
            movieService.getReview(idMovie,page)
        } catch (e: HttpException) {
            var data = ""
            e.response()?.errorBody()?.let {
                data = String(it.bytes())
            }
            return gson.fromJson(data, object : TypeToken<ReviewModel>() {}.type)

        }
    }
}