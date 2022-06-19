package com.example.msgphone.portal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.msgphone.*
import com.example.msgphone.portal.chat.ChatFragment
import com.example.msgphone.portal.chat.Msg
import com.example.msgphone.portal.contacts.Contacts
import com.example.msgphone.portal.contacts.ContactsFragment
import com.example.msgphone.portal.group.GroupFragment
import com.example.msgphone.portal.me.MeFragment
import kotlinx.android.synthetic.main.activity_portal.*
import kotlinx.android.synthetic.main.fragment_me.*

class PortalActivity : AppCompatActivity() {

    private val msgList = ArrayList<Msg>()
    private val contactsList = ArrayList<Contacts>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portal)
        initMsg()
        initContacts()
        showChat()

        chatIcon_Iv.setOnClickListener {
            showChat()
        }

        contactsIcon_Iv.setOnClickListener {
            showContacts()
            title_Tv.text = "通讯录"
        }

        index_Iv.setOnClickListener {
            showIndex()
            title_Tv.text = "主页"
        }

        groupIcon_Iv.setOnClickListener {
            showGroup()
            title_Rl.visibility = View.GONE
        }

        meIcon_Iv.setOnClickListener {
            showMe()
            title_Tv.text = "我的"
        }

    }

    private fun showIndex() {
        chatChosen_Iv.visibility = View.INVISIBLE
        contactsChosen_Iv.visibility = View.INVISIBLE
        indexChosen_Iv.visibility = View.VISIBLE
        groupChosen_Iv.visibility = View.INVISIBLE
        meChosen_Iv.visibility = View.INVISIBLE
        chatChosen_Tv.visibility = View.INVISIBLE
        contactsChosen_Tv.visibility = View.INVISIBLE
        indexChosen_Tv.visibility = View.VISIBLE
        groupChosen_Tv.visibility = View.INVISIBLE
        meChosen_Tv.visibility = View.INVISIBLE


        //TODO replaceFragment(IndexFragment())
    }

    private fun showChat(){
        title_Tv.text = "消息"
        chatChosen_Iv.visibility = View.VISIBLE
        contactsChosen_Iv.visibility = View.INVISIBLE
        indexChosen_Iv.visibility = View.INVISIBLE
        groupChosen_Iv.visibility = View.INVISIBLE
        meChosen_Iv.visibility = View.INVISIBLE
        chatChosen_Tv.visibility = View.VISIBLE
        contactsChosen_Tv.visibility = View.INVISIBLE
        indexChosen_Tv.visibility = View.INVISIBLE
        groupChosen_Tv.visibility = View.INVISIBLE
        meChosen_Tv.visibility = View.INVISIBLE

        replaceFragment(ChatFragment(msgList))
    }


    private fun initMsg(){
        msgList.add(Msg(R.drawable.profilepic2,"叶子穆",""))
//        msgList.add(Msg(R.mipmap.pic1,"汪洪泽",""))
    }
    private fun initContacts(){
        contactsList.add(Contacts(R.drawable.profilepic2,"叶子穆"))
//        msgList.add(Msg(R.mipmap.pic1,"汪洪泽",""))
    }

    private fun showContacts(){
        chatChosen_Iv.visibility = View.INVISIBLE
        contactsChosen_Iv.visibility = View.VISIBLE
        indexChosen_Iv.visibility = View.INVISIBLE
        groupChosen_Iv.visibility = View.INVISIBLE
        meChosen_Iv.visibility = View.INVISIBLE
        chatChosen_Tv.visibility = View.INVISIBLE
        contactsChosen_Tv.visibility = View.VISIBLE
        indexChosen_Tv.visibility = View.INVISIBLE
        groupChosen_Tv.visibility = View.INVISIBLE
        meChosen_Tv.visibility = View.INVISIBLE
        replaceFragment(ContactsFragment(contactsList))
    }


    private fun showGroup(){
        chatChosen_Iv.visibility = View.INVISIBLE
        contactsChosen_Iv.visibility = View.INVISIBLE
        indexChosen_Iv.visibility = View.INVISIBLE
        groupChosen_Iv.visibility = View.VISIBLE
        meChosen_Iv.visibility = View.INVISIBLE
        chatChosen_Tv.visibility = View.INVISIBLE
        contactsChosen_Tv.visibility = View.INVISIBLE
        indexChosen_Tv.visibility = View.INVISIBLE
        groupChosen_Tv.visibility = View.VISIBLE
        meChosen_Tv.visibility = View.INVISIBLE
        replaceFragment(GroupFragment())
    }

    private fun showMe(){
        title_Rl.visibility = View.GONE
        chatChosen_Iv.visibility = View.INVISIBLE
        contactsChosen_Iv.visibility = View.INVISIBLE
        indexChosen_Iv.visibility = View.INVISIBLE
        groupChosen_Iv.visibility = View.INVISIBLE
        meChosen_Iv.visibility = View.VISIBLE
        chatChosen_Tv.visibility = View.INVISIBLE
        contactsChosen_Tv.visibility = View.INVISIBLE
        indexChosen_Tv.visibility = View.INVISIBLE
        groupChosen_Tv.visibility = View.INVISIBLE
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