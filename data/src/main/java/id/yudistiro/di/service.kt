package id.yudistiro.di

import id.yudistiro.data.BuildConfig
import id.yudistiro.data.service.AppInterceptor
import id.yudistiro.data.service.MovieService
import org.koin.dsl.module

/**
 * Created by yudistiro15 on 04/05/20
 */

val serviceModule = module {
    single { AppInterceptor() }
    single { createOkHttpClient(get()) }
    single { createAPIService<MovieService>(get(),BuildConfig.BASE_URL) }
}