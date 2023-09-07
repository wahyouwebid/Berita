package com.ujangwahyu.app.features.favourite.domain

import androidx.paging.PagingData
import com.ujangwahyu.app.core.database.entity.FavouriteEntity
import kotlinx.coroutines.CoroutineScope

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

interface FavouriteUseCase {

    fun getFavourite(
        scope: CoroutineScope,
        callback: (PagingData<FavouriteEntity>) -> Unit
    )

    fun getFavouriteByTitle(title: String, callback: (FavouriteEntity) -> Unit)

    fun insertFavourite(data: FavouriteEntity)

    fun deleteFavourite(title: String)

}