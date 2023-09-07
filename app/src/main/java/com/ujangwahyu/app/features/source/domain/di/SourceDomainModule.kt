package com.ujangwahyu.app.features.source.domain.di

import com.ujangwahyu.app.features.source.domain.SourceInteractor
import com.ujangwahyu.app.features.source.domain.SourceRepository
import com.ujangwahyu.app.features.source.domain.SourceUseCase
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
class SourceDomainModule {

    @Provides
    fun provideInteractor(
        repository: SourceRepository,
        disposable: CompositeDisposable
    ): SourceUseCase {
        return SourceInteractor(repository, disposable)
    }

}