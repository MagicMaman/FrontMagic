package com.example.magicmamanapplication.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.magicmamanapplication.R

import com.example.magicmamanapplication.fragments.LoginTabFragment

class byeActivity : AppCompatActivity() {
    lateinit var btn:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bye)

        btn=findViewById(R.id.button2 )
        btn.setOnClickListener {
           /* tfassakh shared w thezzzz ll activity elll thebbb aaalaha
           * avec shred houwa essssm el sharedpref mta3na */
            val sharedPreferences = getSharedPreferences("shared", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.apply {
                putString("shared", null)
                putBoolean("IS_REMEMBRED", false)
            }.apply()

            val intent= Intent(this@byeActivity,Register::class.java).apply {





            }
            startActivity(intent);
            finish()

        }
    }
}