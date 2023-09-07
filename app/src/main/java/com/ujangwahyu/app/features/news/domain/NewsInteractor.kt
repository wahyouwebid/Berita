package com.ujangwahyu.app.features.news.domain

import androidx.paging.PagingData
import androidx.paging.rxjava3.cachedIn
import androidx.paging.rxjava3.flowable
import com.ujangwahyu.app.features.news.domain.model.NewsItem
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
class NewsInteractor @Inject constructor(
    private val repository: NewsRepository,
    private val disposable: CompositeDisposable
) : NewsUseCase {

    override fun getNews(
        sources: String,
        scope: CoroutineScope,
        callback: (PagingData<NewsItem>) -> Unit
    ) {
        repository.getNews(sources).flowable
            .cachedIn(scope)
            .subscribe(callback)
            .let { return@let disposable::add}
    }

}