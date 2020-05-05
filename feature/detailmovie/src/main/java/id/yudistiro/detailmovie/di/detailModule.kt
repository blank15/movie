package id.yudistiro.detailmovie.di

import id.yudistiro.detailmovie.ui.detail.DetailViewModel
import id.yudistiro.detailmovie.ui.review.ReviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by yudistiro15 on 05/05/20
 */

val detailModule = module {
    viewModel { DetailViewModel(get()) }
    viewModel { ReviewViewModel(get()) }
}