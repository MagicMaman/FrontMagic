package com.example.magicmamanapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.databinding.ActivityPoidsBinding
import com.example.magicmamanapplication.databinding.ActivityTailleBinding
import com.example.magicmamanapplication.fragments.TimePickerFragment
import com.google.android.material.bottomsheet.BottomSheetDialog

class Poids : AppCompatActivity() {

    private lateinit var binding: ActivityPoidsBinding
    lateinit var etTimePoids: EditText
    lateinit var saveTimeTv6: TextView
    lateinit var saveNotesPoids : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityPoidsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_poids)
        etTimePoids=findViewById(R.id.etTimePoids)
        etTimePoids.setOnClickListener{ showTimePickerDialog()}

        binding.btnNextPoids.setOnClickListener {
            val dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
            val view = layoutInflater.inflate(R.layout.fragment_btn_sheet_poids,null)
            val close6 = view.findViewById<ImageView>(R.id.close6)

            close6.setOnClickListener{
                dialog.dismiss()
            }
            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()

            val time=binding.etTimePoids.text.toString()
            val note=binding.edtNotesPoids.text.toString()
            val poids =binding.edtPoids.text.toString()

            saveTimeTv6=view.findViewById(R.id.saveTimeTv6)
            saveTimeTv6.text="$time"//recuperation de données de activity

            saveNotesPoids=view.findViewById(R.id.saveNotesPoids)
            saveNotesPoids.text="$poids $note"
        }

    }
    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment {onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "time")
    }

    private fun onTimeSelected(time: String){
        etTimePoids.setText("$time")

    }
}