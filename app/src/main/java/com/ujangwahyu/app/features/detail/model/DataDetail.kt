package com.ujangwahyu.app.features.detail.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

@Parcelize
data class DataDetail(
    var url: String?,
    var title: String?,
    var author: String?,
    var description: String?,
    var urlToImage: String?,
    var publishedAt: String?,
    var content: String?
): Parcelable