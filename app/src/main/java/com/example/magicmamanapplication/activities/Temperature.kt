package com.example.magicmamanapplication.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.magicmamanapplication.MainViewModel
import com.example.magicmamanapplication.MainViewModelFactory
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.databinding.ActivityTemperatureBinding
import com.example.magicmamanapplication.databinding.ActivityVaccinBinding
import com.example.magicmamanapplication.fragments.TimePickerFragment
import com.example.magicmamanapplication.repository.Repository
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_added_soon.*
import kotlinx.android.synthetic.main.activity_repas_solide.*
import kotlinx.android.synthetic.main.activity_repas_solide.edt_solid
import kotlinx.android.synthetic.main.activity_temperature.*

class Temperature : AppCompatActivity() {
    private lateinit var binding: ActivityTemperatureBinding
    lateinit var etTimeTemperature: EditText
    lateinit var saveTimeTv8: TextView
    lateinit var saveNotesTemperature : TextView
    lateinit var saveFeverNameTv: TextView

    var a=""
    var b=""
    var c=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemperatureBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_temperature)

        etTimeTemperature = findViewById(R.id.etTimeTemperature)
        etTimeTemperature.setOnClickListener { showTimePickerDialog() }
        binding.btnNextTemperature.setOnClickListener {

            if (!etTimeTemperature.text.isEmpty() && !etTemperature.text.isEmpty() && !edt_notes_temperature.text.isEmpty()) {
                val dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
                val offsetFromTop = 200
                (dialog as? BottomSheetDialog)?.behavior?.apply {
                    isFitToContents = false
                    expandedOffset = offsetFromTop
                    state = BottomSheetBehavior.STATE_EXPANDED
                }
                val view = layoutInflater.inflate(R.layout.fragment_btn_sheet_temperature, null)
                val close8 = view.findViewById<ImageView>(R.id.close8)
                val btn_update_temperature =
                    view.findViewById<ImageView>(R.id.btn_update_temperature)
                val btn_submit = view.findViewById<ImageView>(R.id.btn_confirm_temperature)

                val sharedPreferences = getSharedPreferences("sharedPrefs2", Context.MODE_PRIVATE)
                val savedString = sharedPreferences.getString("STRING_KEY", null)


                btn_submit.setOnClickListener {
                    val repository = Repository()
                    val viewModelFactory = MainViewModelFactory(repository)
                    var viewModel =
                        ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
                    // viewModel.getCustomPosts(5,"id", "desc")
                    viewModel.addtemperature(savedString.toString(), a, b, c)
                    // Toast.makeText(this,"good",Toast.LENGTH_SHORT).show()
                    //Log.e("jawekbehi",textv2.text.toString())
                    Toast.makeText(this, "check your resume", Toast.LENGTH_SHORT).show()
                    val i= Intent(this, Menu::class.java)
                    startActivity(i)
                }
                btn_update_temperature.setOnClickListener {
                    dialog.dismiss()
                }


                close8.setOnClickListener {
                    dialog.dismiss()
                }

                dialog.setCancelable(false)
                dialog.setContentView(view)
                dialog.show()

                val time = binding.etTimeTemperature.text.toString()
                val note = binding.edtNotesTemperature.text.toString()
                val temperature = binding.etTemperature.text.toString()

                saveTimeTv8 = view.findViewById(R.id.saveTimeTv8)
                saveTimeTv8.text = "$time"//recuperation de données de activity
                a = "$time"

                saveNotesTemperature = view.findViewById(R.id.saveNotesTemperature)
                saveNotesTemperature.text = "$note"
                c = "$note "

                saveFeverNameTv = view.findViewById(R.id.saveFeverNameTv)
                saveFeverNameTv.text = "$temperature"
                b = "$temperature"

            }
            else
            {

                //Toast.makeText(applicationContext,"Notes is Empty", Toast.LENGTH_SHORT).show()

                val layout1 : View = layoutInflater.inflate(R.layout.temperature_toast, ll_wrapper)
                val toast: Toast = Toast(applicationContext)

                (toast.apply {
                    duration = Toast.LENGTH_SHORT
                    //setGravity(Gravity.BOTTOM,0,0)
                    view = layout1
                    show()
                })
            }


        }
    }
    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment {onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "time")
    }

    private fun onTimeSelected(time: String){
        etTimeTemperature.setText("$time")

    }
}