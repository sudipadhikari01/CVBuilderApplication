package com.sudip.cvapp.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.sudip.cvapp.R


import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)

    }

    private fun initViews(view: View) {
        viewPager = view.findViewById(R.id.view_pager)
        tabLayout = view.findViewById(R.id.tab_layout)

        val viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter

        //initializing tab layout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            val tabName: String = when(position) {
                0 -> getString(R.string.home)
                1 -> getString(R.string.about_me)
                2 -> getString(R.string.work)
                3 -> getString(R.string.contact)
                else -> getString(R.string.home)
            }
            tab.text = tabName

        }.attach()

    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}