package com.example.magicmamanapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.fragments.TimePickerFragment

class Vaccin : AppCompatActivity() {
    lateinit var etTimeVaccin: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vaccin)

        etTimeVaccin=findViewById(R.id.etTimeVaccin)
        etTimeVaccin.setOnClickListener{ showTimePickerDialog()}
    }
    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment {onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "time")
    }

    private fun onTimeSelected(time: String){
        etTimeVaccin.setText("$time")

    }
}