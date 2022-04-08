package com.luka.travel.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserResponse(
    @Json(name = "data")
    val data: List<Data>,
    @Json(name = "page")
    val page: Int,
    @Json(name = "per_page")
    val per_page: Int,
    @Json(name = "support")
    val support: Support,
    @Json(name = "total")
    val total: Int,
    @Json(name = "total_pages")
    val total_pages: Int
)
@JsonClass(generateAdapter = true)
data class Support(
    @Json(name = "text")
    val text: String,
    @Json(name = "url")
    val url: String
)


data class Data(
    @Json(name = "avatar")
    val avatar: String,
    @Json(name = "email")
    val email: String,
    @Json(name = "first_name")
    val first_name: String,
    @Json(name = "name")
    val id: Int,
    @Json(name = "last_name")
    val last_name: String
)
