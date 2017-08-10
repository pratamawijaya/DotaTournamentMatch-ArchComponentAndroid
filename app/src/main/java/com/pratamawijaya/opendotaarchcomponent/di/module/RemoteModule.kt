package com.pratamawijaya.opendotaarchcomponent.di.module

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.pratamawijaya.opendotaarchcomponent.BuildConfig
import com.pratamawijaya.opendotaarchcomponent.data.OpenDotaApi
import com.pratamawijaya.opendotaarchcomponent.data.repository.matches.MatchesRepository
import com.pratamawijaya.opendotaarchcomponent.data.repository.matches.MatchesRepositoryImpl
import com.pratamawijaya.opendotaarchcomponent.di.ApplicationContext
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by pratama on 8/10/17.
 */
@Module
class RemoteModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gson = GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create()
        return gson
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttp = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)

        return okHttp.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_API)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build()
        return retrofit
    }

    @Provides
    @Singleton
    fun provideOpenDotaApi(retrofit: Retrofit): OpenDotaApi {
        return retrofit.create(OpenDotaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMatchesRepo(api: OpenDotaApi): MatchesRepository = MatchesRepositoryImpl(api)
}