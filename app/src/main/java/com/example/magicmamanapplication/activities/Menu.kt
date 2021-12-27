package com.example.magicmamanapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.FragmentTransaction
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.fragments.FavoriteFragment
import com.example.magicmamanapplication.fragments.HomeFragment
import com.example.magicmamanapplication.fragments.ResumeFragment
import com.example.magicmamanapplication.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

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