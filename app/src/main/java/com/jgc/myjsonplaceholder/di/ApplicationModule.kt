package com.jgc.myjsonplaceholder.di

import com.jgc.myjsonplaceholder.data.repositories.ListRepositoryImpl
import com.jgc.myjsonplaceholder.domain.ListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun providesListRepository(): ListRepository = ListRepositoryImpl()
}