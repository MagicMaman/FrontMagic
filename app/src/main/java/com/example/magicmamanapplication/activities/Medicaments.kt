package com.example.magicmamanapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.databinding.ActivityMedicamentsBinding
import com.example.magicmamanapplication.databinding.ActivityVaccinBinding
import com.example.magicmamanapplication.fragments.TimePickerFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class Medicaments : AppCompatActivity() {
    private lateinit var binding: ActivityMedicamentsBinding
    lateinit var etTimeMedicaments: EditText
    lateinit var saveTimeTv9: TextView
    lateinit var saveNotesMedicament : TextView
    lateinit var saveNameMedicamentTv9: TextView
    lateinit var saveQuantityMedicamentTv9: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMedicamentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_medicaments)

        etTimeMedicaments = findViewById(R.id.etTimeMedicaments)
        etTimeMedicaments.setOnClickListener { showTimePickerDialog() }

        binding.btnNextMedicament.setOnClickListener {
            val dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
            val offsetFromTop = 200
            (dialog as? BottomSheetDialog)?.behavior?.apply {
                isFitToContents = false
                expandedOffset = offsetFromTop
                state = BottomSheetBehavior.STATE_EXPANDED
            }
            val view = layoutInflater.inflate(R.layout.fragment_btn_sheet_medicament,null)
            val close9 = view.findViewById<ImageView>(R.id.close9)
            val btn_update_medicament = view.findViewById<ImageView>(R.id.btn_update_medicament)

            close9.setOnClickListener{
                dialog.dismiss()
            }

            btn_update_medicament.setOnClickListener {
                dialog.dismiss()
            }

            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()

            val time=binding.etTimeMedicaments.text.toString()
            val note=binding.edtNotesMedicament.text.toString()
            val medicament =binding.etMedicaments.text.toString()
            val quantity=binding.etMedicamentsQuantite.text.toString()

            saveTimeTv9=view.findViewById(R.id.saveTimeTv9)
            saveTimeTv9.text="$time"//recuperation de données de activity

            saveNotesMedicament=view.findViewById(R.id.saveNotesMedicament)
            saveNotesMedicament.text="$note"

            saveNameMedicamentTv9=view.findViewById(R.id.saveNameMedicamentTv9)
            saveNameMedicamentTv9.text="$medicament"

            saveQuantityMedicamentTv9=view.findViewById(R.id.saveQuantityMedicamentTv9)
            saveQuantityMedicamentTv9.text="$quantity"
        }
    }

    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment {onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "time")
    }

    private fun onTimeSelected(time: String){
        etTimeMedicaments.setText("$time")

    }
}