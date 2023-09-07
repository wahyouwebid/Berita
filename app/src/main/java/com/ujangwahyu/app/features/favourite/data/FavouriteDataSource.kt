package com.ujangwahyu.app.features.favourite.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.ujangwahyu.app.core.database.RoomDB
import com.ujangwahyu.app.core.database.entity.FavouriteEntity
import com.ujangwahyu.app.features.favourite.domain.FavouriteRepository
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

class FavouriteDataSource @Inject constructor(
    private val db : RoomDB,
    private val pagingConfig: PagingConfig,
    private val disposable: CompositeDisposable,
): FavouriteRepository {

    override fun getFavourite(): Pager<Int, FavouriteEntity> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { db.newsDao().get() }
        )
    }

    override fun getFavouriteByTitle(title: String, callback: (FavouriteEntity) -> Unit) {
        db.newsDao().getByTitle(title)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ callback.invoke(it) }, {  })
            .let(disposable::add)
    }

    override fun insertFavourite(data: FavouriteEntity) {
        db.newsDao().insert(data)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    override fun deleteFavourite(title: String) {
        db.newsDao().delete(title)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }
}