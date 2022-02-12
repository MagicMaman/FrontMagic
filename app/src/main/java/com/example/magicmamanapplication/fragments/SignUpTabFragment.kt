package com.example.magicmamanapplication.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.activities.Identify
import com.example.magicmamanapplication.Retrofit.MagicMamanApi
import com.example.magicmamanapplication.Retrofit.Retrofit
import com.example.magicmamanapplication.databinding.SignupTabFragmentBinding
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_identify.*
import kotlinx.android.synthetic.main.custom_toast.*
import kotlinx.android.synthetic.main.login_tab_fragment.*
import kotlinx.android.synthetic.main.login_tab_fragment.edtTxtEmail
import kotlinx.android.synthetic.main.login_tab_fragment.edtTxtPassword
import kotlinx.android.synthetic.main.signup_tab_fragment.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignUpTabFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bind = SignupTabFragmentBinding.inflate(layoutInflater)
        bind.btnRegister.setOnClickListener {
            /*val intent= Intent(this@SignUpTabFragment.requireContext(), Identify::class.java)
            startActivity(intent)*/

            clickNext()
        }


        return bind.root
        // Inflate the layout for this fragment

    }

    private fun clickNext() {
        if (validate()) {
            doSignUp()

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
        val toast: Toast = Toast(requireContext())
        val toast1: Toast = Toast(requireContext())
        val toast2: Toast = Toast(requireContext())
        val toast3: Toast = Toast(requireContext())
        val toast4: Toast = Toast(requireContext())
        val toast5: Toast = Toast(requireContext())
        val toast6: Toast = Toast(requireContext())

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


        /* if(setBirthdayEditText())
         {
             Toast.makeText(this, "incorrect date format!", Toast.LENGTH_SHORT).show()
             return false
         }*/

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

                val intent= Intent(this@SignUpTabFragment.requireContext(), Identify::class.java)
                startActivity(intent)

            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.d("Error", t.message.toString())
                Toast.makeText(context, "Sign Up failure", Toast.LENGTH_SHORT).show()
            }
        })
    }
}