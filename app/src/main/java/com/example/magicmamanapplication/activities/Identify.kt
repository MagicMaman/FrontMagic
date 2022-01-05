package com.example.magicmamanapplication.activities

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.magicmamanapplication.MainViewModel
import com.example.magicmamanapplication.MainViewModelFactory
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.Retrofit.MagicMamanApi
import com.example.magicmamanapplication.Retrofit.Retrofit
import com.example.magicmamanapplication.fragments.FavoriteFragment
import com.example.magicmamanapplication.repository.Repository
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_identify.*
import kotlinx.android.synthetic.main.login_tab_fragment.*
import kotlinx.android.synthetic.main.photo_layout.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Identify : AppCompatActivity() {
    lateinit var spin:Spinner
    lateinit var prenom:EditText
    lateinit var annif:EditText
   // lateinit var garconGender:RadioButton
    //lateinit var filleGender:RadioButton
    lateinit var btnSuivant: ImageView


    lateinit var radgarcon: RadioButton
    lateinit var radfille: RadioButton
   var gender=""
    var text=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_identify)
       spin=findViewById(R.id.spinnerLien)
        prenom=findViewById(R.id.edtTxtPrenom)
        annif=findViewById(R.id.edtTxtAnniv)
        radgarcon=findViewById(R.id.radBtnG)
        radfille=findViewById(R.id.radBtnF)
        btnSuivant=findViewById(R.id.btnSuivant)




        if(radBtnF.isChecked){
            gender  += "fille"
        }else{
            gender += "garcon"
        }

        //val spinnerLien : Spinner = findViewById(R.id.spinnerLien)
        btnSuivant.setOnClickListener {

//val emaiil=intent.getStringExtra("email")
            //Log.e("emailrec",emaiil.toString())
            val repository = Repository()
            val viewModelFactory = MainViewModelFactory(repository)
            var viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
            // viewModel.getCustomPosts(5,"id", "desc")
            viewModel.addbaby("rayen@esprit.tn",text,prenom.text.toString(),annif.text.toString(),gender)


           val i= Intent(this,Menu::class.java)
           startActivity(i)
            //doStore(gender)
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

         text = spinnerLien.getSelectedItem().toString()
        Log.d("spinner",text)

        imgHead.setOnClickListener {
            //check runtime permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE ) ==
                    PackageManager.PERMISSION_DENIED
                ) {
                    //permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                    //show popup to request runtime permission
                    requestPermissions(permissions, FavoriteFragment.PERMISSION_CODE);
                } else {
                    //permission already granted
                    pickImageFromGallery2();
                }
            } else {
                //system OS is < Marshmallow
                pickImageFromGallery2();
            }
        }
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

   /* private fun doStore(gender: String) {
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

    */
}