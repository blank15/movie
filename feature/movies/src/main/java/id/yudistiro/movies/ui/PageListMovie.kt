package id.yudistiro.movies.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import id.yudistiro.common.util.Constanta
import id.yudistiro.data.model.ResultMovie
import id.yudistiro.detailmovie.ui.detail.DetailMovieActivity
import id.yudistiro.movies.R
import kotlinx.android.synthetic.main.list_movie.view.*

/**
 * Created by yudistiro15 on 05/05/20
 */
class PageListMovie : PagedListAdapter<ResultMovie, PageListMovie.ViewHolder>(DIFF_CALLBACK){


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ResultMovie>() {
            override fun areItemsTheSame(oldItem: ResultMovie, newItem: ResultMovie): Boolean {
                return oldItem.id == newItem.id
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: ResultMovie, newItem: ResultMovie): Boolean {
                return oldItem == newItem
            }

        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.list_movie,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(getItem(position))
    }

    class ViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        val image : ImageView = view.image_item
        val textName : TextView = view.text_item_name
        val textScore : TextView = view.text_score_iem
        val progressBar : ProgressBar = view.progress_circular

        fun bindItem(item: ResultMovie?){
            textName.text = item?.title
            textScore.text = item?.popularity.toString()
            Glide.with(itemView.context).load("https://image.tmdb.org/t/p/w185/${item?.posterPath}").into(object : SimpleTarget<Drawable>(){
                override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                    progressBar.visibility = View.GONE
                    image.background = resource
                }

                override fun onLoadStarted(placeholder: Drawable?) {
                    super.onLoadStarted(placeholder)
                    progressBar.visibility = View.VISIBLE
                }
            })

            itemView.setOnClickListener {
                val intent = Intent(itemView.context,DetailMovieActivity::class.java)
                intent.putExtra(Constanta.Key.ID_MOVIE,item?.id)
                itemView.context.startActivity(intent)
            }
        }

    }
}