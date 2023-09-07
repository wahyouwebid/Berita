package com.ujangwahyu.app.features.source.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

data class ResponseSource(

    @field:SerializedName("sources")
	val sources: List<DataSource>,

    @field:SerializedName("status")
	val status: String
)