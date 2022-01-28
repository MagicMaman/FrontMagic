package com.example.magicmamanapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.magicmamanapplication.R

import com.example.magicmamanapplication.fragments.LoginTabFragment

class byeActivity : AppCompatActivity() {
    lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bye)

        btn=findViewById(R.id.button3333 )
        btn.setOnClickListener {

            val i= Intent(this, Register::class.java)
            startActivity(i)
        }
    }
}