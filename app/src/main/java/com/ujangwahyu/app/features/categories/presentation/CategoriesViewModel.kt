package com.ujangwahyu.app.features.categories.presentation

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ujangwahyu.app.features.categories.domain.CategoriesUseCase
import com.ujangwahyu.app.features.categories.domain.model.CategoriesItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val useCase: CategoriesUseCase
): ViewModel() {

    val categories: MutableLiveData<List<CategoriesItem>> by lazy {
        MutableLiveData()
    }

    fun getCategories(context: Context) {
        useCase.getCategories(context) {
            categories.postValue(it)
        }
    }
}