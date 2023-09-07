package com.ujangwahyu.app.features.news.domain

import androidx.paging.Pager
import com.ujangwahyu.app.features.news.domain.model.NewsItem

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

interface NewsRepository {

    fun getNews(sources: String): Pager<Int, NewsItem>
}