package id.yudistiro.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by yudistiro15 on 05/05/20
 */

@Parcelize
data class BaseResult(
        @SerializedName("page") @Expose val page: Int,
        @SerializedName("total_pages") val totalPages: Int,
        @SerializedName("total_results") @Expose val totalResults: Int,
        @SerializedName("results") @Expose var resultsMovie: List<ResultMovie>
) : Parcelable