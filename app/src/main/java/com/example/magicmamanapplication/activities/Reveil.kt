package com.example.magicmamanapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.databinding.ActivityReveilBinding
import com.example.magicmamanapplication.databinding.ActivitySommeillBinding
import com.example.magicmamanapplication.fragments.TimePickerFragment
import com.google.android.material.bottomsheet.BottomSheetDialog

class Reveil : AppCompatActivity() {
    private lateinit var binding: ActivityReveilBinding
    lateinit var etTimeReveil: EditText
    lateinit var saveTimeTv4: TextView
    lateinit var saveNotesReveil : TextView





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReveilBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // setContentView(R.layout.activity_reveil)
        etTimeReveil=findViewById(R.id.etTimeReveil)
        etTimeReveil.setOnClickListener{ showTimePickerDialog()}

        binding.btnNextReveil.setOnClickListener {
            val dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
            val view = layoutInflater.inflate(R.layout.fragment_btn_sheet_reveil,null)
            val close4 = view.findViewById<ImageView>(R.id.close4)

            close4.setOnClickListener{
                dialog.dismiss()
            }
            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()

            val time=binding.etTimeReveil.text.toString()
            val note=binding.edtNotesReveil.text.toString()

            saveTimeTv4=view.findViewById(R.id.saveTimeTv4)
            saveTimeTv4.text="$time"//recuperation de données de activity

            saveNotesReveil=view.findViewById(R.id.saveNotesReveil)
            saveNotesReveil.text="$note"
        }
    }
    
    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment {onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "time")
    }

    private fun onTimeSelected(time: String){
        etTimeReveil.setText("$time")

    }
}