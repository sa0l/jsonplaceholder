package com.jgc.myjsonplaceholder.di

import com.jgc.myjsonplaceholder.data.repositories.SinglePostRepositoryImpl
import com.jgc.myjsonplaceholder.domain.repository.list.ListRepository
import com.jgc.myjsonplaceholder.domain.repository.single.SinglePostRepository
import com.jgc.myjsonplaceholder.domain.repository.FakeListRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [ApplicationModule::class]
)
class TestApplicationModule {

    @Provides
    @Singleton
    fun providesListRepository(): ListRepository = FakeListRepositoryImpl()

    @Provides
    @Singleton
    fun providesSinglePostRepository(): SinglePostRepository = SinglePostRepositoryImpl()
}