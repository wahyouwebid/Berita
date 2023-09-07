package com.ujangwahyu.app.features.search.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.ujangwahyu.app.features.search.domain.SearchRepository
import com.ujangwahyu.app.features.search.domain.model.SearchItem
import javax.inject.Inject

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

class SearchDataSource @Inject constructor(
    private val pagingSource : SearchPagingSource,
    private val pagingConfig: PagingConfig,
): SearchRepository {

    override fun searchNews(query: String): Pager<Int, SearchItem> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                pagingSource.query = query
                pagingSource
            }
        )
    }
}