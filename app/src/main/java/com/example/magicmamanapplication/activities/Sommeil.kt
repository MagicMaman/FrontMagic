package com.example.magicmamanapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.magicmamanapplication.R

class Sommeil : AppCompatActivity() {
    lateinit var btnSommeil: ImageView
    lateinit var btnReveil: ImageView
    lateinit var btnSons: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sommeil)
        btnSommeil=findViewById(R.id.btnSommeil)
        btnReveil=findViewById(R.id.btnReveil)
        btnSons=findViewById(R.id.btnSons)

        btnSommeil.setOnClickListener {

            val i= Intent(this, Sommeill::class.java)
            startActivity(i)
        }
        btnReveil.setOnClickListener {

            val i= Intent(this, Reveil::class.java)
            startActivity(i)
        }
        btnSons.setOnClickListener {

            val i= Intent(this, Sons::class.java)
            startActivity(i)
        }
    }
}