package com.ujangwahyu.app.features.news.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

@Parcelize
data class NewsItem(
    val modelSource: SourceItem?,
    var author: String?,
    var title: String?,
    var description: String?,
    var url: String?,
    var urlToImage: String?,
    var publishedAt: String?,
    var content: String?
) : Parcelable
