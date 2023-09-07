package com.ujangwahyu.app.features.categories.domain

import android.content.Context
import android.util.Log
import com.ujangwahyu.app.features.categories.domain.model.CategoriesItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

class CategoriesInteractor @Inject constructor(
    private val repository: CategoriesRepository,
    private val disposable: CompositeDisposable
): CategoriesUseCase {
    override fun getCategories(context: Context, callback: (List<CategoriesItem>) -> Unit) {
        repository.getCategories(context)
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { data -> callback(data) },
                { Log.e("categories",it.message.toString()) }
            )
            .let { return@let disposable::add}
    }
}