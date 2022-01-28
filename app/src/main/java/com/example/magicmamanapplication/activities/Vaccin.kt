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
import com.example.magicmamanapplication.databinding.ActivityVaccinBinding
import com.example.magicmamanapplication.fragments.TimePickerFragment
import com.example.magicmamanapplication.repository.Repository
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class Vaccin : AppCompatActivity() {
    private lateinit var binding: ActivityVaccinBinding
    lateinit var etTimeVaccin: EditText
    lateinit var saveTimeTv7: TextView
    lateinit var saveNotesVaccin : TextView
    lateinit var saveVaccinNameTv: TextView

    var a=""
    var b=""
    var c=""

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
            val btn_submit= view.findViewById<ImageView>(R.id.btn_confirm_vaccin)

            val sharedPreferences = getSharedPreferences("sharedPrefs2", Context.MODE_PRIVATE)
            val savedString=sharedPreferences.getString("STRING_KEY", null)


            btn_submit.setOnClickListener{
                val repository = Repository()
                val viewModelFactory = MainViewModelFactory(repository)
                var viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
                // viewModel.getCustomPosts(5,"id", "desc")
                viewModel.addvaccin(savedString.toString(),a,b,c)
                // Toast.makeText(this,"good",Toast.LENGTH_SHORT).show()
                //Log.e("jawekbehi",textv2.text.toString())
                Toast.makeText(this,"check your resume", Toast.LENGTH_SHORT).show()
            }
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
            a="$time"

            saveNotesVaccin=view.findViewById(R.id.saveNotesVaccin)
            saveNotesVaccin.text="$note"
            c="$note"

            saveVaccinNameTv=view.findViewById(R.id.saveVaccinNameTv)
            saveVaccinNameTv.text="$vaccin"
            b="$vaccin "
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