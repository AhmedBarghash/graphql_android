package network.interceptors

import NetworkFactory
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by ma7moud on 10/4/17.
 */
class NetworkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
                .addHeader("lang", NetworkFactory.lang)
                .addHeader("accessToken", NetworkFactory.token)
                .addHeader("Content-Type", "application/json")
                .build()
        return chain.proceed(request)
    }
}