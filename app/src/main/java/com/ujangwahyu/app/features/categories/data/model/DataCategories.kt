package com.ujangwahyu.app.features.categories.data.model

import android.os.Parcelable
import com.ujangwahyu.app.features.categories.domain.model.CategoriesItem
import kotlinx.parcelize.Parcelize

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

@Parcelize
data class DataCategories(
    var id: String?,
    var title: String?,
    var icon: String?,
    var color: String?
) : Parcelable {
    fun mapToDomain(): CategoriesItem {
        return CategoriesItem(
            id = this.id,
            title = this.title,
            icon = this.icon,
            color = this.color
        )
    }
}
