package com.ujangwahyu.app.features.source.data.di

import com.ujangwahyu.app.features.source.data.SourceApiService
import com.ujangwahyu.app.features.source.data.SourceDataSource
import com.ujangwahyu.app.features.source.domain.SourceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

@InstallIn(SingletonComponent::class)
@Module
class SourceDataModule {

    @Provides
    fun provideDatasource(
        apiService: SourceApiService
    ): SourceRepository {
        return SourceDataSource(apiService)
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): SourceApiService {
        return retrofit.create(SourceApiService::class.java)
    }

}