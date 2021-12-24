package com.example.magicmamanapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class RepasSolide : AppCompatActivity() {
    lateinit var etTimeSolid: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repas_solide)
        etTimeSolid=findViewById(R.id.etTimeSolid)
        etTimeSolid.setOnClickListener{ showTimePickerDialog()}
    }
    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment {onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "time")
    }

    private fun onTimeSelected(time: String){
        etTimeSolid.setText("$time")

    }
}