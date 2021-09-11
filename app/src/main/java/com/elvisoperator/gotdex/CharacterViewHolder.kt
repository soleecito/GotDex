package com.elvisoperator.gotdex

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.elvisoperator.gotdex.databinding.ItemCharacterBinding
import com.squareup.picasso.Picasso

class CharacterViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemCharacterBinding.bind(view)
    fun bind(slug:String , image:String){
        Picasso.get().load(image).into(binding.characterImage)
        binding.characterText.text = slug

    }
}