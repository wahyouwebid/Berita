package com.ujangwahyu.app.features.search.data

import com.ujangwahyu.app.core.model.ResponseNews
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

interface SearchApiService {

    @GET("everything")
    fun searchNews(
        @Query("q") keyword: String?,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int,
    ): Single<ResponseNews>

}