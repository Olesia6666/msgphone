package com.example.msgphone.portal.me

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import com.example.msgphone.R
import com.netease.yunxin.kit.common.utils.storage.RealPathUtil
import kotlinx.android.synthetic.main.activity_user_info.*

class UserInfoActivity : AppCompatActivity() {

    var realPathFromUri:String? = null
    var photo:Bitmap? = null
    var imageUri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        back_Iv.setOnClickListener {
            finish()
        }

        userNameNext_Iv.setOnClickListener {
            Toast.makeText(this, "无法修改姓名", Toast.LENGTH_SHORT).show()
        }
        userIdNext_Iv.setOnClickListener {
            Toast.makeText(this, "无法修改学号", Toast.LENGTH_SHORT).show()
        }
        userClassNext_Iv.setOnClickListener {
            Toast.makeText(this, "无法修改班级", Toast.LENGTH_SHORT).show()
        }

        userAvatarNext_Iv.setOnClickListener {
            openAlbum()
        }

    }

    private fun openAlbum() {
        val intent = Intent()
        intent.action = Intent.ACTION_GET_CONTENT
        intent.type = "image/*"
        startActivityForResult(intent,111)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode){
            111 -> {
                imageUri = data?.data
                realPathFromUri = RealPathUtil.getRealPath(data!!.data)
                photo = MediaStore.Images.Media.getBitmap(this.getContentResolver(),imageUri)
//                userAvatar_Iv.setImageResource(photo)
            }
        }
    }
}