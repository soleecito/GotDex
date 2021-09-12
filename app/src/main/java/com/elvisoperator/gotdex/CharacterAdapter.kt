package com.elvisoperator.gotdex

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CharacterAdapter(val slug:List<String> , val images:List<String>) :
    RecyclerView.Adapter<CharacterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CharacterViewHolder(layoutInflater.inflate(R.layout.item_character , parent , false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {

        val itemImages = images[position]
        val itemSlug = slug[position]
        holder.bind(itemSlug , itemImages)

    }

    override fun getItemCount(): Int {
        return images.size
    }


}

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elvisoperator.gotdex.databinding.ItemCharacterBinding

class CharacterAdapter(val character: List<GotCharacter>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        val binding = ItemCharacterBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        holder.render(character[position])
    }

    override fun getItemCount(): Int = character.size

    class CharacterHolder(val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun render(character: GotCharacter) {
            binding.tvName.text = character.name
            binding.tvHouse.text = character.house
            //binding.ivCharacter               *Implementar picasso para pintar la imagen en el IV
        }
    }
}

