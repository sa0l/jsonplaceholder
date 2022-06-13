package com.jgc.myjsonplaceholder.di

import com.jgc.myjsonplaceholder.BuildConfig
import com.jgc.myjsonplaceholder.network.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [NetworkModule.NetworkBindingModule::class])
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providesJsonPlaceholderApi(okHttpClient: OkHttpClient): JsonPlaceholderApi {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(JsonPlaceholderApi::class.java)
    }

    @Provides
    @Singleton
    fun providesOkHttp(
        interceptor: HttpLoggingInterceptor,
//        jwtTokenInterceptor: JwtTokenInterceptor,
//        basicHeadersInterceptor: BasicHeadersInterceptor,
//        responseCheckInterceptor: ResponseCheckInterceptor
    ): OkHttpClient {
        val client = OkHttpClient.Builder()
            .readTimeout(DEFAULT_TIMEOUT_VALUE, TimeUnit.SECONDS)
            .callTimeout(DEFAULT_TIMEOUT_VALUE, TimeUnit.SECONDS)
            .connectTimeout(DEFAULT_TIMEOUT_VALUE, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_TIMEOUT_VALUE, TimeUnit.SECONDS)
//        client.addInterceptor(basicHeadersInterceptor)
//        client.addInterceptor(jwtTokenInterceptor)
//        client.addInterceptor(responseCheckInterceptor)
        if (BuildConfig.DEBUG) client.addInterceptor(interceptor)
        return client.build()
    }

    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface NetworkBindingModule {
        @Singleton
        @Binds
        fun bindNetworkManager(impl: NetworkManagerImpl): NetworkManager
    }
}