package com.example.magicmamanapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.fragments.TimePickerFragment

class Medicaments : AppCompatActivity() {
    lateinit var etTimeMedicaments: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicaments)

        etTimeMedicaments=findViewById(R.id.etTimeMedicaments)
        etTimeMedicaments.setOnClickListener{ showTimePickerDialog()}
    }
    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment {onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "time")
    }

    private fun onTimeSelected(time: String){
        etTimeMedicaments.setText("$time")

    }
}