package com.ujangwahyu.app.features.search.data.di

import androidx.paging.PagingConfig
import com.ujangwahyu.app.features.search.data.SearchApiService
import com.ujangwahyu.app.features.search.data.SearchDataSource
import com.ujangwahyu.app.features.search.data.SearchPagingSource
import com.ujangwahyu.app.features.search.domain.SearchRepository
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
class SearchDataModule {

    @Provides
    fun provideDatasource(
        pagingSource: SearchPagingSource,
        pagingConfig: PagingConfig,
    ): SearchRepository {
        return SearchDataSource(pagingSource, pagingConfig)
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): SearchApiService {
        return retrofit.create(SearchApiService::class.java)
    }

}