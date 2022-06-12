package com.example.msgphone

import android.app.Application
import android.content.Context
import com.netease.nimlib.sdk.NIMClient
import com.netease.yunxin.kit.alog.ALog
import com.netease.yunxin.kit.alog.BasicInfo
import com.netease.yunxin.kit.common.ui.CommonUIClient
import com.netease.yunxin.kit.contactkit.ui.userinfo.UserInfoActivity
import com.netease.yunxin.kit.corekit.im.XKitImClient
import com.netease.yunxin.kit.corekit.im.utils.RouterConstant.PATH_MINE_USER_INFO
import com.netease.yunxin.kit.corekit.route.XKitRouter.registerRouter


class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()


        // 在Application的onCreate中添加
        XKitImClient.setContext(this);
        var options = NimSDKOptionConfig.getSDKOptions(this, DataUtils.readAppKey(this));
        XKitImClient.config(null,options);

        CommonUIClient.init(this);
        initALog(this)
        // temp register for mine
        registerRouter(PATH_MINE_USER_INFO, UserInfoActivity::class.java)
        //set custom config for chat UI
        //set custom config for chat UI
        KitCustomConfig.initChatUICustom()
        //set custom config for contact ui
        KitCustomConfig.initContactUICustom();
    }

    //init log sdk
    private fun initALog(context: Context) {
        ALog.logFirst(
            BasicInfo.Builder()
                .packageName(context)
                .imVersion(NIMClient.getSDKVersion())
                .deviceId(context)
                .platform("Android")
                .name("XKit", true)
                .build()
        )
    }

}