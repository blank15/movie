package id.yudistiro.data.service

import id.yudistiro.data.BuildConfig
import id.yudistiro.data.model.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by yudistiro15 on 05/05/20
 */

interface MovieService {
    @GET("genre/movie/list?api_key=${BuildConfig.MOVIE_API_KEY}&language=en-US")
    suspend fun getMovieGenre(): GenresModel

    @GET("discover/movie?api_key=${BuildConfig.MOVIE_API_KEY}&language=en-US")
    suspend fun getListMovie(@Query("with_genres") genreId:String, @Query("page") page:Int): BaseResult

    @GET("movie/{id}?api_key=${BuildConfig.MOVIE_API_KEY}&language=en-US")
    suspend fun getDetailMovie(@Path("id") id: String): ResultMovie

    @GET("movie/{id}/videos?api_key=${BuildConfig.MOVIE_API_KEY}&language=en-US")
    suspend fun getVideo(@Path("id") idMovie:String) : VideoModel

    @GET("movie/{id}/reviews?api_key=${BuildConfig.MOVIE_API_KEY}&language=en-US")
    suspend fun getReview(@Path("id") id:String, @Query("page") page:Int): ReviewModel

}