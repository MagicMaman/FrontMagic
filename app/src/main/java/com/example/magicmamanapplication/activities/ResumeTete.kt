package com.example.magicmamanapplication.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.magicmamanapplication.MainViewModel
import com.example.magicmamanapplication.MainViewModelFactory
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.repository.Repository
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.magicmamanapplication.SwipeGesture
import com.example.magicmamanapplication.adapters.MyteteAdapter
import kotlinx.android.synthetic.main.activity_resume_tete.*


class ResumeTete : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    lateinit var tvprenombebe:TextView


    private val myAdapter by lazy { MyteteAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume_tete)
        setupRecyclerview()

        val sharedPreferences = getSharedPreferences("sharedPrefs2", Context.MODE_PRIVATE)
        val savedString=sharedPreferences.getString("STRING_KEY", null)

        tvprenombebe=findViewById(R.id.textViewshared)
        tvprenombebe.text="Nom Bebe: "+savedString

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.getCustomTete(5,"id", "desc")

        viewModel.myCustomTete.observe(this, Observer { response ->

            /*  if(response.isSuccessful){
                  textView2.text=response.body().toString()   //Mettre dans adapter: arrayList

              }*/

            if(response.isSuccessful){
                response.body()?.let { myAdapter.setData(it) }
            }else {
                //textView2.text=response.code().toString()
            }
        })

        val swipegesture = object : SwipeGesture(this){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                when(direction) {
                    ItemTouchHelper.LEFT -> {
                        myAdapter.deleteItem(viewHolder.adapterPosition)
                    }
                }

            }
        }
        val touchHelper = ItemTouchHelper(swipegesture)
        val recyclerviewTete= findViewById<RecyclerView>(R.id.recycleviewTete)
        touchHelper.attachToRecyclerView(recyclerviewTete)

    }



    private fun setupRecyclerview() {
        recycleviewTete.adapter = myAdapter
        recycleviewTete.layoutManager = LinearLayoutManager(this)


    }


}
