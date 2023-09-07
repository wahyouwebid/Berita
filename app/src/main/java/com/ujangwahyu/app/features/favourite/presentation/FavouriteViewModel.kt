package com.ujangwahyu.app.features.favourite.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.ujangwahyu.app.core.database.entity.FavouriteEntity
import com.ujangwahyu.app.features.favourite.domain.FavouriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

@HiltViewModel
class FavouriteViewModel @Inject constructor(
    private val useCase: FavouriteUseCase
) : ViewModel() {

    val favouriteList: MutableLiveData<PagingData<FavouriteEntity>> by lazy {
        MutableLiveData()
    }

    val favourite: MutableLiveData<FavouriteEntity> by lazy {
        MutableLiveData()
    }

    fun getFavourite() {
        useCase.getFavourite(viewModelScope) {
            favouriteList.postValue(it)
        }
    }

    fun getFavouriteByTitle(title: String) {
        useCase.getFavouriteByTitle(title) {
            favourite.postValue(it)
        }
    }

    fun insertFavourite(data: FavouriteEntity) {
        useCase.insertFavourite(data)
    }

    fun deleteFavourite(title: String) {
        useCase.deleteFavourite(title)
    }
}