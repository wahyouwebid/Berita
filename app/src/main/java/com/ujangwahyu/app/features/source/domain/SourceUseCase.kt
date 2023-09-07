package com.ujangwahyu.app.features.source.domain

import com.ujangwahyu.app.common.base.BaseResultState
import com.ujangwahyu.app.features.source.domain.model.SourceItem
import io.reactivex.rxjava3.disposables.CompositeDisposable

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

interface SourceUseCase {

    fun getSources(
        categories: String,
        callback : (BaseResultState<List<SourceItem>>) -> Unit
    )

    fun getDisposable(): CompositeDisposable
}