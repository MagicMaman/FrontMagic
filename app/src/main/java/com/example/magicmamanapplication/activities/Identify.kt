package com.example.magicmamanapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.Retrofit.MagicMamanApi
import com.example.magicmamanapplication.Retrofit.Retrofit
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_identify.*
import kotlinx.android.synthetic.main.login_tab_fragment.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Identify : AppCompatActivity() {
    lateinit var btnSuivant: ImageView
    lateinit var radBtnG: RadioButton
    lateinit var radBtnF: RadioButton
    lateinit var gender: String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_identify)
        radBtnG=findViewById(R.id.radBtnG)
        radBtnF=findViewById(R.id.radBtnF)
        btnSuivant=findViewById(R.id.btnSuivant)


        if(radBtnF.isChecked){
            gender  = "fille"
        }
        else {
            gender  = "garcon"
        }
        val spinnerLien : Spinner = findViewById(R.id.spinnerLien)
        btnSuivant.setOnClickListener {

           /*val i= Intent(this,Menu::class.java)
           startActivity(i)*/
            doStore(gender)
        }

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
                    Log.e("Erooooorr",babyname)
                    Toast.makeText(this@Identify, "baby Added Sucessfull!", Toast.LENGTH_SHORT).show()
                    val i= Intent(this@Identify, Menu::class.java)
                    startActivity(i)
                }
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("Error", t.message.toString())
                Toast.makeText(this@Identify, "an error Occured!", Toast.LENGTH_SHORT).show()
            }
        })

    }
}