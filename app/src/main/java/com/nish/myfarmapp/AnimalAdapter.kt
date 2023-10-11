package com.nish.myfarmapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AnimalAdapter(val context:Context, val animals:List<Responses>):RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {
    /**create a view holder class inheriting from RecyclerView.ViewHolder class*/
    class AnimalViewHolder(view:View ):RecyclerView.ViewHolder(view) {
        /**implemented our viewHolder*/
        val photo = view.findViewById<ImageView>(R.id.imageView)
        val nameText = view.findViewById<TextView>(R.id.animal_name)
        val typeText = view.findViewById<TextView>(R.id.animal_type)
        val genderText = view.findViewById<TextView>(R.id.animal_gender)
        val weightText = view.findViewById<TextView>(R.id.animal_weight )

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
       /** create the viewHolder and first call the layout inflater*/
        val view =LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return AnimalViewHolder(view)

    }

    override fun getItemCount(): Int {
       return animals.size
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        /**attach UI to data source*/
        Picasso.get().load(animals[position].image).into(holder.photo)
        holder.nameText.text = animals[position].name
        holder.typeText.text = animals[position].type
        holder.genderText.text = animals[position].gender
        holder.weightText.text = animals[position].weight
    }
}