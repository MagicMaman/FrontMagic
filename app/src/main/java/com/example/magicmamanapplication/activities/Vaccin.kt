package com.example.magicmamanapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.databinding.ActivityVaccinBinding
import com.example.magicmamanapplication.fragments.TimePickerFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class Vaccin : AppCompatActivity() {
    private lateinit var binding: ActivityVaccinBinding
    lateinit var etTimeVaccin: EditText
    lateinit var saveTimeTv7: TextView
    lateinit var saveNotesVaccin : TextView
    lateinit var saveVaccinNameTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityVaccinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_vaccin)

        etTimeVaccin=findViewById(R.id.etTimeVaccin)
        etTimeVaccin.setOnClickListener{ showTimePickerDialog()}

        binding.btnNextVaccin.setOnClickListener {
            val dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
            val offsetFromTop = 200
            (dialog as? BottomSheetDialog)?.behavior?.apply {
                isFitToContents = false
                expandedOffset = offsetFromTop
                state = BottomSheetBehavior.STATE_EXPANDED
            }
            val view = layoutInflater.inflate(R.layout.fragment_btn_sheet_vaccin,null)
            val close7 = view.findViewById<ImageView>(R.id.close7)
            val btn_update_vaccin = view.findViewById<ImageView>(R.id.btn_update_vaccin)

            btn_update_vaccin.setOnClickListener {
                dialog.dismiss()
            }


            close7.setOnClickListener{
                dialog.dismiss()
            }

            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()

            val time=binding.etTimeVaccin.text.toString()
            val note=binding.edtNotesVaccin.text.toString()
            val vaccin =binding.etVaccin.text.toString()

            saveTimeTv7=view.findViewById(R.id.saveTimeTv7)
            saveTimeTv7.text="$time"//recuperation de données de activity

            saveNotesVaccin=view.findViewById(R.id.saveNotesVaccin)
            saveNotesVaccin.text="$note"

            saveVaccinNameTv=view.findViewById(R.id.saveVaccinNameTv)
            saveVaccinNameTv.text="$vaccin"
        }

    }

    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment {onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "time")
    }

    private fun onTimeSelected(time: String){
        etTimeVaccin.setText("$time")

    }
}