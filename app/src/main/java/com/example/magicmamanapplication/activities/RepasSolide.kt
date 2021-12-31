package com.example.magicmamanapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.databinding.ActivityRepasSolideBinding
import com.example.magicmamanapplication.fragments.TimePickerFragment
import com.google.android.material.bottomsheet.BottomSheetDialog

class RepasSolide : AppCompatActivity() {
    private lateinit var binding: ActivityRepasSolideBinding//walid
    lateinit var etTimeSolid: EditText
    lateinit var saveTimeTv1 : TextView//walid
    lateinit var saveNotesRepas : TextView//walid


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRepasSolideBinding.inflate(layoutInflater)//walid
        setContentView(binding.root)//walid
        //setContentView(R.layout.activity_repas_solide) // a eliminer la cause de ne pas travailler de 13h a 15.30h
        etTimeSolid=findViewById(R.id.etTimeSolid)
        etTimeSolid.setOnClickListener{ showTimePickerDialog()}

        binding.btnNextSolid.setOnClickListener {
            val dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
            val view = layoutInflater.inflate(R.layout.fragment_btn_sheet_repas_solide,null)
            val close1 = view.findViewById<ImageView>(R.id.close1)

            close1.setOnClickListener{
                dialog.dismiss()
            }
            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()

            val time=binding.etTimeSolid.text.toString()
            val note=binding.edtNotesSolid.text.toString()
            val namedish=binding.edtSolid.text.toString()

            saveTimeTv1=view.findViewById(R.id.saveTimeTv1)
            saveTimeTv1.text="$time"//recuperation de données de activity

            saveNotesRepas=view.findViewById(R.id.saveNotesRepas)
            saveNotesRepas.text="$namedish $note"



        }
    }
    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment {onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "time")
    }

    private fun onTimeSelected(time: String){
        etTimeSolid.setText("$time")//chaima

    }
}