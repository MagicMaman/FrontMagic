package com.example.magicmamanapplication.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.magicmamanapplication.DataModel
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.adapters.PhotoAdapter

class FavoriteFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var photoAdapter: PhotoAdapter
    private var dataList = mutableListOf<DataModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_favorite, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireActivity().application, 2)
        photoAdapter = PhotoAdapter(requireActivity().application){
           Log.e("message","message")
        }
        recyclerView.adapter = photoAdapter

        dataList.add(DataModel("Mon retour à la maison", R.drawable.icon_add))
        dataList.add(DataModel("Premier sourire", R.drawable.icon_add))
        dataList.add(DataModel("Première tétée", R.drawable.icon_add))
        dataList.add(DataModel("Sommeil", R.drawable.icon_add))
        dataList.add(DataModel("Heure du bain", R.drawable.icon_add))
        dataList.add(DataModel("Sortir", R.drawable.icon_add))
        dataList.add(DataModel("Premier rire", R.drawable.icon_add))
        dataList.add(DataModel("J'ai trouvé mes mains", R.drawable.icon_add))
        dataList.add(DataModel("Je soulève ma tete", R.drawable.icon_add))
        dataList.add(DataModel("Au parc", R.drawable.icon_add))
        dataList.add(DataModel("Premier calin", R.drawable.icon_add))
        dataList.add(DataModel("1er aliments solides", R.drawable.icon_add))
        dataList.add(DataModel("Premier repas", R.drawable.icon_add))
        dataList.add(DataModel("Se retourner", R.drawable.icon_add))
        dataList.add(DataModel("S'asseoir", R.drawable.icon_add))
        dataList.add(DataModel("", R.drawable.icon_add))
        dataList.add(DataModel("Jouet préféré", R.drawable.icon_add))
        dataList.add(DataModel("Ma chambre", R.drawable.icon_add))
        dataList.add(DataModel("Mon berceau", R.drawable.icon_add))
        dataList.add(DataModel("Ma chaise", R.drawable.icon_add))
        dataList.add(DataModel("J'ai fait ma nuit", R.drawable.icon_add))
        dataList.add(DataModel("Première nage", R.drawable.icon_add))
        dataList.add(DataModel("1ère coupe de cheveux", R.drawable.icon_add))
        dataList.add(DataModel("Dit au revoir de la main", R.drawable.icon_add))
        dataList.add(DataModel("J'ai bu dans une tasse", R.drawable.icon_add))
        dataList.add(DataModel("Aliment préféré", R.drawable.icon_add))
        dataList.add(DataModel("Première fois à 4 pattes", R.drawable.icon_add))
        dataList.add(DataModel("J'applaudis", R.drawable.icon_add))
        dataList.add(DataModel("J'ai trouvé mes pieds", R.drawable.icon_add))
        dataList.add(DataModel("Je me tiens debout", R.drawable.icon_add))
        dataList.add(DataModel("Coucou", R.drawable.icon_add))

        photoAdapter.setDataList(dataList)

        return view

    }
}