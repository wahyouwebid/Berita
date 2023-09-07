package com.ujangwahyu.app.features.source.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

@Parcelize
class SourceItem (
    val name: String?,
    val description: String?,
    val id: String?,
): Parcelable