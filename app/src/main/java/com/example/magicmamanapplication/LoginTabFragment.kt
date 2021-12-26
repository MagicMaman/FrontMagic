package com.example.magicmamanapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.magicmamanapplication.databinding.LoginTabFragmentBinding
import com.example.magicmamanapplication.Retrofit.MagicMamanApi
import com.example.magicmamanapplication.Retrofit.Retrofit
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.login_tab_fragment.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginTabFragment : Fragment() {
    lateinit var txtSignup : TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bind = LoginTabFragmentBinding.inflate(layoutInflater)
        bind.imageView.setOnClickListener {
          /*  val intent= Intent(this@LoginTabFragment.requireContext(), Identify::class.java)
            startActivity(intent)*/

                doLogin()


        }
        return bind.root


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
                val username=user.substring(1,user.length-1)
                Log.e("Erooooorr",username)
                Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@LoginTabFragment.requireContext(), Identify::class.java)
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