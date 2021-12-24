package com.example.magicmamanapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class Reveil : AppCompatActivity() {
    lateinit var etTimeReveil: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reveil)
        etTimeReveil=findViewById(R.id.etTimeReveil)
        etTimeReveil.setOnClickListener{ showTimePickerDialog()}
    }
    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment {onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "time")
    }

    private fun onTimeSelected(time: String){
        etTimeReveil.setText("$time")

    }
}