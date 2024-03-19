package com.cappella.core.di

import com.cappella.core.buildconfig.BuildConfigFieldsProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun providesOkHttp(
        buildConfigFieldsProvider: BuildConfigFieldsProvider
    ): OkHttpClient {

        return OkHttpClient.Builder().apply {

            if (buildConfigFieldsProvider.get().isDebug) {
                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                addInterceptor(logging)
            }

        }
            .build()
    }

    @Provides
    fun providesRetrofit(
        okHttpClient: OkHttpClient,
        buildConfigFieldsProvider: BuildConfigFieldsProvider
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(buildConfigFieldsProvider.get().baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}