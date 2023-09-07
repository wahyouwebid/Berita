package com.ujangwahyu.app.features.search.domain.di

import com.ujangwahyu.app.features.search.domain.SearchInteractor
import com.ujangwahyu.app.features.search.domain.SearchRepository
import com.ujangwahyu.app.features.search.domain.SearchUseCase
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
class SearchDomainModule {

    @Provides
    fun provideInteractor(
        repository: SearchRepository,
        disposable: CompositeDisposable
    ): SearchUseCase {
        return SearchInteractor(repository, disposable)
    }

}