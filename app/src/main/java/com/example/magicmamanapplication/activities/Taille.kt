package com.example.magicmamanapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.databinding.ActivitySommeillBinding
import com.example.magicmamanapplication.databinding.ActivityTailleBinding
import com.example.magicmamanapplication.fragments.TimePickerFragment
import com.google.android.material.bottomsheet.BottomSheetDialog

class Taille : AppCompatActivity() {

    private lateinit var binding: ActivityTailleBinding
    lateinit var etTimeTaille: EditText
    lateinit var saveTimeTv5: TextView
    lateinit var saveNotesTaille : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityTailleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_taille)


        etTimeTaille=findViewById(R.id.etTimeTaille)
        etTimeTaille.setOnClickListener{ showTimePickerDialog()}

        binding.btnNextTaille.setOnClickListener {
            val dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
            val view = layoutInflater.inflate(R.layout.fragment_btn_sheet_taille,null)
            val close5 = view.findViewById<ImageView>(R.id.close5)

            close5.setOnClickListener{
                dialog.dismiss()
            }
            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()

            val time=binding.etTimeTaille.text.toString()
            val note=binding.edtNotesTaille.text.toString()
            val height =binding.edtTaille.text.toString()

            saveTimeTv5=view.findViewById(R.id.saveTimeTv5)
            saveTimeTv5.text="$time"//recuperation de données de activity

            saveNotesTaille=view.findViewById(R.id.saveNotesTaille)
            saveNotesTaille.text="$height $note"
        }
    }

    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment {onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "time")
    }

    private fun onTimeSelected(time: String){
        etTimeTaille.setText("$time")

    }
}