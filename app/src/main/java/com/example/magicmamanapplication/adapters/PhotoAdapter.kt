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

class PhotoAdapter(var context : Context)  : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    var dataList = emptyList<DataModel>()

    internal fun setDataList(dataList : List<DataModel>){
        this.dataList = dataList
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var imagePhoto : ImageView
        var titlePhoto : TextView

        init {
            imagePhoto = itemView.findViewById(R.id.imagePhoto)
            titlePhoto = itemView.findViewById(R.id.titlePhoto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.photo_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoAdapter.ViewHolder, position: Int) {
        var data = dataList[position]

        holder.titlePhoto.text = data.titlePhoto
        holder.imagePhoto.setImageResource(data.imagePhoto)
    }

    override fun getItemCount()=dataList.size
}