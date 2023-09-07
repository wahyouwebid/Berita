package com.ujangwahyu.app.features.news.domain

import androidx.paging.PagingData
import com.ujangwahyu.app.features.news.domain.model.NewsItem
import kotlinx.coroutines.CoroutineScope

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

interface NewsUseCase {

    fun getNews(
        sources : String,
        scope: CoroutineScope,
        callback: (PagingData<NewsItem>) -> Unit
    )

}