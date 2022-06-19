package com.example.msgphone.portal.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.msgphone.R
import com.example.msgphone.portal.chat.ChatBoxAdapter
import kotlinx.android.synthetic.main.fragment_chat.view.*
import kotlinx.android.synthetic.main.fragment_contacts.view.*

class ContactsFragment(private val contactsList:ArrayList<Contacts>) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contacts, container, false)
//        val layoutManager = LinearLayoutManager(activity)
//        view.chat_Rv.layoutManager = layoutManager
//        val adapter = ContactsListAdapter(contactsList)
//        view.contacts_Rv.adapter = adapter
        return view
    }
}