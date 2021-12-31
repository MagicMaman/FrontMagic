package com.example.magicmamanapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.databinding.ActivitySommeillBinding
import com.example.magicmamanapplication.fragments.TimePickerFragment
import com.google.android.material.bottomsheet.BottomSheetDialog

class Sommeill : AppCompatActivity() {
    private lateinit var binding: ActivitySommeillBinding
    lateinit var etTimeSommeill: EditText
    lateinit var saveTimeTv3: TextView
    lateinit var saveNotesSommeil : TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySommeillBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setContentView(R.layout.activity_sommeill)
        etTimeSommeill=findViewById(R.id.etTimeSommeill)
        etTimeSommeill.setOnClickListener{ showTimePickerDialog()}

        binding.btnNextSommeill.setOnClickListener {
            val dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
            val view = layoutInflater.inflate(R.layout.fragment_btn_sheet_sommeil,null)
            val close3 = view.findViewById<ImageView>(R.id.close3)

            close3.setOnClickListener{
                dialog.dismiss()
            }
            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()

            val time=binding.etTimeSommeill.text.toString()
            val note=binding.edtNotesSommeill.text.toString()

            saveTimeTv3=view.findViewById(R.id.saveTimeTv3)
            saveTimeTv3.text="$time"//recuperation de données de activity

            saveNotesSommeil=view.findViewById(R.id.saveNotesSommeil)
            saveNotesSommeil.text="$note"
        }
    }
    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment {onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "time")
    }

    private fun onTimeSelected(time: String){
        etTimeSommeill.setText("$time")

    }
}