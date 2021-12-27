package com.example.magicmamanapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.ExpandableListView.OnChildClickListener
import com.example.magicmamanapplication.adapters.ExpandableListViewAdapter
import com.example.magicmamanapplication.R


class ResumeFragment : Fragment() {
    private lateinit var listViewAdapter: ExpandableListViewAdapter
    private lateinit var itemList : List<String>
    private lateinit var subItemList : HashMap<String, List<String>>
    private lateinit var eListView : ExpandableListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_resume, container, false)
        showList() // this function is call before set Adapter
        eListView =view.findViewById(R.id.eListView)
        listViewAdapter = ExpandableListViewAdapter(requireContext(), itemList, subItemList)
        eListView.setAdapter(listViewAdapter)
        //eListView.setOnChildClickListener()
        return view
    }

    private fun showList() {
        itemList =  ArrayList()
        subItemList = HashMap()

        (itemList as ArrayList<String>).add("Nourriture")
        (itemList as ArrayList<String>).add("Sommeil")
        (itemList as ArrayList<String>).add("Croissance")
        (itemList as ArrayList<String>).add("Santé")

        val teteee : MutableList<String> = ArrayList()
        teteee.add("Tétée")
        teteee.add("Repas Solide")
        teteee.add("Bibrons")

        val sommeilll : MutableList<String> = ArrayList()
        sommeilll.add("Sommeil")
        sommeilll.add("Réveil")

        val croissancee : MutableList<String> = ArrayList()
        croissancee.add("Taille")
        croissancee.add("Poids")

        val santee : MutableList<String> = ArrayList()
        santee.add("Température")
        santee.add("Médicaments")
        santee.add("Vaccin")

        subItemList[itemList[0]] = teteee
        subItemList[itemList[1]] = sommeilll
        subItemList[itemList[2]] = croissancee
        subItemList[itemList[3]] = santee



    }
 }