package com.ujangwahyu.app.features.favourite.data.di

import androidx.paging.PagingConfig
import com.ujangwahyu.app.core.database.RoomDB
import com.ujangwahyu.app.features.favourite.data.FavouriteDataSource
import com.ujangwahyu.app.features.favourite.domain.FavouriteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.disposables.CompositeDisposable


/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

@InstallIn(SingletonComponent::class)
@Module
class NewsDataModule {

    @Provides
    fun provideDatasource(
        db: RoomDB,
        pagingConfig: PagingConfig,
        disposable: CompositeDisposable
    ): FavouriteRepository {
        return FavouriteDataSource(db, pagingConfig, disposable)
    }

}