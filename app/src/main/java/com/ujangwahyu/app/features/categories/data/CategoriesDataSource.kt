package com.ujangwahyu.app.features.categories.data

import android.content.Context
import com.google.gson.Gson
import com.ujangwahyu.app.common.utils.loadJSONFromAssets
import com.ujangwahyu.app.features.categories.data.model.DataCategories
import com.ujangwahyu.app.features.categories.domain.CategoriesRepository
import com.ujangwahyu.app.features.categories.domain.model.CategoriesItem
import io.reactivex.rxjava3.core.Single

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

class CategoriesDataSource: CategoriesRepository {

    override fun getCategories(context: Context): Single<List<CategoriesItem>> {
        val jsonArray = context.loadJSONFromAssets("categories.json")
        val data = Gson().fromJson(jsonArray, Array<DataCategories>::class.java).toList()
        return Single.just(data.map { it.mapToDomain() })
    }

}