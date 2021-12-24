package com.example.magicmamanapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Croissance : AppCompatActivity() {
    lateinit var btnTaille: ImageView
    lateinit var btnPoids: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_croissance)
        btnTaille=findViewById(R.id.btnTaille)
        btnPoids=findViewById(R.id.btnPoids)
        btnTaille.setOnClickListener {

            val i= Intent(this,Taille::class.java)
            startActivity(i)
        }
        btnPoids.setOnClickListener {

            val i= Intent(this,Poids::class.java)
            startActivity(i)
        }
    }
}