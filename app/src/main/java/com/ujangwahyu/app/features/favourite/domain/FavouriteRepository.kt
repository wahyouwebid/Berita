package com.ujangwahyu.app.features.favourite.domain

import androidx.paging.Pager
import com.ujangwahyu.app.core.database.entity.FavouriteEntity

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

interface FavouriteRepository {

    fun getFavourite(): Pager<Int, FavouriteEntity>

    fun getFavouriteByTitle(title: String, callback: (FavouriteEntity) -> Unit)

    fun insertFavourite(data: FavouriteEntity)

    fun deleteFavourite(title: String)
}