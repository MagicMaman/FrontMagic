package com.example.magicmamanapplication.fragments

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.magicmamanapplication.activities.Identify
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.Retrofit.MagicMamanApi
import com.example.magicmamanapplication.Retrofit.Retrofit
import com.example.magicmamanapplication.databinding.LoginTabFragmentBinding
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_identify.*
import kotlinx.android.synthetic.main.custom_toast.*
import kotlinx.android.synthetic.main.login_tab_fragment.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
const val PREF_NAME = "shared"
const val IS_REMEMBRED = "IS_REMEMBRED"
const val NAME = "NAME"
const val EMAIL = "EMAIL"
const val PASSWORD = "PASSWORD"
const val IMAGE = "IMAGE"
const val ID = "Id"






class LoginTabFragment : Fragment() {

    lateinit var checkBoxRememberMe: CheckBox
    lateinit var mSharedPref: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bind = LoginTabFragmentBinding.inflate(layoutInflater)
        mSharedPref = requireActivity().getSharedPreferences(PREF_NAME, AppCompatActivity.MODE_PRIVATE)
        checkBoxRememberMe= bind.checkBoxRememberMe.findViewById(R.id.checkBoxRememberMe)


        if(mSharedPref.getBoolean(IS_REMEMBRED, true)){
            val intent= Intent(this@LoginTabFragment.requireContext(), Identify::class.java)
            startActivity(intent)
           // Log.e("yamalek",edtTxtEmail.text.toString())

        }
        bind.imageView.setOnClickListener {
          /*  val intent= Intent(this@LoginTabFragment.requireContext(), Identify::class.java)
            startActivity(intent)*/
            if(checkBoxRememberMe.isChecked){
                mSharedPref.edit().putBoolean(IS_REMEMBRED, true).apply()
            }else {
                mSharedPref.edit().putBoolean(IS_REMEMBRED, false).apply()
            }

                clickNext()
        }
        return bind.root
    }

    private fun clickNext() {
        if (validate()) {
            doLogin()

        }
    }

    private fun validate(): Boolean {
        val layout :View = layoutInflater.inflate(R.layout.email_toast, ll_wrapper)
        val layout1 :View = layoutInflater.inflate(R.layout.password_toast, ll_wrapper)
        val layout2 :View = layoutInflater.inflate(R.layout.validatemail_toast, ll_wrapper)
        val toast: Toast = Toast(requireContext())
        val toast1: Toast = Toast(requireContext())
        val toast2: Toast = Toast(requireContext())

        if (edtTxtEmail?.text!!.isEmpty()) {
            (toast.apply {
                duration = Toast.LENGTH_SHORT
                //setGravity(Gravity.BOTTOM,0,0)
                view = layout
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

    private fun doLogin() {
        val paramObject1 = JSONObject()
        paramObject1.put("email",edtTxtEmail.text.toString().trim())//1)par rapport eli 3andi fl user2)part rapport eli 3andi fl txt fl application
        paramObject1.put("password", edtTxtPassword.text.toString().trim())
        val jsonParser = JsonParser()
        var gsonObject1 = jsonParser.parse(paramObject1.toString()) as JsonObject
        val retro = Retrofit().getRetroClinetInstance().create(MagicMamanApi::class.java)
        retro.login(gsonObject1).enqueue(object : Callback<JsonObject> {

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
            if(response.code()==200) {
                val user = response.body()?.get("name").toString()
                val id = response.body()?.get("_id").toString()
                val email = response.body()?.get("email").toString()
                val image = response.body()?.get("image").toString()
                val password = response.body()?.get("password").toString()
                val username=user.substring(1,user.length-1)

                Log.e("Erooooorr",username)
                Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@LoginTabFragment.requireContext(), Identify::class.java)
                mSharedPref.edit().apply {
                    putString(EMAIL, email.substring(1, email.length -1))
                    putString(ID, id.substring(1, id.length -1))
                    putString(IMAGE, image.substring(1, image.length -1))
                    putString(PASSWORD, password.substring(1, password.length -1))
                    putString(NAME,user.substring(1,user.length-1))
                }.apply()

                startActivity(intent)
            }
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("Error", t.message.toString())
                Toast.makeText(context, "User not found", Toast.LENGTH_SHORT).show()
            }
        })
    }
    }



