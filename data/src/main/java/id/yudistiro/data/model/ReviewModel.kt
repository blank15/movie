package id.yudistiro.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by yudistiro15 on 05/05/20
 */

data class ReviewModel(
        @SerializedName("page") @Expose val page: Int,
        @SerializedName("total_pages") val totalPages: Int,
        @SerializedName("total_results") @Expose val totalResults: Int,
        @SerializedName("results") @Expose var resultsMovie: List<ReviewList>
)
data class ReviewList(
        val id:String,
        val author:String,
        val content:String
)