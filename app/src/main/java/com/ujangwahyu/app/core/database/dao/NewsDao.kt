package com.ujangwahyu.app.core.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ujangwahyu.app.core.database.entity.FavouriteEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface NewsDao {

    @Query("SELECT * FROM favourite")
    fun get(): PagingSource<Int, FavouriteEntity>

    @Query("SELECT * FROM favourite where title = :title")
    fun getByTitle(title: String): Single<FavouriteEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(data: FavouriteEntity): Completable

    @Query("DELETE FROM favourite WHERE title = :title")
    fun delete(title: String): Completable
}