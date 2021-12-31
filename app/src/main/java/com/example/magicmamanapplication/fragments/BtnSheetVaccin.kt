package com.example.magicmamanapplication.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.activities.Vaccin

class BtnSheetVaccin : Fragment() {
    private lateinit var updatebtn : ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_btn_sheet_vaccin, container, false)
        updatebtn = view.findViewById(R.id.btn_update_vaccin)
        updatebtn.setOnClickListener{
            val intent = Intent(requireContext(),Vaccin::class.java)
            startActivity(intent)
        }
        return view
    }


}