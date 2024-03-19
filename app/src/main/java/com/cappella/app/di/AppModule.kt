package com.cappella.app.di

import com.cappella.app.ApplicationBuildConfigFieldsProvider
import com.cappella.core.buildconfig.BuildConfigFieldsProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    internal fun provideBuildConfigFieldsProvider(
        buildConfigFieldsProvider: ApplicationBuildConfigFieldsProvider
    ): BuildConfigFieldsProvider = buildConfigFieldsProvider
}