package com.example.tablayout.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tablayout.screen.FirstFragment
import com.example.tablayout.screen.SecondFragment
import com.example.tablayout.screen.ThreeFragment

class PagerAdapter(fragmentActivity: FragmentActivity) :FragmentStateAdapter(fragmentActivity){
    override fun getItemCount(): Int {
        return 3

    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> FirstFragment()
            1-> SecondFragment()
            else-> ThreeFragment()
        }
    }
}