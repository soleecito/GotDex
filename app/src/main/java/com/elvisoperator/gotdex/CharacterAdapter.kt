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