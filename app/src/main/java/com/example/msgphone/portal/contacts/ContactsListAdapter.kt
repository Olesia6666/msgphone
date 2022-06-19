package com.example.msgphone.portal.contacts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.msgphone.R
import com.example.msgphone.portal.chat.Msg
import kotlinx.android.synthetic.main.activity_user_info.view.*
import kotlinx.android.synthetic.main.recycleview_card.view.*

class ContactsListAdapter(private val contactsList: ArrayList<Contacts>) : RecyclerView.Adapter<ContactsListAdapter.ViewHolder>() {
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val avatar = view.contactsAvatar_Cv
        val name = view.contactsName_Tv
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ContactsListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycleview_card,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactsListAdapter.ViewHolder, position: Int) {
        val contactsList = contactsList[position]
        holder.avatar.setImageResource(contactsList.avatar)
        holder.name.text = contactsList.name
    }

    override fun getItemCount() = 1
}