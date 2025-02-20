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
import com.example.magicmamanapplication.databinding.ActivityPoidsBinding
import com.example.magicmamanapplication.databinding.ActivityTailleBinding
import com.example.magicmamanapplication.fragments.TimePickerFragment
import com.example.magicmamanapplication.repository.Repository
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_added_soon.*
import kotlinx.android.synthetic.main.activity_poids.*
import kotlinx.android.synthetic.main.activity_repas_solide.*
import kotlinx.android.synthetic.main.activity_repas_solide.edt_solid

class Poids : AppCompatActivity() {

    private lateinit var binding: ActivityPoidsBinding
    lateinit var etTimePoids: EditText
    lateinit var saveTimeTv6: TextView
    lateinit var saveNotesPoids : TextView
    lateinit var savePoidsNameTv: TextView

    var a=""
    var b=""
    var c=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityPoidsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_poids)
        etTimePoids=findViewById(R.id.etTimePoids)
        etTimePoids.setOnClickListener{ showTimePickerDialog()}

        binding.btnNextPoids.setOnClickListener {

            if (!etTimePoids.text.isEmpty() && !edt_poids.text.isEmpty() && !edt_notes_poids.text.isEmpty()) {
                val dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
                val offsetFromTop = 200
                (dialog as? BottomSheetDialog)?.behavior?.apply {
                    isFitToContents = false
                    expandedOffset = offsetFromTop
                    state = BottomSheetBehavior.STATE_EXPANDED
                }
                val view = layoutInflater.inflate(R.layout.fragment_btn_sheet_poids, null)
                val close6 = view.findViewById<ImageView>(R.id.close6)
                val btn_update_poids = view.findViewById<ImageView>(R.id.btn_update_poids)
                val btn_submit = view.findViewById<ImageView>(R.id.btn_confirm_poids)

                val sharedPreferences = getSharedPreferences("sharedPrefs2", Context.MODE_PRIVATE)
                val savedString = sharedPreferences.getString("STRING_KEY", null)


                btn_submit.setOnClickListener {
                    val repository = Repository()
                    val viewModelFactory = MainViewModelFactory(repository)
                    var viewModel =
                        ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
                    // viewModel.getCustomPosts(5,"id", "desc")
                    viewModel.addpoids(savedString.toString(), a, b, c)
                    // Toast.makeText(this,"good",Toast.LENGTH_SHORT).show()
                    //Log.d("jawekbehi",textv2.text.toString())
                    Toast.makeText(this, "check your resume", Toast.LENGTH_SHORT).show()
                    val i= Intent(this, Menu::class.java)
                    startActivity(i)
                }

                btn_update_poids.setOnClickListener {
                    dialog.dismiss()
                }

                close6.setOnClickListener {
                    dialog.dismiss()
                }
                dialog.setCancelable(false)
                dialog.setContentView(view)
                dialog.show()

                val time = binding.etTimePoids.text.toString()
                val note = binding.edtNotesPoids.text.toString()
                val poids = binding.edtPoids.text.toString()

                saveTimeTv6 = view.findViewById(R.id.saveTimeTv6)
                saveTimeTv6.text = "$time"//recuperation de données de activity
                a = "$time"

                saveNotesPoids = view.findViewById(R.id.saveNotesPoids)
                saveNotesPoids.text = "$note"
                c = "$note"

                savePoidsNameTv = view.findViewById(R.id.savePoidsNameTv)
                savePoidsNameTv.text = "$poids "
                b = "$poids"
            }
            else
            {

                //Toast.makeText(applicationContext,"Notes is Empty", Toast.LENGTH_SHORT).show()

                val layout1 : View = layoutInflater.inflate(R.layout.poids_toast, ll_wrapper)
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
        etTimePoids.setText("$time")

    }
}