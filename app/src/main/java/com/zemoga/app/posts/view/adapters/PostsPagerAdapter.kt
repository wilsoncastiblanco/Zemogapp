package com.zemoga.app.posts.view.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.zemoga.app.posts.view.PostsFragment

/**
 * Created by wilsoncastiblanco on 5/29/18.
 */
class PostsPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    private val titles = arrayOf("ALL", "FAVORITES")

    override fun getCount(): Int {
        return titles.size
    }

    override fun getItem(position: Int): Fragment {
        return PostsFragment.newInstance(position + 1)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}