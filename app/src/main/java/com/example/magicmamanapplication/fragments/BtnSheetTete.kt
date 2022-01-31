package com.example.magicmamanapplication.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.magicmamanapplication.MainViewModel
import com.example.magicmamanapplication.MainViewModelFactory
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.Retrofit.MagicMamanApi
import com.example.magicmamanapplication.Retrofit.Retrofit
import com.example.magicmamanapplication.activities.Identify
import com.example.magicmamanapplication.repository.Repository
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_added_soon.*
import kotlinx.android.synthetic.main.fragment_btn_sheet_tete.*
import kotlinx.android.synthetic.main.login_tab_fragment.*
import kotlinx.android.synthetic.main.signup_tab_fragment.*
import kotlinx.android.synthetic.main.signup_tab_fragment.edtTxtEmail
import kotlinx.android.synthetic.main.signup_tab_fragment.edtTxtPassword
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BtnSheetTete : Fragment() {
lateinit var textv1:TextView
lateinit var textv2:TextView
lateinit var confirmer:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_btn_sheet_tete, container, false)
        textv1=view.findViewById(R.id.saveTimeTv)
        textv2=view.findViewById(R.id.saveNotesTete)
        confirmer=view.findViewById(R.id.btn_confirm_tete)
        confirmer.setOnClickListener {
            val repository = Repository()
            val viewModelFactory = MainViewModelFactory(repository)
            var viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
            // viewModel.getCustomPosts(5,"id", "desc")
            viewModel.addtete("baby",textv1.text.toString(),textv2.text.toString())
              //   Toast.makeText(this,"good",Toast.LENGTH_SHORT).show()
            //Log.e("jawekbehi",textv2.text.toString())
          //  Log.d("message","enty lhne")


        }
        //Ajout

        return view
    }

}