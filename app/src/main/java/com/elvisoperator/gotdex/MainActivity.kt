package com.elvisoperator.gotdex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
//import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.elvisoperator.gotdex.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var service: APIService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerViewCharacter.layoutManager = LinearLayoutManager(this)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.got.show/api/show/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(APIService::class.java)

        obtenerDatos()

    }

    private fun obtenerDatos() {
        service.getCharacters().enqueue(object : Callback<List<GotCharacter>> {
            override fun onResponse(
                call: Call<List<GotCharacter>>,
                response: Response<List<GotCharacter>>
            ) {
                if (response.isSuccessful) {
                    val personajes = response.body()
                    //seteamos el adapter
                    binding.recyclerViewCharacter.adapter = CharacterAdapter(personajes!!)
                }

            }

            override fun onFailure(call: Call<List<GotCharacter>>, t: Throwable) {
                t.message?.let { Log.e("Error", it) }
            }

        })
    }
}