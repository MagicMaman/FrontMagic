package com.example.magicmamanapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class RegisterAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
         when(position){
            0->return LoginTabFragment()
            1->return SignUpTabFragment()
            else -> return LoginTabFragment()
        }

    }
}