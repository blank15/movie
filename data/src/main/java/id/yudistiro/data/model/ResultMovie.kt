package id.yudistiro.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by yudistiro15 on 05/05/20
 */


@Parcelize
class ResultMovie(
        @SerializedName("id")
        val id: Int,
        @SerializedName("original_name")
        val originalName: String?,
        @SerializedName("overview")
        val overview: String,
        @SerializedName("popularity")
        val popularity: Double,
        @SerializedName("poster_path")
        val posterPath: String,
        @SerializedName("backdrop_path")
        val backdropPath: String,
        @SerializedName("release_date")
        val releaseDate: String?,
        @SerializedName("title")
        val title: String?

) : Parcelable