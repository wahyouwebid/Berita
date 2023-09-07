package com.ujangwahyu.app.features.source.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.ujangwahyu.app.features.source.domain.model.SourceItem
import kotlinx.parcelize.Parcelize

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

@Parcelize
data class DataSource(

	@field:SerializedName("country")
	val country: String?,

	@field:SerializedName("name")
	val name: String?,

	@field:SerializedName("description")
	val description: String?,

	@field:SerializedName("language")
	val language: String?,

	@field:SerializedName("id")
	val id: String?,

	@field:SerializedName("category")
	val category: String?,

	@field:SerializedName("url")
	val url: String?
): Parcelable {
	fun toDomain(): SourceItem {
		return SourceItem(
			name = this.name ?: "",
			description = this.description ?: "",
			id = this.id ?: ""
		)
	}
}