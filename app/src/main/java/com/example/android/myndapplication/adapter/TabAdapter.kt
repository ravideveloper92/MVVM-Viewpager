package com.example.android.myndapplication.adapter

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import java.util.*
import kotlin.collections.ArrayList

class TabAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm!!) {
    private val TAG = "TabAdapter"
    private val mFragmentList: ArrayList<Fragment> = ArrayList()
    private val mFragmentTitleList: ArrayList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    fun addFragment(fragment: Fragment, title: String, tabLayout: TabLayout) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
        tabLayout.addTab(tabLayout.newTab().setText(title));
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }
    override fun getItemPosition(`object`: Any): Int {
        val index = mFragmentList.indexOf(`object`)
        return if (index == -1) POSITION_NONE else index
    }


    fun removeView(pager: ViewPager, position: Int): Int {
       // pager.adapter = null
        mFragmentList.removeAt(position)
       // pager.adapter = this
        return position
    }
}