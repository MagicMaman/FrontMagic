package com.example.magicmamanapplication.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.activities.ReminderActivity
import com.example.magicmamanapplication.databinding.SignupTabFragmentBinding
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : Fragment() {
    private lateinit var reminder_cardv:CardView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        reminder_cardv = view.findViewById(R.id.reminder_cardv)
        reminder_cardv.setOnClickListener {
            val intent = Intent(requireContext(),ReminderActivity::class.java)
            startActivity(intent)
        }
        return view



    }
}