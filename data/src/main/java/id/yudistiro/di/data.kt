package id.yudistiro.di

import id.yudistiro.data.repository.MovieRepository
import id.yudistiro.data.repository.MovieRespositoryImpl
import org.koin.dsl.module

/**
 * Created by yudistiro15 on 05/05/20
 */

val dataModule = module {
    single { MovieRespositoryImpl(get()) as MovieRepository }
    single { MovieRespositoryImpl(get()) }
}