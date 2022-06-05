package com.example.msgphone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_portal.*

class PortalActivity : AppCompatActivity() {

    private val msgList = ArrayList<Msg>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portal)
        showChat()

        chatIcon_Iv.setOnClickListener {
            showChat()
        }

        contactsIcon_Iv.setOnClickListener {
            showContacts()
            title_Tv.text = "通讯录"
        }

        moreIcon_Iv.setOnClickListener {
            showMore()
            title_Tv.text = "发现"
        }

        meIcon_Iv.setOnClickListener {
            showMe()
            title_Tv.text = "我的"
        }

    }

    private fun showChat(){
        title_Tv.text = "消息"
        chatChosen_Iv.visibility = View.VISIBLE
        contactsChosen_Iv.visibility = View.INVISIBLE
        moreChosen_Iv.visibility = View.INVISIBLE
        meChosen_Iv.visibility = View.INVISIBLE
        chatChosen_Tv.visibility = View.VISIBLE
        contactsChosen_Tv.visibility = View.INVISIBLE
        moreChosen_Tv.visibility = View.INVISIBLE
        meChosen_Tv.visibility = View.INVISIBLE

        initMsg()
        replaceFragment(ChatFragment(msgList))
    }


    private fun initMsg(){
        msgList.add(Msg(R.drawable.profilepic2,"Olesia","Hello World!!!"))
        msgList.add(Msg(R.drawable.profilepic3,"Jocelyn","good night"))
    }

    private fun showContacts(){
        chatChosen_Iv.visibility = View.INVISIBLE
        contactsChosen_Iv.visibility = View.VISIBLE
        moreChosen_Iv.visibility = View.INVISIBLE
        meChosen_Iv.visibility = View.INVISIBLE
        chatChosen_Tv.visibility = View.INVISIBLE
        contactsChosen_Tv.visibility = View.VISIBLE
        moreChosen_Tv.visibility = View.INVISIBLE
        meChosen_Tv.visibility = View.INVISIBLE
        replaceFragment(ContactsFragment())
    }


    private fun showMore(){
        chatChosen_Iv.visibility = View.INVISIBLE
        contactsChosen_Iv.visibility = View.INVISIBLE
        moreChosen_Iv.visibility = View.VISIBLE
        meChosen_Iv.visibility = View.INVISIBLE
        chatChosen_Tv.visibility = View.INVISIBLE
        contactsChosen_Tv.visibility = View.INVISIBLE
        moreChosen_Tv.visibility = View.VISIBLE
        meChosen_Tv.visibility = View.INVISIBLE
    }

    private fun showMe(){
        title_Rl.visibility = View.GONE
        chatChosen_Iv.visibility = View.INVISIBLE
        contactsChosen_Iv.visibility = View.INVISIBLE
        moreChosen_Iv.visibility = View.INVISIBLE
        meChosen_Iv.visibility = View.VISIBLE
        chatChosen_Tv.visibility = View.INVISIBLE
        contactsChosen_Tv.visibility = View.INVISIBLE
        moreChosen_Tv.visibility = View.INVISIBLE
        meChosen_Tv.visibility = View.VISIBLE
        replaceFragment(MeFragment())
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.index_Fl,fragment)
//        transaction.addToBackStack(null)

        transaction.commit()
    }
}