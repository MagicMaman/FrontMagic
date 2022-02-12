package com.example.magicmamanapplication.fragments

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.Retrofit.MagicMamanApi
import com.example.magicmamanapplication.Retrofit.Retrofit
import com.example.magicmamanapplication.activities.Menu
import com.example.magicmamanapplication.databinding.SignupTabFragmentBinding
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.custom_toast.*
import kotlinx.android.synthetic.main.login_tab_fragment.*
import kotlinx.android.synthetic.main.login_tab_fragment.edtTxtEmail
import kotlinx.android.synthetic.main.login_tab_fragment.edtTxtPassword
import kotlinx.android.synthetic.main.signup_tab_fragment.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*


class SignUpTabFragment : Fragment() {
    //lateinit var btnSuivant: ImageView
    lateinit var radBtnG: RadioButton
    lateinit var radBtnF: RadioButton
    lateinit var gender: String
    var pref=""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //radBtnG= requireView().findViewById(R.id.radBtnG)
        //radBtnF= requireView().findViewById(R.id.radBtnF)
        val bind = SignupTabFragmentBinding.inflate(layoutInflater)
        radBtnF = bind.radBtnF.findViewById(R.id.radBtnF)
        bind.btnRegister.setOnClickListener {
            clickNext()
        }
        loadData()

