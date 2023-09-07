package com.ujangwahyu.app.features.news.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.ujangwahyu.app.features.news.domain.NewsRepository
import com.ujangwahyu.app.features.news.domain.model.NewsItem
import javax.inject.Inject

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

class NewsDataSource @Inject constructor(
    private val pagingSource : NewsPagingSource,
    private val pagingConfig: PagingConfig,
): NewsRepository {

    override fun getNews(sources: String): Pager<Int, NewsItem> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                pagingSource.source = sources
                pagingSource
            }
        )
    }
}