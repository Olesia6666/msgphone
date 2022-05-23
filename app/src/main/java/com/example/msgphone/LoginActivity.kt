package com.example.msgphone

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
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
            val intentLogin = Intent(this,PortalActivity::class.java)
            startActivity(intentLogin)
        }

        //点击注册按钮跳转到注册页面
        Register_Btn.setOnClickListener {
            val intentRegister = Intent(this,RegisterActivity::class.java)
            startActivity(intentRegister)
        }

    }





}