        if(radBtnF.isChecked){
            gender  = "fille"
        }
        else {
            gender  = "garcon"
        }
        val spinnerLien : Spinner = bind.spinnerLien.findViewById(R.id.spinnerLien)
        val lienNames = arrayOf("Mère","Père","Partenaire","Grand-parent","Oncle ou Tante","Ami(e)")
        val arrayAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, lienNames )
        // attached arrayadapter to spinner
        spinnerLien.adapter = arrayAdapter
        spinnerLien.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }

        }




        val myCalendar = Calendar.getInstance()

        //val edittext = requireView().findViewById<View>(R.id.edtTxtAnniv) as EditText
        val date =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth -> // TODO Auto-generated method stub
                myCalendar[Calendar.YEAR] = year
                myCalendar[Calendar.MONTH] = monthOfYear
                myCalendar[Calendar.DAY_OF_MONTH] = dayOfMonth
                updateLabel()
            }

        bind.edtTxtAnniv.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                // TODO Auto-generated method stub
                DatePickerDialog(requireContext(), date, myCalendar[Calendar.YEAR], myCalendar[Calendar.MONTH],
                    myCalendar[Calendar.DAY_OF_MONTH]
                ).show()
            }
        })

        //return view
        return bind.root
        // Inflate the layout for this fragment

    }

    private fun clickNext() {
        if (validate()) {
            doSignUp()
            saveData()
            doStore(gender)


        }
    }


    private fun validate(): Boolean {
        val layout :View = layoutInflater.inflate(R.layout.name_toast, ll_wrapper)
        val layout1 :View = layoutInflater.inflate(R.layout.email_toast, ll_wrapper)
        val layout2 :View = layoutInflater.inflate(R.layout.validatemail_toast, ll_wrapper)
        val layout3 :View = layoutInflater.inflate(R.layout.password_toast, ll_wrapper)
        val layout4 :View = layoutInflater.inflate(R.layout.confirmpass_toast, ll_wrapper)
        val layout5 :View = layoutInflater.inflate(R.layout.diff_toast, ll_wrapper)
        val layout6 :View = layoutInflater.inflate(R.layout.maxlength_toast, ll_wrapper)
        val layout7 :View = layoutInflater.inflate(R.layout.custom_toast, ll_wrapper)
        val layout8 :View = layoutInflater.inflate(R.layout.anniv_toast, ll_wrapper)
        val toast: Toast = Toast(requireContext())
        val toast1: Toast = Toast(requireContext())
        val toast2: Toast = Toast(requireContext())
        val toast3: Toast = Toast(requireContext())
        val toast4: Toast = Toast(requireContext())
        val toast5: Toast = Toast(requireContext())
        val toast6: Toast = Toast(requireContext())
        val toast7: Toast = Toast(requireContext())
        val toast8: Toast = Toast(requireContext())

        if (edtTxtName?.text!!.isEmpty()) {
            (toast.apply {
                duration = Toast.LENGTH_SHORT
                //setGravity(Gravity.BOTTOM,0,0)
                view = layout
                show()
            })
            return false
        }

        if (edtTxtEmail?.text!!.isEmpty()) {
            (toast1.apply {
                duration = Toast.LENGTH_SHORT
                //setGravity(Gravity.BOTTOM,0,0)
                view = layout1
                show()
            })
            return false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(edtTxtEmail?.text!!).matches()) {
            (toast2.apply {
                duration = Toast.LENGTH_SHORT
                //setGravity(Gravity.BOTTOM,0,0)
                view = layout2
                show()
            })
            return false
        }
        if (edtTxtPassword?.text!!.isEmpty()) {
            (toast3.apply {
                duration = Toast.LENGTH_SHORT
                //setGravity(Gravity.BOTTOM,0,0)
                view = layout3
                show()
            })
            return false
        }
       // if (!edtTxtPassword?.text!!.equals(edtTxtConfirmPass.text) ) {
        if (!edtTxtPassword.getText().toString().equals(edtTxtConfirmPass.getText().toString())) {
                //return true
            (toast5.apply {
                duration = Toast.LENGTH_SHORT
                //setGravity(Gravity.BOTTOM,0,0)
                view = layout5
                show()
            })
            return false
        }
        if (edtTxtConfirmPass?.text!!.isEmpty()) {
            (toast4.apply {
                duration = Toast.LENGTH_SHORT
                //setGravity(Gravity.BOTTOM,0,0)
                view = layout4
                show()
            })
            return false
        }
        if (edtTxtPassword?.text!!.length!=4 ) {
            (toast6.apply {
                duration = Toast.LENGTH_SHORT
                //setGravity(Gravity.BOTTOM,0,0)
                view = layout6
                show()
            })
            return false
        }

        if (edtTxtPrenom?.text!!.isEmpty()) {
            (toast7.apply {
                duration = Toast.LENGTH_SHORT
                //setGravity(Gravity.BOTTOM,0,0)
                view = layout7
                show()
            })
            return false
        }

        if (edtTxtAnniv?.text!!.isEmpty()) {
            (toast8.apply {
                duration = Toast.LENGTH_SHORT
                //setGravity(Gravity.BOTTOM,0,0)
                view = layout8
                show()
            })
            return false
        }

        return true
    }

    private fun doSignUp() {
        val paramObject1 = JSONObject()
        paramObject1.put("name",edtTxtName.text.toString().trim())
        paramObject1.put("email",edtTxtEmail.text.toString().trim())
        paramObject1.put("password", edtTxtPassword.text.toString().trim())
        val jsonParser = JsonParser()
        var gsonObject1 = jsonParser.parse(paramObject1.toString()) as JsonObject
        val retro = Retrofit().getRetroClinetInstance().create(MagicMamanApi::class.java)

        retro.SignUp(gsonObject1).enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {

                val user = response.body()?.get("username").toString()
                //val username=user.substring(1,user.length-1) ca depend ena w kifeh bsh temchi ll 2 cotes

                Toast.makeText(context, "Sign Up Success", Toast.LENGTH_SHORT).show()

                val intent= Intent(this@SignUpTabFragment.requireContext(), Menu::class.java)
                startActivity(intent)

            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.d("Error", t.message.toString())
                Toast.makeText(context, "Sign Up failure", Toast.LENGTH_SHORT).show()
            }
        })
    }

    /*identify*/
    private fun updateLabel() {
        val myCalendar = Calendar.getInstance()


        val myFormat = "MM/dd/yy" //In which you need put here
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        edtTxtAnniv.setText(sdf.format(myCalendar.getTime()))
    }



    private fun saveData(){
        val insertedText = edtTxtPrenom.text.toString()

        val sharedPreferences = this.activity?.getSharedPreferences("sharedPrefs2", Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.apply {
            putString("STRING_KEY", insertedText)
            //putBoolean("BOOLEAN_KEY", sw_switch.isChecked)
        }?.apply()
        if (!insertedText.isEmpty()){
            //Toast.makeText(this@Identify, "baby Added Sucessfull!", Toast.LENGTH_SHORT).show()
            val i= Intent(requireContext(), Menu::class.java)
            startActivity(i)
        }

        // txtPrenomBebe.text = insertedText
        Log.d("houniiiiiiii",insertedText)
        Log.d("houniiiiiiii",insertedText)

        Toast.makeText(requireContext(),"Data Saved",Toast.LENGTH_SHORT).show()
    }
    private fun loadData(){

        val sharedPreferences = this.activity?.getSharedPreferences("sharedPrefs2", Context.MODE_PRIVATE)
        val savedString : String? = sharedPreferences?.getString("STRING_KEY", null)
        //val savedBoolean : Boolean = sharedPreferences.getBoolean("BOOLEAN_KEY", false)

        //txtPrenomBebe.text = savedString
        if (savedString != null) {
            if (!savedString.isEmpty()){
                Toast.makeText(requireContext(), "baby Added Sucessfull!", Toast.LENGTH_SHORT).show()
                val i= Intent(requireContext(), Menu::class.java)
                startActivity(i)
            }
        }
        // sw_switch.isChecked = savedBoolean
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
                Toast.makeText(requireContext(), "an error Occured!", Toast.LENGTH_SHORT).show()
            }
        })

    }

}