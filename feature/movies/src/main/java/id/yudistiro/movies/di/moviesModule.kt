package id.yudistiro.movies.di

import id.yudistiro.movies.ui.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by yudistiro15 on 05/05/20
 */

val moviesModule = module {
    viewModel { MoviesViewModel(get()) }
}