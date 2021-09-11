package com.elvisoperator.gotdex

data class CharacterResponse(
    val book: Book,
    val show: Show,
    val success: Int
)

data class Book(
    val alive: Boolean,
    val allegiance: List<String>,
    val birth: Int,
    val books: List<String>,
    val children: List<Any>,
    val culture: String,
    val gender: String,
    val house: String,
    val image: String,
    val longevity: List<Any>,
    val longevityB: List<Any>,
    val longevityC: List<Any>,
    val name: String,
    val pagerank: Pagerank,
    val plod: Int,
    val plodB: Int,
    val plodC: Int,
    val slug: String,
    val spouse: List<Any>,
    val titles: List<String>
)

data class Show(
    val actor: String,
    val age: Age,
    val alive: Boolean,
    val allegiances: List<String>,
    val appearances: List<String>,
    val birth: Int,
    val culture: List<String>,
    val father: String,
    val first_seen: String,
    val gender: String,
    val house: String,
    val image: String,
    val longevity: List<Any>,
    val longevityB: List<Any>,
    val longevityC: List<Any>,
    val lovers: List<String>,
    val mother: String,
    val name: String,
    val origin: List<String>,
    val pagerank: PagerankX,
    val plod: Int,
    val plodB: Int,
    val plodC: Int,
    val related: List<Related>,
    val religion: List<String>,
    val seasons: List<Any>,
    val siblings: List<String>,
    val slug: String,
    val spouse: List<Any>,
    val titles: List<String>
)

data class Pagerank(
    val rank: Int,
    val title: String
)

data class Age(
    val age: Int,
    val name: String
)

data class PagerankX(
    val rank: Int,
    val title: String
)

data class Related(
    val alive: Boolean,
    val mentions: Int,
    val name: String,
    val slug: String
)