package com.example.magicmamanapplication.fragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.ExpandableListView.OnChildClickListener
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.activities.*
import com.example.magicmamanapplication.adapters.ExpandableListViewAdapter

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
        eListView.setOnChildClickListener(OnChildClickListener { parent, v, groupPosition, childPosition, id -> //Nothing here ever fires
            if (groupPosition === 0) {
                if (childPosition === 0) {
                    val child0Intent = Intent(requireContext(), ResumeTete::class.java)
                    startActivity(child0Intent)
                }
                if (childPosition === 1) {
                    val child1Intent = Intent(requireContext(), ResumeRepasSolide::class.java)
                    startActivity(child1Intent)
                }
                if (childPosition === 2) {
                    val child2Intent = Intent(requireContext(), ResumeBibrons::class.java)
                    startActivity(child2Intent)
                }
            }
            if (groupPosition === 1) {
                if (childPosition === 0) {
                    val child3Intent = Intent(requireContext(), ResumeSommeil::class.java)
                    startActivity(child3Intent)
                }
            }
            if (groupPosition === 2) {
                if (childPosition === 0) {
                    val child0Intent = Intent(requireContext(), ResumeTaille::class.java)
                    startActivity(child0Intent)
                }
                if (childPosition === 1) {
                    val child1Intent = Intent(requireContext(), ResumePoids::class.java)
                    startActivity(child1Intent)
                }
            }
            if (groupPosition === 3) {
                if (childPosition === 0) {
                    val child0Intent = Intent(requireContext(), ResumeTemperature::class.java)
                    startActivity(child0Intent)
                }
                if (childPosition === 1) {
                    val child1Intent = Intent(requireContext(), ResumeMedicaments::class.java)
                    startActivity(child1Intent)
                }
                if (childPosition === 2) {
                    val child2Intent = Intent(requireContext(), ResumeVaccin::class.java)
                    startActivity(child2Intent)
                }
            }
            true
        })
        return view
    }

    private fun showList() {
        itemList =  ArrayList()
        subItemList = HashMap()

        (itemList as ArrayList<String>).add("Nourriture")
        (itemList as ArrayList<String>).add("Sommeil")
        (itemList as ArrayList<String>).add("Croissance")
        (itemList as ArrayList<String>).add("Santé")

        val nourriture : MutableList<String> = ArrayList()
        nourriture.add("Tétée")
        nourriture.add("Repas Solide")
        nourriture.add("Bibrons")

        val sommeil : MutableList<String> = ArrayList()
        sommeil.add("Sommeil")

        val croissance : MutableList<String> = ArrayList()
        croissance.add("Taille")
        croissance.add("Poids")

        val sante : MutableList<String> = ArrayList()
        sante.add("Température")
        sante.add("Médicaments")
        sante.add("Vaccin")

        subItemList[itemList[0]] = nourriture
        subItemList[itemList[1]] = sommeil
        subItemList[itemList[2]] = croissance
        subItemList[itemList[3]] = sante



    }
 }