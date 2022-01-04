package com.example.magicmamanapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.data.PoidsItem
import com.example.magicmamanapplication.data.SommeilItem
import com.example.magicmamanapplication.data.VaccinItem
import kotlinx.android.synthetic.main.poids_item_layout.view.*
import kotlinx.android.synthetic.main.sommeil_item_layout.view.*
import kotlinx.android.synthetic.main.sommeil_item_layout.view.ResumeAwake
import kotlinx.android.synthetic.main.vaccin_item_layout.view.*

class MyVaccinAdapter: RecyclerView.Adapter<MyVaccinAdapter.MyViewHolder>(){

    private var myList = emptyList<VaccinItem>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.vaccin_item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemView.ResumeTimeVaccin.text=myList[position].time
        holder.itemView.ResumeNameVaccin.text=myList[position].name
        holder.itemView.ResumeNotesVaccin.text=myList[position].notes


    }

    fun setData(newList: List<VaccinItem>){
        myList = newList
        notifyDataSetChanged()
    }

}