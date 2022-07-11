package com.elvisoperator.gotdex

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface GotAPI {

    @GET("characters")
    fun getCharacters(): Call<List<GotCharacter>>

    @GET("characters/{characterId}")
    fun getArticle(@Path("characterId") id: String): Call<GotCharacter>

    @GET("general/characters")
    fun searchCharacter(@Query("q") query: String): Call<GotCharacter>


}