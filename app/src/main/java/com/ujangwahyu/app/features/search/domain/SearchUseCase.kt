package com.ujangwahyu.app.features.search.domain

import androidx.paging.PagingData
import com.ujangwahyu.app.features.search.domain.model.SearchItem
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

interface SearchUseCase {

    fun searchNews(
        query: String,
        scope: CoroutineScope,
        callback: (PagingData<SearchItem>) -> Unit
    )

    fun getDisposable(): CompositeDisposable
}