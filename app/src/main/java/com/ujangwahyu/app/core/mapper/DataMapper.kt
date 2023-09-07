package com.ujangwahyu.app.core.mapper

import com.ujangwahyu.app.core.database.entity.FavouriteEntity
import com.ujangwahyu.app.features.detail.model.DataDetail
import com.ujangwahyu.app.features.news.domain.model.NewsItem
import com.ujangwahyu.app.features.search.domain.model.SearchItem

object DataMapper {

    fun NewsItem?.toDataDetail(): DataDetail {
        return DataDetail(
            title = this?.title,
            url = this?.url,
            author = this?.author,
            description = this?.description,
            urlToImage = this?.urlToImage,
            publishedAt = this?.publishedAt,
            content = this?.content,
        )
    }

    fun SearchItem?.toDataDetail(): DataDetail {
        return DataDetail(
            title = this?.title,
            url = this?.url,
            author = this?.author,
            description = this?.description,
            urlToImage = this?.urlToImage,
            publishedAt = this?.publishedAt,
            content = this?.content,
        )
    }

    fun FavouriteEntity?.toDataDetail(): DataDetail {
        return DataDetail(
            title = this?.title,
            url = this?.url,
            author = this?.author,
            description = this?.description,
            urlToImage = this?.urlToImage,
            publishedAt = this?.publishedAt,
            content = this?.content,
        )
    }

}