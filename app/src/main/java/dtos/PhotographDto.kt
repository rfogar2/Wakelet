package dtos

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhotographDto(val image: String, val description: String, val name: String, val bio: String?)