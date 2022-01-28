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
import com.example.magicmamanapplication.databinding.ActivityBibronsBinding
import com.example.magicmamanapplication.fragments.TimePickerFragment
import com.example.magicmamanapplication.repository.Repository
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class Bibrons : AppCompatActivity() {
    private lateinit var binding: ActivityBibronsBinding
    lateinit var etTimeBibron: EditText
    lateinit var saveTimeTv2 : TextView
    lateinit var saveNotesBibron : TextView
    lateinit var saveQuantityNameTv: TextView

    var a=""
    var b=""
    var c=""



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
            val btn_submit= view.findViewById<ImageView>(R.id.btn_confirm_bibron)

            val sharedPreferences = getSharedPreferences("sharedPrefs2", Context.MODE_PRIVATE)
            val savedString=sharedPreferences.getString("STRING_KEY", null)


            btn_submit.setOnClickListener{
                val repository = Repository()
                val viewModelFactory = MainViewModelFactory(repository)
                var viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
                // viewModel.getCustomPosts(5,"id", "desc")
                viewModel.addbibron(savedString.toString(),a,b,c)
                // Toast.makeText(this,"good",Toast.LENGTH_SHORT).show()
                //Log.e("jawekbehi",textv2.text.toString())
                Toast.makeText(this,"goood", Toast.LENGTH_SHORT).show()
            }

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
            a="$time"

            saveNotesBibron=view.findViewById(R.id.saveNotesBibron)
            saveNotesBibron.text="$note"
            c="$note"

            saveQuantityNameTv=view.findViewById(R.id.saveQuantityNameTv)
            saveQuantityNameTv.text="$quantity "
            b="$quantity "
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