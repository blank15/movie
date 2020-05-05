package id.yudistiro.movies.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import id.yudistiro.common.util.Constanta
import id.yudistiro.data.model.ResultMovie
import id.yudistiro.movies.R
import kotlinx.android.synthetic.main.fragment_movies.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class MoviesFragment : Fragment() {

    private  var pageListMovie: PageListMovie = PageListMovie()
    private val moviesViewModel : MoviesViewModel by viewModel()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val genre = arguments?.getString(Constanta.Key.GENRE)
        Log.d("genre","$genre")
        rv_movie.apply {
            adapter = pageListMovie
        }
        moviesViewModel.getListMovie(genre.toString())
                .observe(requireActivity(), Observer (this::setView))
    }

    private fun setView(data:PagedList<ResultMovie>){
        pageListMovie.submitList(data)
    }
}
