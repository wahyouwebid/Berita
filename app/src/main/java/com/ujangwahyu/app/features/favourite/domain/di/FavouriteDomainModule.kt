package com.ujangwahyu.app.features.favourite.domain.di

import com.ujangwahyu.app.features.favourite.domain.FavouriteInteractor
import com.ujangwahyu.app.features.favourite.domain.FavouriteRepository
import com.ujangwahyu.app.features.favourite.domain.FavouriteUseCase
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
class FavouriteDomainModule {

    @Provides
    fun provideInteractor(
        repository: FavouriteRepository,
        disposable: CompositeDisposable
    ): FavouriteUseCase {
        return FavouriteInteractor(repository, disposable)
    }

}