package id.yudistiro.data.service

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by yudistiro15 on 05/05/20
 */

class AppInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
                .build()
        return chain.proceed(request)
    }
}