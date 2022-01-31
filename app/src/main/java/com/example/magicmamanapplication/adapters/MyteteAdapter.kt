package com.example.magicmamanapplication.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.magicmamanapplication.MainViewModel
import com.example.magicmamanapplication.MainViewModelFactory
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.data.SolideItem
import com.example.magicmamanapplication.data.teteItem
import com.example.magicmamanapplication.repository.Repository
import kotlinx.android.synthetic.main.new_item_layout.view.*

class MyteteAdapter : RecyclerView.Adapter<MyteteAdapter.MyViewHolder>(){
    private lateinit var viewModel: MainViewModel
    var a=""

    private var myList = emptyList<teteItem>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.new_item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemView.ResumeDuration.text=myList[position].time
        holder.itemView.ResumeNotesTete.text=myList[position].notes


    }

    fun setData(newList: List<teteItem>){
        myList = newList
        notifyDataSetChanged()
    }
    fun navigate(){


    }

    fun  deleteItem( i : Int){
        myList.drop(i)
       // Toast.makeText(this,"item id: ",Toast.LENGTH_SHORT).show()
        Log.d("aaaaa",i.toString())
        Log.d("elnotehedhi",myList[i].notes)
            //a==myList[i].notes
        //return a



        notifyDataSetChanged()
    }



}