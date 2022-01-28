package com.example.magicmamanapplication.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.activities.EditProfile
import com.example.magicmamanapplication.activities.MainActivity2
import com.example.magicmamanapplication.activities.ReminderActivity
import com.example.magicmamanapplication.databinding.SignupTabFragmentBinding
import kotlinx.android.synthetic.main.fragment_settings.*
import androidx.fragment.app.Fragment
import com.example.magicmamanapplication.activities.byeActivity

class SettingsFragment : Fragment() {
    private lateinit var reminderCardView:CardView
    private lateinit var profileCardView:CardView
    private lateinit var paa:CardView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        reminderCardView = view.findViewById(R.id.reminderCardView)
        profileCardView = view.findViewById(R.id.profileCardView)
        // logoutCardView = view.findViewById(R.id.logoutCardView)
        reminderCardView.setOnClickListener {
            val intent = Intent(requireContext(),MainActivity2::class.java)
            startActivity(intent)
        }
        profileCardView.setOnClickListener {
            val intent = Intent(requireContext(),EditProfile::class.java)
            startActivity(intent)
        }



        //

        // logoutCardView = view.findViewById(R.id.logoutCardView)
        /*    paa.setOnClickListener {
                val intent = Intent(requireContext(),MainActivity2::class.java)
                startActivity(intent)
            }*/
        paa = view.findViewById(R.id.logoutCardView)
        paa.setOnClickListener {
            /*  val transaction = getActivity().getSupportFragmentManager().beginTransaction()
                  .replace(R.id.fragmentContainerView, LoginTabFragment()).commitNow()
  */

            val intent = Intent(requireContext(),byeActivity::class.java)
            startActivity(intent)


        }

        return view

    }
}