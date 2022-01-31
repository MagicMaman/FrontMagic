package com.example.magicmamanapplication.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import com.example.magicmamanapplication.MainViewModel
import com.example.magicmamanapplication.MainViewModelFactory
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.databinding.ActivityRepasSolideBinding
import com.example.magicmamanapplication.fragments.TimePickerFragment
import com.example.magicmamanapplication.repository.Repository
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_added_soon.*
import kotlinx.android.synthetic.main.activity_repas_solide.*
import kotlinx.android.synthetic.main.activity_tete.*
import kotlinx.android.synthetic.main.fragment_btn_sheet_repas_solide.*

class RepasSolide : AppCompatActivity() {
    private lateinit var binding: ActivityRepasSolideBinding//walid
    lateinit var etTimeSolid: EditText
    lateinit var saveTimeTv1 : TextView//walid
    lateinit var saveNotesRepas : TextView//walid
    lateinit var saveDishNameTv: TextView
   // lateinit var confirmBtn:ImageView


    var a=""
    var b=""
    var c=""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRepasSolideBinding.inflate(layoutInflater)//walid
        setContentView(binding.root)//walid

        //setContentView(R.layout.activity_repas_solide) // a eliminer la cause de ne pas travailler de 13h a 15.30h
        etTimeSolid=findViewById(R.id.etTimeSolid)
        etTimeSolid.setOnClickListener{ showTimePickerDialog()}

        //timeadd=findViewById(R.id.saveTimeTv1)
        //nameadd=findViewById(R.id.saveDishNameTv)
        //notesadd=findViewById(R.id.saveNotesRepas)
        //RECUPERE NOM BEBE AVEC SHAREDPREFS2

        binding.btnNextSolid.setOnClickListener {

            if (!etTimeSolid.text.isEmpty()&&!edt_solid.text.isEmpty()&&!edt_notes_solid.text.isEmpty()) {
                val dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
                val offsetFromTop = 200
                (dialog as? BottomSheetDialog)?.behavior?.apply {
                    isFitToContents = false
                    expandedOffset = offsetFromTop
                    state = BottomSheetBehavior.STATE_EXPANDED
                }

                val view = layoutInflater.inflate(R.layout.fragment_btn_sheet_repas_solide, null)
                val close1 = view.findViewById<ImageView>(R.id.close1)
                val btn_update_repas = view.findViewById<ImageView>(R.id.btn_update_repas)
                val btn_submit = view.findViewById<ImageView>(R.id.btn_confirm_repas)

                val sharedPreferences = getSharedPreferences("sharedPrefs2", Context.MODE_PRIVATE)
                val savedString = sharedPreferences.getString("STRING_KEY", null)

                //BtnConfirm+Add tete
                btn_submit.setOnClickListener {
                    val repository = Repository()
                    val viewModelFactory = MainViewModelFactory(repository)
                    var viewModel =
                        ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
                    // viewModel.getCustomPosts(5,"id", "desc")
                    viewModel.addsolide(savedString.toString(), a, b, c)
                    // Toast.makeText(this,"good",Toast.LENGTH_SHORT).show()
                    //Log.e("jawekbehi",textv2.text.toString())
                    Toast.makeText(this, "goood", Toast.LENGTH_SHORT).show()
                    val i= Intent(this, Menu::class.java)
                    startActivity(i)
                }
                btn_update_repas.setOnClickListener {
                    dialog.dismiss()
                }

                close1.setOnClickListener {
                    dialog.dismiss()
                }
                dialog.setCancelable(false)
                dialog.setContentView(view)
                dialog.show()

                val time = binding.etTimeSolid.text.toString()
                val note = binding.edtNotesSolid.text.toString()
                val namedish = binding.edtSolid.text.toString()

                saveTimeTv1 = view.findViewById(R.id.saveTimeTv1)
                saveTimeTv1.text = "$time"//recuperation de données de activity
                a = "$time"

                saveNotesRepas = view.findViewById(R.id.saveNotesRepas)
                saveNotesRepas.text = "$note"
                c = "$note"

                saveDishNameTv = view.findViewById(R.id.saveDishNameTv)
                saveDishNameTv.text = "$namedish "
                b = "$namedish "


            }
            else
            {

                //Toast.makeText(applicationContext,"Notes is Empty", Toast.LENGTH_SHORT).show()

                val layout1 : View = layoutInflater.inflate(R.layout.repassolide_toast, ll_wrapper)
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
        etTimeSolid.setText("$time")//chaima

    }
}