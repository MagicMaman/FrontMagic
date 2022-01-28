package com.example.magicmamanapplication.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.magicmamanapplication.MainViewModel
import com.example.magicmamanapplication.MainViewModelFactory
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.adapters.MyMedicamentAdapter
import com.example.magicmamanapplication.adapters.MyPoidsAdapter
import com.example.magicmamanapplication.repository.Repository
import kotlinx.android.synthetic.main.activity_resume_medicaments.*
import kotlinx.android.synthetic.main.activity_resume_poids.*

class ResumeMedicaments : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel


    private val myAdapter by lazy { MyMedicamentAdapter() }
    lateinit var tvprenombebe: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume_medicaments)
        setupRecyclerview()

        val sharedPreferences = getSharedPreferences("sharedPrefs2", Context.MODE_PRIVATE)
        val savedString=sharedPreferences.getString("STRING_KEY", null)

        tvprenombebe=findViewById(R.id.textViewdisplaybabym)
        tvprenombebe.text="Nom Bebe: "+savedString


        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.myCustomMedicament(5,"id", "desc")

        viewModel.myCustomMedicament.observe(this, Observer { response ->

            if(response.isSuccessful){
                response.body()?.let { myAdapter.setData(it) }
            }else {
                //textView2.text=response.code().toString()
            }
        })

    }

    private fun setupRecyclerview() {
        recycleviewMedicament.adapter = myAdapter
        recycleviewMedicament.layoutManager = LinearLayoutManager(this)

    }
}