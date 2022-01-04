package com.example.magicmamanapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.data.PoidsItem
import com.example.magicmamanapplication.data.SommeilItem
import com.example.magicmamanapplication.data.TemperatureItem
import kotlinx.android.synthetic.main.poids_item_layout.view.*
import kotlinx.android.synthetic.main.poids_item_layout.view.ResumeDatePoids
import kotlinx.android.synthetic.main.poids_item_layout.view.ResumeNotesPoids
import kotlinx.android.synthetic.main.poids_item_layout.view.ResumeWeight
import kotlinx.android.synthetic.main.sommeil_item_layout.view.*
import kotlinx.android.synthetic.main.sommeil_item_layout.view.ResumeAwake
import kotlinx.android.synthetic.main.temperature_item_layout.view.*

class MyTemperatureAdapter: RecyclerView.Adapter<MyTemperatureAdapter.MyViewHolder>(){

    private var myList = emptyList<TemperatureItem>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.temperature_item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemView.ResumeTimeTemperature.text=myList[position].time
        holder.itemView.ResumeFever.text=myList[position].temperature
        holder.itemView.ResumeNotesTemperature.text=myList[position].notes


    }

    fun setData(newList: List<TemperatureItem>){
        myList = newList
        notifyDataSetChanged()
    }

}