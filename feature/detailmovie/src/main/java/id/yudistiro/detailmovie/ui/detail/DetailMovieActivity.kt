package id.yudistiro.detailmovie.ui.detail

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import id.yudistiro.common.util.Constanta
import id.yudistiro.data.model.ResultMovie
import id.yudistiro.data.model.VideoModel
import id.yudistiro.detailmovie.R
import id.yudistiro.detailmovie.ui.review.ReviewActivity
import kotlinx.android.synthetic.main.activity_detail_movie.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailMovieActivity : AppCompatActivity() {

    private val detailViewModel: DetailViewModel by viewModel()
    private var idMovie = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        idMovie = intent.getIntExtra(Constanta.Key.ID_MOVIE, 0)

        detailViewModel.getDetail(idMovie.toString()).observe(
                this, Observer(this::setView)
        )

    }

    private fun onClickVideo(videoModel: VideoModel) {

        play_youtube.setOnClickListener {
            if (videoModel.results.size >= 0) {
                val id = videoModel.results[0][Constanta.Key.KEY_YOUTUBE]
                val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$id"))
                val webIntent = Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.youtube.com/watch?v=$id"))
                try {
                    startActivity(appIntent)
                } catch (ex: ActivityNotFoundException) {
                    startActivity(webIntent)
                }
            } else {
                Toast.makeText(this, "Trailer Tidak tersedia", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun setView(resultMovie: ResultMovie) {
        back_button.setOnClickListener {
            onBackPressed()
        }
        detailViewModel.getVideoData(idMovie.toString()).observe(
                this, Observer(this::onClickVideo)
        )
        Glide.with(this).load("https://image.tmdb.org/t/p/w185/${resultMovie.posterPath}").into(object : SimpleTarget<Drawable>() {
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                image_item.background = resource
                progress_circular.visibility = View.GONE
            }

            override fun onLoadStarted(placeholder: Drawable?) {
                super.onLoadStarted(placeholder)
                progress_circular.visibility = View.VISIBLE
            }
        })
        Glide.with(this).load("https://image.tmdb.org/t/p/w185${resultMovie.backdropPath}").into(object : SimpleTarget<Drawable>() {
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                image_backdrop.background = resource
            }

        })
        text_score_iem.text = resultMovie.popularity.toString()
        text_name_item.text = resultMovie.title
        text_sinopsis_item.text = resultMovie.overview
        text_genre.text = resultMovie.releaseDate
        button_review.setOnClickListener {
            val intent = Intent(this,ReviewActivity::class.java)
            intent.putExtra(Constanta.Key.ID,idMovie)
            startActivity(intent)
        }

    }
}

