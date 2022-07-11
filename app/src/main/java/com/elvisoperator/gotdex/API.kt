package com.elvisoperator.gotdex

import com.google.gson.Gson
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class API {

    private fun getAPI(): GotAPI {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .baseUrl("https://api.got.show/api/show/")
            .build();
        return retrofit.create(GotAPI::class.java)
    }

    fun getCharacters(callback: Callback<List<GotCharacter>>){
        getAPI().getCharacters().enqueue(callback)
    }

}