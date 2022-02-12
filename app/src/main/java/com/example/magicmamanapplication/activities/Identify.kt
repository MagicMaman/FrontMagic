package com.example.magicmamanapplication.activities

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.Retrofit.MagicMamanApi
import com.example.magicmamanapplication.Retrofit.Retrofit
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_identify.*
import kotlinx.android.synthetic.main.custom_toast.*
import kotlinx.android.synthetic.main.login_tab_fragment.*
import kotlinx.android.synthetic.main.photo_layout.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener

import android.widget.DatePicker

import android.widget.EditText
import java.text.SimpleDateFormat


class Identify : AppCompatActivity() {

    lateinit var btnSuivant: ImageView
    lateinit var radBtnG: RadioButton
    lateinit var radBtnF: RadioButton
    lateinit var gender: String
    var pref=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_identify)

        radBtnG=findViewById(R.id.radBtnG)
        radBtnF=findViewById(R.id.radBtnF)
        btnSuivant=findViewById(R.id.btnSuivant)

        loadData()
        btnSuivant.setOnClickListener {
            clickNext()
           /*val i= Intent(this,Menu::class.java)
            startActivity(i)*/
        }


        if(radBtnF.isChecked){
            gender  = "fille"
        }
        else {
            gender  = "garcon"
        }
        val spinnerLien : Spinner = findViewById(R.id.spinnerLien)
        val lienNames = arrayOf("Mère","Père","Partenaire","Grand-parent","Oncle ou Tante","Ami(e)")
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, lienNames )
        // attached arrayadapter to spinner
        spinnerLien.adapter = arrayAdapter
        spinnerLien.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }

        }

        imgHead.setOnClickListener {
            //check runtime permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE ) ==
                    PackageManager.PERMISSION_DENIED
                ) {
                    //permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                    //show popup to request runtime permission
                    // requestPermissions(permissions, FavoriteFragment.PERMISSION_CODE);
                } else {
                    //permission already granted
                    pickImageFromGallery2();
                }
            } else {
                //system OS is < Marshmallow
                pickImageFromGallery2();
            }
        }


        val myCalendar = Calendar.getInstance()

        val edittext = findViewById<View>(R.id.edtTxtAnniv) as EditText
        val date =
            OnDateSetListener { view, year, monthOfYear, dayOfMonth -> // TODO Auto-generated method stub
                myCalendar[Calendar.YEAR] = year
                myCalendar[Calendar.MONTH] = monthOfYear
                myCalendar[Calendar.DAY_OF_MONTH] = dayOfMonth
                updateLabel()
            }

        edittext.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                // TODO Auto-generated method stub
                DatePickerDialog(this@Identify, date, myCalendar[Calendar.YEAR], myCalendar[Calendar.MONTH],
                    myCalendar[Calendar.DAY_OF_MONTH]
                ).show()
            }
        })
    }

    private fun updateLabel() {
        val myCalendar = Calendar.getInstance()


        val myFormat = "MM/dd/yy" //In which you need put here
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        edtTxtAnniv.setText(sdf.format(myCalendar.getTime()))
    }

    private fun clickNext() {
        if (validate()) {
            saveData()
            doStore(gender)

        }
    }

    private fun validate(): Boolean {
        val layout :View = layoutInflater.inflate(R.layout.custom_toast, ll_wrapper)
        val layout1 :View = layoutInflater.inflate(R.layout.anniv_toast, ll_wrapper)
        val toast: Toast = Toast(applicationContext)
        val toast1: Toast = Toast(applicationContext)

        if (edtTxtPrenom?.text!!.isEmpty()) {
            (toast.apply {
                duration = Toast.LENGTH_SHORT
                //setGravity(Gravity.BOTTOM,0,0)
                view = layout
                show()
            })
            return false
        }

        if (edtTxtAnniv?.text!!.isEmpty()) {
            (toast1.apply {
                duration = Toast.LENGTH_SHORT
                //setGravity(Gravity.BOTTOM,0,0)
                view = layout1
                show()
            })
            return false
        }

       /* if(setBirthdayEditText())
        {
            Toast.makeText(this, "incorrect date format!", Toast.LENGTH_SHORT).show()
            return false
        }*/

        return true

    }
   /*private fun setBirthdayEditText(): Boolean {

        edtTxtAnniv.addTextChangedListener(object : TextWatcher {

            private var current = ""
            private val ddmmyyyy = "DDMMYYYY"
            private val cal = Calendar.getInstance()

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString() != current) {
                    var clean = p0.toString().replace("[^\\d.]|\\.".toRegex(), "")
                    val cleanC = current.replace("[^\\d.]|\\.", "")

                    val cl = clean.length
                    var sel = cl
                    var i = 2
                    while (i <= cl && i < 6) {
                        sel++
                        i += 2
                    }
                    //Fix for pressing delete next to a forward slash
                    if (clean == cleanC) sel--

                    if (clean.length < 8) {
                        clean = clean + ddmmyyyy.substring(clean.length)
                    } else {
                        //This part makes sure that when we finish entering numbers
                        //the date is correct, fixing it otherwise
                        var day = Integer.parseInt(clean.substring(0, 2))
                        var mon = Integer.parseInt(clean.substring(2, 4))
                        var year = Integer.parseInt(clean.substring(4, 8))

                        mon = if (mon < 1) 1 else if (mon > 12) 12 else mon
                        cal.set(Calendar.MONTH, mon - 1)
                        year = if (year < 1900) 1900 else if (year > 2100) 2100 else year
                        cal.set(Calendar.YEAR, year)
                        // ^ first set year for the line below to work correctly
                        //with leap years - otherwise, date e.g. 29/02/2012
                        //would be automatically corrected to 28/02/2012

                        day = if (day > cal.getActualMaximum(Calendar.DATE)) cal.getActualMaximum(Calendar.DATE) else day
                        clean = String.format("%02d%02d%02d", day, mon, year)
                    }

                    clean = String.format("%s/%s/%s", clean.substring(0, 2),
                        clean.substring(2, 4),
                        clean.substring(4, 8))

                    sel = if (sel < 0) 0 else sel
                    current = clean
                    edtTxtAnniv.setText(current)
                    edtTxtAnniv.setSelection(if (sel < current.count()) sel else current.count())
                }
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun afterTextChanged(p0: Editable) {
            }
        })
        return true
    }*/
    private fun saveData(){
        val insertedText = edtTxtPrenom.text.toString()

        val sharedPreferences = getSharedPreferences("sharedPrefs2",Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putString("STRING_KEY", insertedText)
            //putBoolean("BOOLEAN_KEY", sw_switch.isChecked)
        }.apply()
        if (!insertedText.isEmpty()){
            //Toast.makeText(this@Identify, "baby Added Sucessfull!", Toast.LENGTH_SHORT).show()
            val i= Intent(this@Identify, Menu::class.java)
            startActivity(i)
        }

        // txtPrenomBebe.text = insertedText
        Log.d("houniiiiiiii",insertedText)
        Log.d("houniiiiiiii",insertedText)

        Toast.makeText(this,"Data Saved",Toast.LENGTH_SHORT).show()
    }
    private fun loadData(){

        val sharedPreferences = getSharedPreferences("sharedPrefs2",Context.MODE_PRIVATE)
        val savedString : String? = sharedPreferences.getString("STRING_KEY", null)
        val savedBoolean : Boolean = sharedPreferences.getBoolean("BOOLEAN_KEY", false)

        //txtPrenomBebe.text = savedString
        if (savedString != null) {
            if (!savedString.isEmpty()){
                Toast.makeText(this@Identify, "baby Added Sucessfull!", Toast.LENGTH_SHORT).show()
                val i= Intent(this@Identify, Menu::class.java)
                startActivity(i)
            }
        }
        // sw_switch.isChecked = savedBoolean
    }

    private fun pickImageFromGallery2() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object {
        //image pick code
        private val IMAGE_PICK_CODE = 1000;

        //Permission code
        private val PERMISSION_CODE = 1001;
    }

    //handle requested permission result
    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED
                ) {
                    //permission from popup granted
                    pickImageFromGallery2()
                } else {
                    //permission from popup denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
    //handle result of picked image
    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            imgHead.setImageURI(data?.data)
        }
    }

    private fun doStore(gender: String) {
        val paramObject1 = JSONObject()
        //paramObject1.put("email", edtTxtEmail.text.toString().trim())//1)eli 3andi fl user2)part rapport eli 3andi fl txt fl application
        paramObject1.put("name", edtTxtPrenom.text.toString().trim())
        paramObject1.put("birthday", edtTxtAnniv.text.toString().trim())
        paramObject1.put("gender",gender)
        val jsonParser = JsonParser()
        var gsonObject1 = jsonParser.parse(paramObject1.toString()) as JsonObject
        val retro = Retrofit().getRetroClinetInstance().create(MagicMamanApi::class.java)
        retro.store(gsonObject1).enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                if(response.code()==200) {
                    val baby = response.body()?.get("name").toString()
                    val babyname=baby.substring(1,baby.length-1)
                    Log.d("Erooooorr",babyname)
                    saveData()
                    /*  Toast.makeText(this@Identify, "baby Added Sucessfull!", Toast.LENGTH_SHORT).show()
                      val i= Intent(this@Identify, Menu::class.java)
                      startActivity(i)*/
                }
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.d("Error", t.message.toString())
                Toast.makeText(this@Identify, "an error Occured!", Toast.LENGTH_SHORT).show()
            }
        })

    }
}