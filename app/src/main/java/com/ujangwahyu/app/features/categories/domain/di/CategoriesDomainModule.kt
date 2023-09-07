package com.ujangwahyu.app.features.categories.domain.di

import com.ujangwahyu.app.features.categories.domain.CategoriesInteractor
import com.ujangwahyu.app.features.categories.domain.CategoriesRepository
import com.ujangwahyu.app.features.categories.domain.CategoriesUseCase
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
class CategoriesDomainModule {

    @Provides
    fun provideInteractor(
        repository: CategoriesRepository,
        disposable: CompositeDisposable
    ): CategoriesUseCase {
        return CategoriesInteractor(repository, disposable)
    }

}