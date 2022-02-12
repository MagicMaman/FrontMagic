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
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.Retrofit.MagicMamanApi
import com.example.magicmamanapplication.Retrofit.Retrofit
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.activity_identify.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditProfile : AppCompatActivity() {

    lateinit var btn_update_edit: ImageView
    lateinit var radBtnGEdit: RadioButton
    lateinit var radBtnFEdit: RadioButton
    lateinit var genderEdit: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        radBtnGEdit=findViewById(R.id.radBtnGEdit)
        radBtnFEdit=findViewById(R.id.radBtnFEdit)
        btn_update_edit=findViewById(R.id.btn_update_edit)


        if(radBtnFEdit.isChecked){
            genderEdit  = "fille"
        }
        else {
            genderEdit  = "garcon"
        }
        val spinnerLienEdit : Spinner = findViewById(R.id.spinnerLienEdit)
        btn_update_edit.setOnClickListener {

            /*val i= Intent(this,Menu::class.java)
            startActivity(i)*/
            updateUser(genderEdit)
        }

        val lienNames = arrayOf("Mère","Père","Partenaire","Grand-parent","Oncle ou Tante","Ami(e)")
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, lienNames )
        // attached array adapter to spinner
        spinnerLienEdit.adapter = arrayAdapter
        spinnerLienEdit.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }

        }

        imgHeadEdit.setOnClickListener {
            //check runtime permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE ) ==
                    PackageManager.PERMISSION_DENIED
                ) {
                    //permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                    //show popup to request runtime permission
                    requestPermissions(permissions, EditProfile.PERMISSION_CODE);
                } else {
                    //permission already granted
                    pickImageFromGallery3();
                }
            } else {
                //system OS is < Marshmallow
                pickImageFromGallery3();
            }
        }
    }


    private fun pickImageFromGallery3() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object {
        //image pick code
        private val IMAGE_PICK_CODE = 1002;

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
                    pickImageFromGallery3()
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
            imgHeadEdit.setImageURI(data?.data)
        }
    }

    private fun updateUser(genderEdit: String) {
        val paramObject1 = JSONObject()

        paramObject1.put("name", edtTxtPrenomEdit.text.toString().trim())
        paramObject1.put("birthday", edtTxtAnnivEdit.text.toString().trim())
        paramObject1.put("gender",genderEdit)
        val jsonParser = JsonParser()
        var gsonObject1 = jsonParser.parse(paramObject1.toString()) as JsonObject
        val retro = Retrofit().getRetroClinetInstance().create(MagicMamanApi::class.java)
        retro.updateUser(gsonObject1).enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                if(response.code()==200) {
                    val baby = response.body()?.get("name").toString()
                    val babyname=baby.substring(1,baby.length-1)
                    Log.d("Erooooorr",babyname)
                    Toast.makeText(this@EditProfile, "baby updated Sucessfull!", Toast.LENGTH_SHORT).show()
                    val i= Intent(this@EditProfile, Menu::class.java)
                    startActivity(i)
                }
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.d("Error", t.message.toString())
                Toast.makeText(this@EditProfile, "an error Occured!", Toast.LENGTH_SHORT).show()
            }
        })

    }
}