package com.ujangwahyu.app.features.search.domain

import androidx.paging.Pager
import com.ujangwahyu.app.features.search.domain.model.SearchItem

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

interface SearchRepository {

    fun searchNews(query: String): Pager<Int, SearchItem>

}