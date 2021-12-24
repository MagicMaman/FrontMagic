package com.example.magicmamanapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class Sommeill : AppCompatActivity() {
    lateinit var etTimeSommeill: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sommeill)
        etTimeSommeill=findViewById(R.id.etTimeSommeill)
        etTimeSommeill.setOnClickListener{ showTimePickerDialog()}
    }
    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment {onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "time")
    }

    private fun onTimeSelected(time: String){
        etTimeSommeill.setText("$time")

    }
}