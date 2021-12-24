package com.example.magicmamanapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Sante : AppCompatActivity() {
    lateinit var btnTemperature: ImageView
    lateinit var btnVaccin: ImageView
    lateinit var btnMedicaments: ImageView
    lateinit var btnMedecin: ImageView
    lateinit var btnHopitaux: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sante)
        btnTemperature=findViewById(R.id.btnTemperature)
        btnVaccin=findViewById(R.id.btnVaccin)
        btnMedicaments=findViewById(R.id.btnMedicaments)
        btnMedecin=findViewById(R.id.btnMedecin)
        btnHopitaux=findViewById(R.id.btnHopitaux)
        btnTemperature.setOnClickListener {

            val i= Intent(this,Temperature::class.java)
            startActivity(i)
        }
        btnVaccin.setOnClickListener {

            val i= Intent(this,Vaccin::class.java)
            startActivity(i)
        }
        btnMedicaments.setOnClickListener {

            val i= Intent(this,Medicaments::class.java)
            startActivity(i)
        }
        btnMedecin.setOnClickListener {

            val i= Intent(this,Medecin::class.java)
            startActivity(i)
        }
        btnHopitaux.setOnClickListener {

            val i= Intent(this,Hopitaux::class.java)
            startActivity(i)
        }
    }
}