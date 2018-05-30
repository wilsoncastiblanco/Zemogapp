package com.zemoga.app.commons.injection.modules

import com.zemoga.app.BuildConfig
import com.zemoga.app.commons.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by wilsoncastiblanco on 5/29/18.
 */
@Module
class NetModule {

    @Provides
    @Singleton
    internal fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constants.Net.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build()
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(interceptor)
        }
        builder.connectTimeout(Constants.Net.CONNECTION_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
        builder.readTimeout(Constants.Net.READ_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
        return builder.build()
    }
}