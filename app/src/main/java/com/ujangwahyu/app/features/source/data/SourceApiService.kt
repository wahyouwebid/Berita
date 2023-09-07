package com.ujangwahyu.app.features.source.data

import com.ujangwahyu.app.features.source.data.model.ResponseSource
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

interface SourceApiService {

    @GET("sources")
    fun getSource(
        @Query("category") category: String?
    ): Observable<ResponseSource>

}