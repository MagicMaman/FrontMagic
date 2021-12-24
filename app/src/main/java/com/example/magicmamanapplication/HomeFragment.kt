package com.example.magicmamanapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.Toast


class HomeFragment : Fragment(), HorizantalRcyclerViewMenuAdapter.OnItemClickListener {
    private lateinit var menuRcView : RecyclerView
    private lateinit var adapter: HorizantalRcyclerViewMenuAdapter
    private lateinit var menuArrayList: ArrayList<MenuItem>
    lateinit var imgressource1 : Array<Int>
    lateinit var imgressource2 : Array<Int>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_home, container, false)
        imgressource1 = arrayOf(
            R.drawable.image_nouriture,
            R.drawable.image_sommeil,
            R.drawable.image_croissance,
            R.drawable.image_sante,
            R.drawable.image_guides,
        )
        imgressource2 = arrayOf(
            R.drawable.btn_nouriture,
            R.drawable.btn_sommeill,
            R.drawable.btn_croissance,
            R.drawable.btn_sante,
            R.drawable.btn_guide,
        )
        menuRcView = view.findViewById(R.id.menuRcView)
        menuRcView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        menuRcView.setHasFixedSize(true)

        menuArrayList = arrayListOf<MenuItem>()
        getUserdata()
        return view

    }

    override fun onItemClick(position: Int) {
        //Toast.makeText(this,"Item $position Clicked",Toast.LENGTH_SHORT).show()
        if (position==0){
            val intent =Intent(activity,Nourriture::class.java)
            requireActivity().startActivity(intent)
        }
        if (position==1){
            val intent =Intent(activity,Sommeil::class.java)
            requireActivity().startActivity(intent)
        }
        if (position==2){
            val intent =Intent(activity,Croissance::class.java)
            requireActivity().startActivity(intent)
        }
        if (position==3){
            val intent =Intent(activity,Sante::class.java)
            requireActivity().startActivity(intent)
        }
        if (position==4){
            val intent =Intent(activity,Guides::class.java)
            requireActivity().startActivity(intent)
        }
    }
    private fun getUserdata() {
        for(i in imgressource1.indices){
            val menuItem = MenuItem(imgressource1[i],imgressource2[i])
            menuArrayList.add(menuItem)
        }
        adapter = HorizantalRcyclerViewMenuAdapter(menuArrayList, this)
        menuRcView.adapter = adapter


    }


}