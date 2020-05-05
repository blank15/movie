package id.yudistiro.home.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import id.yudistiro.data.model.Genre
import id.yudistiro.data.model.GenresModel

import id.yudistiro.home.R
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    private val homeViewModel : HomeViewModel by viewModel()
    private val listGenre : MutableList<Genre> = mutableListOf()
    private lateinit var adapterGenre: RvAdapterGenre
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapterGenre = RvAdapterGenre(listGenre)
        rv_genre.apply {
            adapter = adapterGenre
        }
        homeViewModel.getGenre().observe(
                requireActivity(), Observer(this::showResult)
        )
    }

    private fun showResult(genresModel: GenresModel){
        listGenre.addAll(genresModel.genres)
        adapterGenre.notifyDataSetChanged()
    }
}
