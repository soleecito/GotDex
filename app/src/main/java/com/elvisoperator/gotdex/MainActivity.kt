package com.elvisoperator.gotdex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
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
    lateinit var service: GotAPI
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewCharacter.layoutManager = LinearLayoutManager(this)



        getListCharacter()

        //navigation Start (optimizar a funciones)
        toggle = ActionBarDrawerToggle(this,binding.drawerLayout,R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navView.setNavigationItemSelectedListener {


            when(it.itemId){

                R.id.nav_home -> Toast.makeText(applicationContext, "Click Home" , Toast.LENGTH_LONG).show()
                R.id.nav_enemy -> Toast.makeText(applicationContext, "Click Enemy" , Toast.LENGTH_LONG).show()
                R.id.nav_favorite -> Toast.makeText(applicationContext, "Click Favorite" , Toast.LENGTH_LONG).show()
                R.id.nav_settings -> Toast.makeText(applicationContext, "Click Settings" , Toast.LENGTH_LONG).show()
                R.id.nav_login -> Toast.makeText(applicationContext, "Click Login" , Toast.LENGTH_LONG).show()

            }

            true
        }
        //

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun  getListCharacter() {
        API().getCharacters(object :Callback<List<GotCharacter>>{
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