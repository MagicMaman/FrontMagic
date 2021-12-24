package com.example.magicmamanapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var btnGetStarted: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnGetStarted=findViewById(R.id.BtnGetStarted)
        btnGetStarted.setOnClickListener {

            val i= Intent(this,Register::class.java)
            startActivity(i)
        }

    }
}
