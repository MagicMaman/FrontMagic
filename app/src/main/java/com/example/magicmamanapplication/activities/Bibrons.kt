package com.example.magicmamanapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.databinding.ActivityBibronsBinding
import com.example.magicmamanapplication.fragments.TimePickerFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class Bibrons : AppCompatActivity() {
    private lateinit var binding: ActivityBibronsBinding
    lateinit var etTimeBibron: EditText
    lateinit var saveTimeTv2 : TextView
    lateinit var saveNotesBibron : TextView
    lateinit var saveQuantityNameTv: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBibronsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_bibrons)
        etTimeBibron=findViewById(R.id.etTimeBibron)
        etTimeBibron.setOnClickListener{ showTimePickerDialog()}

        binding.btnNextBibrons.setOnClickListener {
            val dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
            val offsetFromTop = 200
            (dialog as? BottomSheetDialog)?.behavior?.apply {
                isFitToContents = false
                expandedOffset = offsetFromTop
                state = BottomSheetBehavior.STATE_EXPANDED
            }
            val view = layoutInflater.inflate(R.layout.fragment_btn_sheet_bibron,null)
            val close2 = view.findViewById<ImageView>(R.id.close2)
            val btn_update_bibron = view.findViewById<ImageView>(R.id.btn_update_bibron)

            close2.setOnClickListener{
                dialog.dismiss()
            }
            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()

            btn_update_bibron.setOnClickListener {
                dialog.dismiss()
            }

            val time=binding.etTimeBibron.text.toString()
            val note=binding.edtNotesBibron.text.toString()
            val quantity=binding.edtQuantity.text.toString()

            saveTimeTv2=view.findViewById(R.id.saveTimeTv2)
            saveTimeTv2.text="$time"//recuperation de données de activity

            saveNotesBibron=view.findViewById(R.id.saveNotesBibron)
            saveNotesBibron.text="$note"

            saveQuantityNameTv=view.findViewById(R.id.saveQuantityNameTv)
            saveQuantityNameTv.text="$quantity "
        }
    }

    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment {onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "time")
    }

    private fun onTimeSelected(time: String){
        etTimeBibron.setText("$time")

    }
}