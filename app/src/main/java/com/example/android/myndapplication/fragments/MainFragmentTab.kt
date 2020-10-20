package com.example.android.myndapplication.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.android.myndapplication.R
import com.example.android.myndapplication.adapter.TabAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.tabs.*

class MainFragmentTab : Fragment() {
    private var adapter: TabAdapter? = null
    private  val TAG = "MainFragmentTab"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.tabs, container, false)
        adapter = TabAdapter(fragmentManager)
        val viewPager = view.findViewById<View>(R.id.viewPager) as ViewPager
        val tabLayout = view.findViewById<View>(R.id.tabLayout) as TabLayout

        setViewPager(tabLayout, viewPager, arguments?.getString("title"))
        return view
    }

    private fun setViewPager(
        tabLayout: TabLayout,
        viewPager: ViewPager,
        string: String?
    ) {
        adapter?.apply {
            string.let {
                if (it != null) {
                    addFragment(
                        UserRecyclerFragment.newInstance(0),
                        it, tabLayout
                    )
                }
            }
            viewPager?.setAdapter(adapter)
            Log.d(TAG, "onCreateView: " + viewPager)
        }
        viewPager?.let {
            tabLayout?.setupWithViewPager(viewPager)
        }
    }

    fun removeTab(position: Int) {
        adapter?.removeView(viewPager,position)
        adapter?.notifyDataSetChanged()
    }

    fun addTabs(string: String) {
        adapter?.apply {
            string.let {
                if (it != null) {
                    addFragment(
                        UserRecyclerFragment.newInstance(0),
                        it, tabLayout
                    )
                }
            }
            viewPager?.setAdapter(adapter)
            Log.d(TAG, "onCreateView: " + viewPager)
        }
        adapter!!.notifyDataSetChanged()

    }
}