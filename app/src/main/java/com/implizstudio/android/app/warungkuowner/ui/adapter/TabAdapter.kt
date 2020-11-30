package com.implizstudio.android.app.warungkuowner.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class TabAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val listFragment = arrayListOf<Fragment>()
    private val listTitle = arrayListOf<String>()

    override fun getCount() = listFragment.size

    override fun getItem(position: Int) = listFragment[position]

    override fun getPageTitle(position: Int) = listTitle[position]

    val set: (fragment: Fragment, title: String) -> Unit = { fragment, title ->
        listFragment.add(fragment)
        listTitle.add(title)
    }

}