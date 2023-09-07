package com.ujangwahyu.app.features.categories.data.di

import com.ujangwahyu.app.features.categories.data.CategoriesDataSource
import com.ujangwahyu.app.features.categories.domain.CategoriesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

@InstallIn(SingletonComponent::class)
@Module
class CategoriesDataModule {

    @Provides
    fun provideDatasource(): CategoriesRepository {
        return CategoriesDataSource()
    }

}