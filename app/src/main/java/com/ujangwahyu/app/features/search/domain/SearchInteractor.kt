package com.ujangwahyu.app.features.search.domain

import androidx.paging.PagingData
import androidx.paging.rxjava3.cachedIn
import androidx.paging.rxjava3.flowable
import com.ujangwahyu.app.features.search.domain.model.SearchItem
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
class SearchInteractor @Inject constructor(
    private val repository: SearchRepository,
    private val disposable: CompositeDisposable
) : SearchUseCase {

    override fun searchNews(
        query: String,
        scope: CoroutineScope,
        callback: (PagingData<SearchItem>) -> Unit
    ) {
        repository.searchNews(query).flowable
            .cachedIn(scope)
            .subscribe(callback)
            .let { return@let disposable::add}
    }

    override fun getDisposable(): CompositeDisposable {
        return disposable
    }

}