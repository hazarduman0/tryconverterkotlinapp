package com.example.currency.model

data class Currency(
    val name : String,
    val currencyName : String,
    val forexBuying: String,
    val forexSelling: String,
    val banknoteBuying: String,
    val banknoteSelling: String,
    val currencyCode: String
)
