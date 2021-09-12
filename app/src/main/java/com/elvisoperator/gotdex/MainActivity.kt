package com.elvisoperator.gotdex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.elvisoperator.gotdex.databinding.ActivityMainBinding

/*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.elvisoperator.gotdex.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity() : AppCompatActivity() , SearchView.OnQueryTextListener {

    private lateinit var binding :ActivityMainBinding
    private lateinit var adapter: CharacterAdapter
    private val characterImages = mutableListOf<String>()
    private val characterSlug = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.searchCharacters.setOnQueryTextListener(this)
        initRecyclerView()


    }

    private fun initRecyclerView() {
        adapter = CharacterAdapter(characterSlug , characterImages)
        binding.recyclerViewCharacter.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewCharacter.adapter = adapter
    }

    private fun getRetrofit (): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.got.show/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchByName(query: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getCharacterByName("bySlug/$query")
            val character: Book? = call.body()
            runOnUiThread {
                if(call.isSuccessful){
                    val slug = character?.slug
                    val image = character?.image

                    if(!slug.isNullOrEmpty() && !image.isNullOrEmpty() ){
                        characterImages.clear()
                        characterSlug.clear()
                        characterImages.add(image)
                        characterSlug.add(slug)
                        adapter.notifyDataSetChanged()

                    }


                }else{
                    //show error
                }

            }

        }
    }

    private fun showError(){
        Toast.makeText(this, "Error" ,Toast.LENGTH_LONG).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()) {
            searchByName(query.lowercase())
        }
        return true
    }*/



class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}