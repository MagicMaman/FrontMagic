package com.example.magicmamanapplication.fragments

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.Manifest
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.magicmamanapplication.DataModel
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.adapters.PhotoAdapter
import kotlinx.android.synthetic.main.photo_layout.*

class FavoriteFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var photoAdapter: PhotoAdapter
    private var dataList = mutableListOf<DataModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorite, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireActivity().application, 2)
        photoAdapter = PhotoAdapter(requireActivity().application) {
            // Log.e("message","clicked")
            //check runtime permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(requireContext(),android.Manifest.permission.READ_EXTERNAL_STORAGE ) ==
                    PackageManager.PERMISSION_DENIED
                ) {
                    //permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                    //show popup to request runtime permission
                    requestPermissions(permissions, PERMISSION_CODE);
                } else {
                    //permission already granted
                    pickImageFromGallery();
                }
            } else {
                //system OS is < Marshmallow
                pickImageFromGallery();
            }
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

    private fun pickImageFromGallery() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object {
        //image pick code
        private val IMAGE_PICK_CODE = 1000;

        //Permission code
        val PERMISSION_CODE = 1001;
    }

    //handle requested permission result
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED
                ) {
                    //permission from popup granted
                    pickImageFromGallery()
                } else {
                    //permission from popup denied
                    Toast.makeText(requireContext(), "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }


    }
    //handle result of picked image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            imagePhoto.setImageURI(data?.data)
        }
    }
}