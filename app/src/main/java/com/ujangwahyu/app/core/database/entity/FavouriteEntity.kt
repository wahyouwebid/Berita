package com.ujangwahyu.app.core.database.entity

import android.annotation.SuppressLint
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@SuppressLint("KotlinNullnessAnnotation")
@Entity(tableName = "favourite")
data class FavouriteEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "title")
    var title: String,

    var author: String?,
    var description: String?,
    var url: String?,
    var urlToImage: String?,
    var publishedAt: String?,
    var content: String?
)