package com.example.magicmamanapplication.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.databinding.SignupTabFragmentBinding
import kotlinx.android.synthetic.main.fragment_settings.*
import androidx.fragment.app.Fragment
import com.example.magicmamanapplication.AddedSoon
import com.example.magicmamanapplication.activities.*
import kotlinx.android.synthetic.main.custom_toast.*

class SettingsFragment : Fragment() {
    private lateinit var reminderCardView:CardView
    private lateinit var profileCardView:CardView
    private lateinit var contactusCardView:CardView
    private lateinit var paa:CardView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        reminderCardView = view.findViewById(R.id.reminderCardView)
        profileCardView = view.findViewById(R.id.profileCardView)
       // contactusCardView = view.findViewById(R.id.contactusCardView)

        contactusCardView = view.findViewById(R.id.contactusCardView)
        contactusCardView.setOnClickListener{
            /*toast.apply {
                duration = Toast.LENGTH_SHORT
                //setGravity(Gravity.BOTTOM,0,0)
                view = layout
                show()
            }*/
//Toast.makeText(this,"aaaaaaaaaaaaaaa",Toast.LENGTH_SHORT).show()
            //malek()
            val intent = Intent(requireContext(),AddedSoon::class.java)
            startActivity(intent)
        }
        // logoutCardView = view.findViewById(R.id.logoutCardView)
        reminderCardView.setOnClickListener {
            val intent = Intent(requireContext(),MainActivity2::class.java)
            startActivity(intent)
        }
        profileCardView.setOnClickListener {
            val intent = Intent(requireContext(),AddedSoon::class.java)
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

   /* fun malek(){
        Toast.makeText(this.view?.context?.applicationContext,"ertyu",Toast.LENGTH_SHORT).show()
    }*/
}