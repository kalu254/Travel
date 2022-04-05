package com.luka.travel.utils

import com.luka.travel.model.CountryInfo
import com.luka.travel.model.CountryResponse
import com.luka.travel.model.Metadata

class DummyDestinationData {

    companion object {
        val dummyCountryResponse = CountryResponse(
            dataInfo = listOf(
                CountryInfo(
                    code = "KE",
                    currencyCodes = listOf("KSH"),
                    name = "Kenya",
                    wikiDataId = "001"
                ),
                CountryInfo(
                    code = "KE",
                    currencyCodes = listOf("KSH"),
                    name = "Kenya",
                    wikiDataId = "001"
                ),
                CountryInfo(
                    code = "TZ",
                    currencyCodes = listOf("TSH"),
                    name = "Tanzania",
                    wikiDataId = "002"
                ),
                CountryInfo(
                    code = "UG",
                    currencyCodes = listOf("USH"),
                    name = "Uganda",
                    wikiDataId = "003"
                ),
                CountryInfo(
                    code = "US",
                    currencyCodes = listOf("$"),
                    name = "USA",
                    wikiDataId = "010"
                ),
                CountryInfo(
                    code = "Ng",
                    currencyCodes = listOf("Naira"),
                    name = "Nigeria",
                    wikiDataId = "100"
                ),


                ),
            links = emptyList(),
            metadata = Metadata(
                currentOffset = 0,
                totalCount = 0
            )

        )
    }
}
