package com.example.magicmamanapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class Bibrons : AppCompatActivity() {
    lateinit var etTime: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bibrons)
        etTime=findViewById(R.id.etTime)
        etTime.setOnClickListener{ showTimePickerDialog()}
    }

    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment {onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "time")
    }

    private fun onTimeSelected(time: String){
        etTime.setText("$time")

    }
}