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
import com.example.magicmamanapplication.databinding.ActivityMedicamentsBinding
import com.example.magicmamanapplication.databinding.ActivityVaccinBinding
import com.example.magicmamanapplication.fragments.TimePickerFragment
import com.example.magicmamanapplication.repository.Repository
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_added_soon.*
import kotlinx.android.synthetic.main.activity_medicaments.*
import kotlinx.android.synthetic.main.activity_repas_solide.*

class Medicaments : AppCompatActivity() {
    private lateinit var binding: ActivityMedicamentsBinding
    lateinit var etTimeMedicaments: EditText
    lateinit var saveTimeTv9: TextView
    lateinit var saveNotesMedicament : TextView
    lateinit var saveNameMedicamentTv9: TextView
    lateinit var saveQuantityMedicamentTv9: TextView

    var a=""
    var b=""
    var c=""
    var d=""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMedicamentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_medicaments)

        etTimeMedicaments = findViewById(R.id.etTimeMedicaments)
        etTimeMedicaments.setOnClickListener { showTimePickerDialog() }

        binding.btnNextMedicament.setOnClickListener {

            if (!etTimeMedicaments.text.isEmpty() && !etMedicaments.text.isEmpty() && !etMedicamentsQuantite.text.isEmpty() && !edt_notes_medicament.text.isEmpty()) {
                val dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
                val offsetFromTop = 200
                (dialog as? BottomSheetDialog)?.behavior?.apply {
                    isFitToContents = false
                    expandedOffset = offsetFromTop
                    state = BottomSheetBehavior.STATE_EXPANDED
                }
                val view = layoutInflater.inflate(R.layout.fragment_btn_sheet_medicament, null)
                val close9 = view.findViewById<ImageView>(R.id.close9)
                val btn_update_medicament = view.findViewById<ImageView>(R.id.btn_update_medicament)
                val btn_submit = view.findViewById<ImageView>(R.id.btn_confirm_medicament)

                val sharedPreferences = getSharedPreferences("sharedPrefs2", Context.MODE_PRIVATE)
                val savedString = sharedPreferences.getString("STRING_KEY", null)


                btn_submit.setOnClickListener {
                    val repository = Repository()
                    val viewModelFactory = MainViewModelFactory(repository)
                    var viewModel =
                        ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
                    // viewModel.getCustomPosts(5,"id", "desc")
                    viewModel.addmedicament(savedString.toString(), a, b, c, d)
                    // Toast.makeText(this,"good",Toast.LENGTH_SHORT).show()
                    //Log.e("jawekbehi",textv2.text.toString())
                    Toast.makeText(this, "check your resume", Toast.LENGTH_SHORT).show()
                    val i= Intent(this, Menu::class.java)
                    startActivity(i)
                }
                close9.setOnClickListener {
                    dialog.dismiss()
                }

                btn_update_medicament.setOnClickListener {
                    dialog.dismiss()
                }

                dialog.setCancelable(false)
                dialog.setContentView(view)
                dialog.show()

                val time = binding.etTimeMedicaments.text.toString()
                val note = binding.edtNotesMedicament.text.toString()
                val medicament = binding.etMedicaments.text.toString()
                val quantity = binding.etMedicamentsQuantite.text.toString()

                saveTimeTv9 = view.findViewById(R.id.saveTimeTv9)
                saveTimeTv9.text = "$time"//recuperation de données de activity
                a = "$time"


                saveNotesMedicament = view.findViewById(R.id.saveNotesMedicament)
                saveNotesMedicament.text = "$note"
                d = "$note "

                saveNameMedicamentTv9 = view.findViewById(R.id.saveNameMedicamentTv9)
                saveNameMedicamentTv9.text = "$medicament"
                b = "$medicament"

                saveQuantityMedicamentTv9 = view.findViewById(R.id.saveQuantityMedicamentTv9)
                saveQuantityMedicamentTv9.text = "$quantity"
                c = "$quantity"
            }
            else
            {

                //Toast.makeText(applicationContext,"Notes is Empty", Toast.LENGTH_SHORT).show()

                val layout1 : View = layoutInflater.inflate(R.layout.medicaments_toast, ll_wrapper)
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
        etTimeMedicaments.setText("$time")

    }
}