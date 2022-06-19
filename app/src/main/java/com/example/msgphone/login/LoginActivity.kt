package com.example.msgphone.login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.msgphone.R
import com.example.msgphone.portal.PortalActivity
import com.netease.nimlib.sdk.NIMClient
import com.netease.nimlib.sdk.RequestCallback
import com.netease.nimlib.sdk.auth.AuthService
import com.netease.nimlib.sdk.auth.LoginInfo
import com.netease.yunxin.kit.alog.ALog
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //输入内容时显示Delete按钮
        Acc_Et.doAfterTextChanged {
            val s : String = it.toString()+""
            if (s.isNotEmpty()){
                AccDelete_Iv.visibility = View.VISIBLE
            }else{
                AccDelete_Iv.visibility = View.GONE
            }
        }

        Password_Et.doAfterTextChanged {
            val s : String = it.toString()+""
            if (s.isNotEmpty()){
                PwdDelete_Iv.visibility = View.VISIBLE
            }else{
                PwdDelete_Iv.visibility = View.GONE
            }
        }

        //失去焦点后Delete按钮消失
        Acc_Et.setOnFocusChangeListener { view, isfocus->
            if (isfocus){
            }else{
                AccDelete_Iv.visibility = View.GONE
            }
        }
        Password_Et.setOnFocusChangeListener { view, isfocus ->
            if(isfocus){
            }else{
                PwdDelete_Iv.visibility = View.GONE
            }
        }
        //TODO 点击EditText外部失去焦点

        //Delete按钮点击事件
        AccDelete_Iv.setOnClickListener {
            Acc_Et.setText("")
        }

        PwdDelete_Iv.setOnClickListener {
            Password_Et.setText("")
        }

        //TODO 点击登陆按钮查询数据库中是否存在该用户并判断能否登陆
        Login_Btn.setOnClickListener {
//            val intentLogin = Intent(this,PortalActivity::class.java)
//            startActivity(intentLogin)
//            startLogin()
            login()
        }

        //点击注册按钮跳转到注册页面
        Register_Btn.setOnClickListener {
            val intentRegister = Intent(this, RegisterActivity::class.java)
            startActivity(intentRegister)
        }

    }

    private fun login(){
        val info = LoginInfo(Acc_Et.text.toString(),Password_Et.text.toString())
        val callback: RequestCallback<LoginInfo> = object : RequestCallback<LoginInfo> {
            override fun onSuccess(param: LoginInfo?) {
                ALog.i("112", "login success")
                // your code

                Toast.makeText(this@LoginActivity, "登录成功~", Toast.LENGTH_SHORT).show()
                //  SendImage();
//                val editor: SharedPreferences.Editor = sharedPreferences.edit()
//                editor.putString("username", etUsername.getText().toString())
//                editor.putString("password", etPassword.getText().toString())
//                editor.apply()
//                val server = Intent(this@MainActivity, IMService::class.java)
//                startService(server)
                val intent = Intent(this@LoginActivity, PortalActivity::class.java)
                startActivity(intent)
            }

            override fun onFailed(code: Int) {
                if (code == 302) {
                    ALog.e("failed", "账号密码错误")
                    // your code
                    Toast.makeText(this@LoginActivity, "密码错误请重试~", Toast.LENGTH_SHORT).show()
                } else {
                }
            }

            override fun onException(exception: Throwable) {
                Toast.makeText(this@LoginActivity, "外星电波干扰了服务器QAQ", Toast.LENGTH_SHORT).show()
            }
        }
        //执行手动登录
        NIMClient.getService(AuthService::class.java).login(info).setCallback(callback)
        // }
    }

}


    private fun startLogin() {
//        val loginInfo = LoginInfo.LoginInfoBuilder.loginInfoDefault("account", "token")
//            .withAppKey(DataUtils.readAppKey(this)).build()
//        loginIM(loginInfo)
    }

//    private fun loginIM(loginInfo: LoginInfo) {
//        XKitImClient.loginIMWithQChat(loginInfo, object : LoginCallback<QChatLoginResult> {
//            override fun onError(errorCode: Int, errorMsg: String) {
//                launchLoginPage()
//            }
//
//            override fun onSuccess(data: QChatLoginResult?) {
////                viewModel.updateNotificationConfig()
//                showMainActivityAndFinish()
//            }
//        })
//    }

//    private fun launchLoginPage() {
//        val intent = Intent(this,LoginActivity::class.java)
//        startActivity(intent)
//    }


//
//    private fun showMainActivityAndFinish() {
//        finish()
//        val intent = Intent()
//        intent.setClass(this, PortalActivity::class.java)
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
//        this.startActivity(intent)
//    }


