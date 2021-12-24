package com.example.magicmamanapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_menu.*

class Menu : AppCompatActivity(){
    //create our four fragments object
    lateinit var favoriteFragment: FavoriteFragment
    lateinit var homeFragment: HomeFragment
    lateinit var settingsFragment: SettingsFragment
    lateinit var resumeFragment: ResumeFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        //now lest's create our framelayout and bottomnav variables
        var bottomnav : BottomNavigationView = findViewById<BottomNavigationView>(R.id.btnNavMenu)
        var frame :FrameLayout = findViewById<FrameLayout>(R.id.frameLayout)
        //the default fragment
        homeFragment = HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout,homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()



            //create our different fragments
            // let's add the menu event listener
        bottomnav.setOnNavigationItemSelectedListener { item ->
            //we will select each menu item and add an event when it's selected
            when(item.itemId){
                R.id.home ->
                {
                    homeFragment = HomeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout,homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.favorite ->
                {
                    favoriteFragment = FavoriteFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout,favoriteFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.settings ->
                {
                    settingsFragment = SettingsFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout,settingsFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.resume ->
                {
                    resumeFragment = ResumeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout,resumeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

            }
            true

        }


    }

}