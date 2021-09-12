package com.elvisoperator.gotdex

data class GotCharacter(
    val name: String,
    val titles: List<String>,
    val image: String,
    val gender: String,
    val culture: String,
    val house: String,
    val alive: Boolean
)
