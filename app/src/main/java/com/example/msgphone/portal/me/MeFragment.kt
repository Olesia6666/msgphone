package com.example.msgphone.portal.me

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.msgphone.R
import com.example.msgphone.portal.PortalActivity
import kotlinx.android.synthetic.main.fragment_me.*
import kotlinx.android.synthetic.main.fragment_me.view.*

class MeFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_me, container, false)
        view.update_Tv.setOnClickListener {
            Toast.makeText(context, "当前已为最新版本", Toast.LENGTH_SHORT).show()
        }
        view.profile_Tv.setOnClickListener{
            val intent = Intent(activity,UserInfoActivity::class.java)
            startActivity(intent)
        }
        return view

    }


}