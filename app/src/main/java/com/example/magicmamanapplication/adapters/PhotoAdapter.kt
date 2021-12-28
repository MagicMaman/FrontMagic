package com.example.magicmamanapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.magicmamanapplication.DataModel
import com.example.magicmamanapplication.R

class PhotoAdapter(var context : Context,
                   private val clickListener:(String) -> Unit
                   )  : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {
    var dataList = emptyList<DataModel>()
    internal fun setDataList(dataList : List<DataModel>){
        this.dataList = dataList
    }

    class ViewHolder(itemView : View, clickAtPosition:(Int)-> Unit) : RecyclerView.ViewHolder(itemView) {
        var imagePhoto : ImageView = itemView.findViewById(R.id.imagePhoto)
        var titlePhoto : TextView = itemView.findViewById(R.id.titlePhoto)

        init {
             itemView.setOnClickListener {
                 clickAtPosition(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoAdapter.ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.photo_layout,
                parent, false
            )
        ) {

            clickListener(dataList[it].toString())
        }
    }
    override fun onBindViewHolder(holder: PhotoAdapter.ViewHolder, position: Int) {
        var data = dataList[position]

        holder.titlePhoto.text = data.titlePhoto
        holder.imagePhoto.setImageResource(data.imagePhoto)
    }
    override fun getItemCount()=dataList.size
}