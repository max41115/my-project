package com.example.tablayout

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.tablayout.adapter.PagerAdapter
import com.example.tablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initial()
    }

    private fun initial() {
        binding.viewPager.adapter = PagerAdapter(this)
        binding.tabLayout.tabIconTint=null
        TabLayoutMediator (binding.tabLayout, binding.viewPager){
            tab, pos ->
            when(pos) {
                0 -> {tab.setIcon(R.drawable.ic_baseline_accessibility_24)
                tab.icon?. setTint (ContextCompat.getColor(this, R.color.teal_200))
            }
                1 -> {tab.setIcon(R.drawable.ic_baseline_accessible_forward_24)
                    tab.icon?. setTint (ContextCompat.getColor(this, R.color.purple_200))
                    tab.icon?.alpha = 70
                }
                2 -> {tab.setIcon(R.drawable.ic_baseline_baby_changing_station_24)
                tab.icon?. setTint (ContextCompat.getColor(this, R.color.black))
                    tab.icon?.alpha = 70
            }
            }
        }.attach()
        binding.tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
              tab.icon?.alpha = 250
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    tab.icon?.alpha = 70
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }
}