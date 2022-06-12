package com.example.msgphone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import com.netease.yunxin.kit.corekit.im.model.UserInfo
import com.netease.yunxin.kit.corekit.im.utils.RouterConstant.CHAT_KRY
import com.netease.yunxin.kit.corekit.im.utils.RouterConstant.PATH_CHAT_P2P
import com.netease.yunxin.kit.corekit.route.XKitRouter.withKey

import kotlinx.android.synthetic.main.fragment_chat.view.*


class ChatFragment(private val msgList:ArrayList<Msg>) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat, container, false)
        val layoutManager = LinearLayoutManager(activity)
        /**
         *   这里需要传 UserInfo 对象过来处理
         */
        val userInfo :UserInfo = UserInfo("123456","超出滴滴","123456");
        view.chat_Rv.layoutManager = layoutManager
        val adapter = ChatBoxAdapter(msgList)
        adapter.setMyListener ( object: ChatBoxAdapter.OnItemClickListener {
            override fun onItemClick(pos: Int) {

                activity?.let {
                    withKey(PATH_CHAT_P2P).withParam(CHAT_KRY, userInfo)
                        .withContext(it).navigate()
                }

            }
        })

        view.chat_Rv.adapter = adapter
        return view
    }

}