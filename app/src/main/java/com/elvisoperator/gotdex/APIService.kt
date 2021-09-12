package com.elvisoperator.gotdex

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {

    @GET("characters")
    fun getCharacters(): Call<List<GotCharacter>>


}