package id.yudistiro.data.repository

import id.yudistiro.data.model.*

/**
 * Created by yudistiro15 on 05/05/20
 */

interface MovieRepository {
    /**
     * @description  Method to get Genre Movie from MovieDB
     * @return  method result with Genre Model with hashmap can get id and name
     */
    suspend fun getMovieGenre() : GenresModel

    /**
     * @description Method to get list movie by genre
     * @param genreId  param contain id from genre movie with string type
     * @param page page of list
     * @return should return with itemmodel
     */
    suspend fun getMovieList(genreId:String,page:Int) : BaseResult

    /**
     * @description Method to get Detail movie by id movie
     * @param idMovie id movie can get from list movie with string type
     * @return retrung with Result detail movie
     */
    suspend fun getDetailMovie(idMovie:String) : ResultMovie

    suspend fun getVideoData(idMovie: String) : VideoModel

    suspend fun getReview(idMovie: String,page:Int) : ReviewModel
}