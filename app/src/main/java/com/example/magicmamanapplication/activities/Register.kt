package com.example.magicmamanapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.magicmamanapplication.R
import com.example.magicmamanapplication.adapters.RegisterAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Register : AppCompatActivity() {
    var tabTitle = arrayOf("Sign In ", "Register")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var pager =findViewById<ViewPager2>(R.id.viewPager2)
        var t1 = findViewById<TabLayout>(R.id.tabLayout)
        pager.adapter = RegisterAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(t1, pager){
            tab,position ->
            tab.text = tabTitle[position]
        }.attach()

    }
}





