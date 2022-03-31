package com.luka.travel.model


data class CountryResponse(
    val dataInfo: List<CountryInfo>,
    val links: List<Link>,
    val metadata: Metadata
)

data class CountryInfo(
    val code: String,
    val currencyCodes: List<String>,
    val name: String,
    val wikiDataId: String
)

data class Link(
    val href: String,
    val rel: String
)
data class Metadata(
    val currentOffset: Int,
    val totalCount: Int
)

