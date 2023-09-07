package com.ujangwahyu.app.features.source.domain

import com.ujangwahyu.app.features.source.domain.model.SourceItem
import io.reactivex.rxjava3.core.Observable

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

interface SourceRepository {

    fun getSources(categories: String): Observable<List<SourceItem>>

}