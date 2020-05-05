package id.yudistiro.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by yudistiro15 on 05/05/20
 */

data class GenresModel(
        @SerializedName("genres")
        val genres: List<Genre>
)
@Parcelize
data class Genre(
        @SerializedName("id")
        val id:String,
        @SerializedName("name")
        val name:String
) : Parcelable

