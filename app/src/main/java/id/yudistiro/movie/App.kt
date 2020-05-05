package id.yudistiro.movie

import android.app.Application
import id.yudistiro.detailmovie.di.detailModule
import id.yudistiro.di.dataModule
import id.yudistiro.di.serviceModule
import id.yudistiro.home.di.homeModule
import id.yudistiro.movies.di.moviesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Created by yudistiro15 on 05/05/20
 */

class App : Application() {
    val module = listOf(serviceModule, dataModule, homeModule, moviesModule, detailModule)

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(module)
        }
    }
}