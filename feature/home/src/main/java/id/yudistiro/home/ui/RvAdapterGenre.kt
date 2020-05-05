package id.yudistiro.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import id.yudistiro.common.util.Constanta
import id.yudistiro.data.model.Genre
import id.yudistiro.home.R

/**
 * Created by yudistiro15 on 05/05/20
 */

class RvAdapterGenre(val listGenre: List<Genre>) : RecyclerView.Adapter<RvAdapterGenre.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.list_genre, parent, false)
        )
    }

    override fun getItemCount(): Int = listGenre.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val genre = listGenre[position]
        holder.bindView(genre)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textGenre: TextView = view.findViewById(R.id.text_genre)

        fun bindView(genre: Genre) {
            textGenre.text = genre.name
            itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putString(Constanta.Key.GENRE,genre.id)
                findNavController(itemView).navigate(R.id.action_homeFragment_to_moviesFragment2,bundle)
            }
        }
    }
}