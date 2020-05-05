import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * @description load image extension from internet/local with glide
 * @param imageUri Url image or local uri
 */
fun ImageView.load(imageUri: Any) {
    Glide.with(context)
            .load(imageUri)
            .apply(RequestOptions())
            .into(this)
}


