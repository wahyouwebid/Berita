package com.ujangwahyu.app.features.news.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.ujangwahyu.app.features.news.domain.NewsUseCase
import com.ujangwahyu.app.features.news.domain.model.NewsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val useCase: NewsUseCase
): ViewModel() {

    val news: MutableLiveData<PagingData<NewsItem>> by lazy {
        MutableLiveData()
    }

    fun getNews(source: String?) {
        useCase.getNews(source ?: "", viewModelScope) {
            news.postValue(it)
        }
    }

}