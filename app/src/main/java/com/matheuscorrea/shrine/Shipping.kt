package com.matheuscorrea.shrine

data class Shipping(
    val number: String,
    val street: String,
    val complement: String,
    val city: String,
    val zipCode: String
)

val SampleShippingData = Shipping(
    number = "345",
    street = "Main St",
    complement = "4th Floor",
    city = "San Francisco",
    zipCode = "CA 94109"
)