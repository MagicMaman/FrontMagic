package com.example.magicmamanapplication.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.magicmamanapplication.MainViewModel
import com.example.magicmamanapplication.MainViewModelFactory
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.databinding.ActivitySommeillBinding
import com.example.magicmamanapplication.fragments.TimePickerFragment
import com.example.magicmamanapplication.repository.Repository
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class Sommeill : AppCompatActivity() {
    private lateinit var binding: ActivitySommeillBinding
    lateinit var etTimeSommeill: EditText
    lateinit var etTimeReveil: EditText
    lateinit var saveTimeTv3: TextView
    lateinit var saveTimeAwakeTv3: TextView
    lateinit var saveNotesSommeil : TextView

    var a=""
    var b=""
    var c=""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySommeillBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setContentView(R.layout.activity_sommeill)
        etTimeSommeill=findViewById(R.id.etTimeSommeill)
        etTimeSommeill.setOnClickListener{ showTimePickerDialog1()}
        etTimeReveil=findViewById(R.id.etTimeReveil)
        etTimeReveil.setOnClickListener{ showTimePickerDialog2()}

        binding.btnNextSommeill.setOnClickListener {
            val dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
            val offsetFromTop = 200
            (dialog as? BottomSheetDialog)?.behavior?.apply {
                isFitToContents = false
                expandedOffset = offsetFromTop
                state = BottomSheetBehavior.STATE_EXPANDED
            }
            val view = layoutInflater.inflate(R.layout.fragment_btn_sheet_sommeil,null)
            val close3 = view.findViewById<ImageView>(R.id.close3)
            val btn_update_sommeil = view.findViewById<ImageView>(R.id.btn_update_sommeil)
            val btn_submit= view.findViewById<ImageView>(R.id.btn_confirm_sommeil)

            val sharedPreferences = getSharedPreferences("sharedPrefs2", Context.MODE_PRIVATE)
            val savedString=sharedPreferences.getString("STRING_KEY", null)


            btn_submit.setOnClickListener{
                val repository = Repository()
                val viewModelFactory = MainViewModelFactory(repository)
                var viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
                // viewModel.getCustomPosts(5,"id", "desc")
                viewModel.addsommeil(savedString.toString(),a,b,c)
                // Toast.makeText(this,"good",Toast.LENGTH_SHORT).show()
                //Log.e("jawekbehi",textv2.text.toString())
                Toast.makeText(this,"check your resume", Toast.LENGTH_SHORT).show()
            }

            btn_update_sommeil.setOnClickListener {
                dialog.dismiss()
            }

            close3.setOnClickListener{
                dialog.dismiss()
            }
            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()

            val timesleep=binding.etTimeSommeill.text.toString()
            val timeawake=binding.etTimeReveil.text.toString()
            val note=binding.edtNotesSommeill.text.toString()

            saveTimeTv3=view.findViewById(R.id.saveTimeTv3)
            saveTimeTv3.text="$timesleep"//recuperation de données de activity
            a="$timesleep"

           saveTimeAwakeTv3=view.findViewById(R.id.saveTimeAwakeTv3)
            saveTimeAwakeTv3.text="$timeawake"//recuperation de données de activity
            b="$timeawake "

            saveNotesSommeil=view.findViewById(R.id.saveNotesSommeil)
            saveNotesSommeil.text="$note"
            c="$note"
        }
    }
    private fun showTimePickerDialog1() {
        val timePicker = TimePickerFragment {onTimeSelected1(it)}
        timePicker.show(supportFragmentManager, "time")
    }
    private fun showTimePickerDialog2() {
        val timePicker2 = TimePickerFragment {onTimeSelected2(it)}
        timePicker2.show(supportFragmentManager, "time")
    }

    private fun onTimeSelected1(time: String){
        etTimeSommeill.setText("$time")


    }
    private fun onTimeSelected2(time: String){

        etTimeReveil.setText("$time")

    }
}