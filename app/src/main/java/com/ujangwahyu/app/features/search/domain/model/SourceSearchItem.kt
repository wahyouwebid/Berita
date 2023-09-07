package com.ujangwahyu.app.features.search.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

@Parcelize
data class SourceSearchItem(
    @SerializedName("id")
    val id: String? = "",

    @SerializedName("name")
    val name: String? = ""
) : Parcelable

