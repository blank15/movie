package id.yudistiro.detailmovie.ui.review

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.yudistiro.data.model.ReviewList
import id.yudistiro.detailmovie.R

/**
 * Created by yudistiro15 on 05/05/20
 */

class PageListReview : PagedListAdapter<ReviewList, PageListReview.ViewHolder>(DIFF_CALLBACK) {


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ReviewList>() {
            override fun areItemsTheSame(oldItem: ReviewList, newItem: ReviewList): Boolean {
                return oldItem.id == newItem.id
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: ReviewList, newItem: ReviewList): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.list_review,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val textAuhtor : TextView = view.findViewById(R.id.text_author)
        val textContent : TextView = view.findViewById(R.id.text_content)

        fun bind(review:ReviewList?){
            textAuhtor.text = review?.author
            textContent.text = review?.content
        }
    }

}