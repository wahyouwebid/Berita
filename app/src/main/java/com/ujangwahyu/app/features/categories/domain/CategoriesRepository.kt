package com.ujangwahyu.app.features.categories.domain

import android.content.Context
import com.ujangwahyu.app.features.categories.domain.model.CategoriesItem
import io.reactivex.rxjava3.core.Single

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

interface CategoriesRepository {
    fun getCategories(
        context : Context,
    ): Single<List<CategoriesItem>>
}