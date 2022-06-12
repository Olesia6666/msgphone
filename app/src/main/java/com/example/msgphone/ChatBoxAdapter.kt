package com.example.msgphone

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatBoxAdapter(private val msgList: ArrayList<Msg>): RecyclerView.Adapter<ChatBoxAdapter.ViewHolder>() {
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val msg_name : TextView = view.findViewById(R.id.msgName_Tv)
        val msg : TextView = view.findViewById(R.id.msg_Tv)
        val profile_pic: ImageView = view.findViewById(R.id.profilePic_Iv)
    }
    var listener: OnItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycleview_chatbox ,parent,false)
        val holder = ViewHolder(view)

        return holder
    }

    override fun getItemCount() = msgList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val msgList = msgList[position]
        holder.msg_name.text = msgList.msgName
        holder.msg.text = msgList.msg
        holder.profile_pic.setImageResource(msgList.profilePic)

        holder.itemView.setOnClickListener {
            listener?.onItemClick(position)
        }
    }
    interface OnItemClickListener {
        fun onItemClick(pos: Int)
    }


    fun setMyListener(listener:OnItemClickListener){
        this.listener = listener
    }
}