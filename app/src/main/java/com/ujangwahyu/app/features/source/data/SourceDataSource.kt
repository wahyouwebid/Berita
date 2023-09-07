package com.ujangwahyu.app.features.source.data

import com.ujangwahyu.app.features.source.domain.SourceRepository
import com.ujangwahyu.app.features.source.domain.model.SourceItem
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

class SourceDataSource @Inject constructor(
    private val apiService: SourceApiService,
): SourceRepository {

    override fun getSources(categories: String): Observable<List<SourceItem>> {
        return apiService.getSource(categories).map { it.sources.map { data -> data.toDomain() }}
    }

}