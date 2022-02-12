package com.example.magicmamanapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.magicmamanapplication.MainViewModel
import com.example.magicmamanapplication.MainViewModelFactory
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.repository.Repository


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