package com.example.msgphone

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.AccDelete_Iv

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        //输入内容时显示Delete按钮
        Username_Et.doAfterTextChanged {
            val s : String = it.toString()+""
            if (s.isNotEmpty()){
                UsernameDelete_Iv.visibility = View.VISIBLE
            }else{
                UsernameDelete_Iv.visibility = View.GONE
            }
        }

        Account_Et.doAfterTextChanged {
            val s : String = it.toString()
            if (s.isNotEmpty()){
                AccDelete_Iv.visibility = View.VISIBLE
            }else{
                AccDelete_Iv.visibility = View.GONE
            }
        }

        Pwd_Et.doAfterTextChanged {
            val s : String = it.toString()+""
            if (s.isNotEmpty()){
                PasswordDelete_Iv.visibility = View.VISIBLE
            }else{
                PasswordDelete_Iv.visibility = View.GONE
            }
        }

        //二次密码判断是否相同
        RePassword_Et.doAfterTextChanged {
            val s : String = it.toString()
            if (s.isNotEmpty()){
                RePwdDelete_Iv.visibility = View.VISIBLE
                if(s.equals(Pwd_Et.text.toString())){
                    error_Tv.visibility = View.INVISIBLE
                }else{
                    error_Tv.visibility = View.VISIBLE
                }
            }else{
                RePwdDelete_Iv.visibility = View.GONE
            }

        }

        //TODO 点击EditText外部失去焦点

        //Delete按钮点击事件
        UsernameDelete_Iv.setOnClickListener {
            Username_Et.setText("")
        }

        AccDelete_Iv.setOnClickListener {
            Account_Et.setText("")
        }

        PasswordDelete_Iv.setOnClickListener {
            Pwd_Et.setText("")
        }

        RePwdDelete_Iv.setOnClickListener {
            RePassword_Et.setText("")
        }

        //提交注册信息，信息存入数据库，提示注册成功，返回首页
        val dbHelper = UserDatabaseHelper(this,"user.db",1)
        Submit_Btn.setOnClickListener {
            //其他功能测试时暂时隐藏
//            val db = dbHelper.writableDatabase
//            val values = ContentValues()
//            val username = Username_Et.text.toString()
//            val account = Account_Et.text.toString()
//            val password = Password_Et.text.toString()
//            if(username != null &&
//                    account != null &&
//                    password != null &&
//                    error_Tv.visibility == View.GONE){
//                values.apply {
//                    put("username","${username}")
//                    put("account","${account}")
//                    put("password","${password}")
//                }
//                db.insert("User",null,values)

                Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show()
                finish()
//            }else{
//                Toast.makeText(this,"请输入个人信息",Toast.LENGTH_SHORT).show()
//            }

        }


    }
}