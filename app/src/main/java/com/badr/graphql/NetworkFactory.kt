
import network.interceptors.NetworkInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * Created by omarkrostom on 01/10/17.
 */
object NetworkFactory {


    lateinit var okHttpClient: OkHttpClient.Builder

    var token = ""
    var lang  = ""

    fun getOkHttpObject(): OkHttpClient {
        okHttpClient = OkHttpClient.Builder()
                .addInterceptor(NetworkInterceptor())
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .cache(null)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
        return okHttpClient.build()
    }

//    fun <T> getRetrofitBuilder(url: String, apiClass: Class<T>): T {
//        return Retrofit.Builder()
//                .baseUrl(url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .client(getOkHttpObject())
//                .build()
//                .create(apiClass)
//    }
}