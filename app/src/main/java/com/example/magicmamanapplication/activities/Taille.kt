package com.example.magicmamanapplication.activities

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.databinding.ActivitySommeillBinding
import com.example.magicmamanapplication.databinding.ActivityTailleBinding
import com.example.magicmamanapplication.fragments.TimePickerFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.text.SimpleDateFormat
import java.util.*

class Taille : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private lateinit var binding: ActivityTailleBinding
    lateinit var etTimeTaille: TextView
    lateinit var saveTimeTv5: TextView
    lateinit var saveNotesTaille : TextView
    lateinit var saveHeightNameTv: TextView

    var day = 0
    var month = 0
    var year = 0
    var hour = 0
    var minute = 0

    var savedDay = 0
    var savedMonth = 0
    var savedYear = 0
    var savedHour = 0
    var savedMinute = 0



    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityTailleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_taille)


        etTimeTaille=findViewById(R.id.etTimeTaille)
       // etTimeTaille.setOnClickListener{ showTimePickerDialog()}

        binding.btnNextTaille.setOnClickListener {
            val dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
            val offsetFromTop = 200
            (dialog as? BottomSheetDialog)?.behavior?.apply {
                isFitToContents = false
                expandedOffset = offsetFromTop
                state = BottomSheetBehavior.STATE_EXPANDED
            }
            val view = layoutInflater.inflate(R.layout.fragment_btn_sheet_taille,null)
            val close5 = view.findViewById<ImageView>(R.id.close5)
            val btn_update_taille = view.findViewById<ImageView>(R.id.btn_update_taille)

            btn_update_taille.setOnClickListener {
                dialog.dismiss()
            }

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
            saveNotesTaille.text="$note"

            saveHeightNameTv=view.findViewById(R.id.saveHeightNameTv)
            saveHeightNameTv.text="$height "
        }
        pickDate()
    }
    private fun getDateTimeCalendar(){

        val cal = java.util.Calendar.getInstance()
        day = cal.get(java.util.Calendar.DAY_OF_MONTH)
        month = cal.get(java.util.Calendar.MONTH)
        year = cal.get(java.util.Calendar.YEAR)
        hour = cal.get(java.util.Calendar.HOUR)
        minute = cal.get(java.util.Calendar.MINUTE)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun pickDate(){
        etTimeTaille.setOnClickListener{
            getDateTimeCalendar()

            DatePickerDialog(this,this,year,month,day).show()
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedDay = dayOfMonth
        savedMonth = month
        savedYear = year

        getDateTimeCalendar()
        TimePickerDialog(this, this, hour,minute,true).show()
    }

    @SuppressLint("SetTextI18n")
    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        savedHour = hour
        savedMinute = minute

        etTimeTaille.text = "$savedDay-$savedMonth-$savedYear\n Hour: $savedHour Minute: $savedMinute"
    }

    /*private fun showTimePickerDialog() {
       val now = Calendar.getInstance()
        val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->  },

            now.get(Calendar.YEAR),
            now.get(Calendar.MONTH),
            now.get(Calendar.DAY_OF_MONTH))
        //datePicker.show()
        datePicker.show()
       // datePicker.show(getSupportFragmentManager(), "datePicker")
    }

    private fun onTimeSelected(time: String){
        etTimeTaille.setText("$time")

    }*/


}