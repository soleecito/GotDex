package com.elvisoperator.gotdex


import android.view.LayoutInflater
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

