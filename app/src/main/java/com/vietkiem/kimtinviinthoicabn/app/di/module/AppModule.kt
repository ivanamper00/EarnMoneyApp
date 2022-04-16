package com.vietkiem.kimtinviinthoicabn.app.di.module

import com.google.gson.GsonBuilder
import com.vietkiem.kimtinviinthoicabn.app.data.repository.AppRepoGateway
import com.vietkiem.kimtinviinthoicabn.app.data.repository.AppRepoImp
import com.vietkiem.kimtinviinthoicabn.app.domain.repository.AppRepo
import com.vietkiem.kimtinviinthoicabn.app.domain.use_case.GetData
import com.vietkiem.kimtinviinthoicabn.app.domain.use_case.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofitService(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://daku-international-18419.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providesAppRepoService(retrofit: Retrofit): AppRepo = retrofit.create(AppRepo::class.java)

    @Provides
    @Singleton
    fun providesRepoImp(appRepo: AppRepo): AppRepoGateway = AppRepoImp(appRepo)

    @Provides
    @Singleton
    fun provideUseCase(appRepoGateway: AppRepoGateway) = UseCase(
        getData = GetData(appRepoGateway)
    )
}