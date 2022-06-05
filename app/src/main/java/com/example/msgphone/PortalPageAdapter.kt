package com.example.msgphone

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class PortalPageAdapter(val list: IntArray): PagerAdapter(){
    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0 == p1
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return super.instantiateItem(container, position)
    }
}