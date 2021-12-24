package com.example.magicmamanapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Nourriture : AppCompatActivity() {
    lateinit var btnTete: ImageView
    lateinit var btnRepasSolide: ImageView
    lateinit var btnBibrons: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nourriture)
        btnTete=findViewById(R.id.btnTete)
        btnRepasSolide=findViewById(R.id.btnRepasSolide)
        btnBibrons=findViewById(R.id.btnBibrons)

        btnTete.setOnClickListener {

            val i= Intent(this,Tete::class.java)
            startActivity(i)
        }
        btnRepasSolide.setOnClickListener {

            val i= Intent(this,RepasSolide::class.java)
            startActivity(i)
        }
        btnBibrons.setOnClickListener {

            val i= Intent(this,Bibrons::class.java)
            startActivity(i)
        }
    }
}


