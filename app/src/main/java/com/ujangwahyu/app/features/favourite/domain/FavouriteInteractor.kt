package com.ujangwahyu.app.features.favourite.domain

import androidx.paging.PagingData
import androidx.paging.rxjava3.cachedIn
import androidx.paging.rxjava3.flowable
import com.ujangwahyu.app.core.database.entity.FavouriteEntity
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

@OptIn(ExperimentalCoroutinesApi::class)
class FavouriteInteractor @Inject constructor(
    private val repository: FavouriteRepository,
    private val disposable: CompositeDisposable
) : FavouriteUseCase {

    override fun getFavourite(
        scope: CoroutineScope,
        callback: (PagingData<FavouriteEntity>) -> Unit
    ) {
        repository.getFavourite().flowable
            .cachedIn(scope)
            .subscribe(callback)
            .let { return@let disposable::add}
    }

    override fun getFavouriteByTitle(title: String, callback: (FavouriteEntity) -> Unit) {
        repository.getFavouriteByTitle(title, callback)
    }

    override fun insertFavourite(data: FavouriteEntity) {
        repository.insertFavourite(data)
    }

    override fun deleteFavourite(title: String) {
        repository.deleteFavourite(title)
    }

}