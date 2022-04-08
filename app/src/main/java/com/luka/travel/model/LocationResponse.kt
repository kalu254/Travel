package com.luka.travel.model

import com.squareup.moshi.Json

data class LocationResponse(

    @Json(name="next")
    val next: String? = null,

    @Json(name="previous")
    val previous: Any? = null,

    @Json(name="count")
    val count: Int? = null,

    @Json(name="results")
    val results: List<ResultsItem>
)

data class ResultsItem(

    @Json(name="name")
    val name: String? = null,

    @Json(name="url")
    val url: String? = null
)
