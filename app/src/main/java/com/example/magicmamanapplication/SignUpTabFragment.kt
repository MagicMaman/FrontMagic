package com.example.magicmamanapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.magicmamanapplication.Retrofit.MagicMamanApi
import com.example.magicmamanapplication.Retrofit.Retrofit
import com.example.magicmamanapplication.databinding.SignupTabFragmentBinding
import com.google.gson.JsonObject
import com.google.gson.JsonParser
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
            doSignUp()
        }


        return bind.root
        // Inflate the layout for this fragment

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
                Log.e("Error", t.message.toString())
                Toast.makeText(context, "Sign Up failure", Toast.LENGTH_SHORT).show()
            }
        })
    }
}