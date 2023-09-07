package com.ujangwahyu.app.features.news.domain.di

import com.ujangwahyu.app.features.news.domain.NewsInteractor
import com.ujangwahyu.app.features.news.domain.NewsRepository
import com.ujangwahyu.app.features.news.domain.NewsUseCase
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
class NewsDomainModule {

    @Provides
    fun provideInteractor(
        repository: NewsRepository,
        disposable: CompositeDisposable
    ): NewsUseCase {
        return NewsInteractor(repository, disposable)
    }

}