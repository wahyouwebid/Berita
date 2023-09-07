package com.ujangwahyu.app.features.categories.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

@Parcelize
data class CategoriesItem(
    var id: String?,
    var title: String?,
    var icon: String?,
    var color: String?
) : Parcelable
