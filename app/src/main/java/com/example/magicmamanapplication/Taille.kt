package com.example.magicmamanapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class Taille : AppCompatActivity() {
    lateinit var etTimeTaille: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taille)
        etTimeTaille=findViewById(R.id.etTimeTaille)
        etTimeTaille.setOnClickListener{ showTimePickerDialog()}
    }

    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment {onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "time")
    }

    private fun onTimeSelected(time: String){
        etTimeTaille.setText("$time")

    }
}