package com.example.streamcinema

import com.example.streamcinema.model.repo.MovieInterface
import com.example.streamcinema.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


@InstallIn(SingletonComponent::class)
@Module
object HiltModule {

    @Provides
    fun provideRetrofitInterFace(): MovieInterface {
        return Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build().create(MovieInterface::class.java)
    }
}