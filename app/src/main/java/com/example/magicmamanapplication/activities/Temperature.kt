package com.example.magicmamanapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.databinding.ActivityTemperatureBinding
import com.example.magicmamanapplication.databinding.ActivityVaccinBinding
import com.example.magicmamanapplication.fragments.TimePickerFragment
import com.google.android.material.bottomsheet.BottomSheetDialog

class Temperature : AppCompatActivity() {
    private lateinit var binding: ActivityTemperatureBinding
    lateinit var etTimeTemperature: EditText
    lateinit var saveTimeTv8: TextView
    lateinit var saveNotesTemperature : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTemperatureBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_temperature)

        etTimeTemperature=findViewById(R.id.etTimeTemperature)
        etTimeTemperature.setOnClickListener{ showTimePickerDialog()}
        binding.btnNextTemperature.setOnClickListener {
            val dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
            val view = layoutInflater.inflate(R.layout.fragment_btn_sheet_temperature,null)
            val close8 = view.findViewById<ImageView>(R.id.close8)


            close8.setOnClickListener{
                dialog.dismiss()
            }

            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()

            val time=binding.etTimeTemperature.text.toString()
            val note=binding.edtNotesTemperature.text.toString()
            val temperature =binding.etTemperature.text.toString()

            saveTimeTv8=view.findViewById(R.id.saveTimeTv8)
            saveTimeTv8.text="$time"//recuperation de données de activity

            saveNotesTemperature=view.findViewById(R.id.saveNotesTemperature)
            saveNotesTemperature.text="$temperature $note"
        }





    }






















    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment {onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "time")
    }

    private fun onTimeSelected(time: String){
        etTimeTemperature.setText("$time")

    }
}