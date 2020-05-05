package id.yudistiro.home.di

import id.yudistiro.home.ui.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by yudistiro15 on 05/05/20
 */

val homeModule = module {
    viewModel { HomeViewModel(get()) }
}