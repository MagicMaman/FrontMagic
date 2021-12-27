package com.example.magicmamanapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.fragments.TimePickerFragment

class Poids : AppCompatActivity() {
    lateinit var etTimePoids: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poids)
        etTimePoids=findViewById(R.id.etTimePoids)
        etTimePoids.setOnClickListener{ showTimePickerDialog()}
    }

    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment {onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "time")
    }

    private fun onTimeSelected(time: String){
        etTimePoids.setText("$time")

    }
}