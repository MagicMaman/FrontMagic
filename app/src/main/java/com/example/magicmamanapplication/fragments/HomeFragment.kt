package com.example.magicmamanapplication.fragments

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.magicmamanapplication.*
import com.example.magicmamanapplication.activities.*
import com.example.magicmamanapplication.adapters.HorizantalRcyclerViewMenuAdapter
import com.google.android.material.imageview.ShapeableImageView
import kotlinx.android.synthetic.main.photo_layout.*


class HomeFragment : Fragment(), HorizantalRcyclerViewMenuAdapter.OnItemClickListener {
    private lateinit var menuRcView : RecyclerView
    private lateinit var adapter: HorizantalRcyclerViewMenuAdapter
    private lateinit var menuArrayList: ArrayList<MenuItem>
    lateinit var imgressource1 : Array<Int>
    lateinit var imgressource2 : Array<Int>
    private lateinit var profilePic: ShapeableImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_home, container, false)
        profilePic = view.findViewById(R.id.profilePic)
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

        profilePic.setOnClickListener {
            //check runtime permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(requireContext(),android.Manifest.permission.READ_EXTERNAL_STORAGE ) ==
                    PackageManager.PERMISSION_DENIED
                ) {
                    //permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                    //show popup to request runtime permission
                    requestPermissions(permissions, HomeFragment.PERMISSION_CODE);
                } else {
                    //permission already granted
                    pickImageFromGallery();
                }
            } else {
                //system OS is < Marshmallow
                pickImageFromGallery();
            }
        }
        return view

    }

    override fun onItemClick(position: Int) {
        //Toast.makeText(this,"Item $position Clicked",Toast.LENGTH_SHORT).show()
        if (position==0){
            val intent =Intent(activity, Nourriture::class.java)
            requireActivity().startActivity(intent)
        }
        if (position==1){
            val intent =Intent(activity, Sommeil::class.java)
            requireActivity().startActivity(intent)
        }
        if (position==2){
            val intent =Intent(activity, Croissance::class.java)
            requireActivity().startActivity(intent)
        }
        if (position==3){
            val intent =Intent(activity, Sante::class.java)
            requireActivity().startActivity(intent)
        }
        if (position==4){
            val intent =Intent(activity, Guides::class.java)
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
    @SuppressLint("MissingSuperCall")
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
    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            profilePic.setImageURI(data?.data)
        }
    }


}