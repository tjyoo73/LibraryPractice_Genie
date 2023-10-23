package com.tjlab.librarypractice_genie

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermissionActivity
import com.gun0912.tedpermission.normal.TedPermission
import com.tjlab.librarypractice_genie.databinding.ActivityMainBinding
import java.security.Permission

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.profileImage.setOnClickListener {
            val myIntent = Intent(this, ViewProfilePhotoActivity::class.java)
            startActivity(myIntent)
        }

        Glide.with(this).load("https://s3.orbi.kr/data/file/united2/7559d4b48ce54f7dba55d2006a53851d.png").into(binding.lectureImg1)

        binding.callBtn.setOnClickListener {
            val permissionlistener = object : PermissionListener {
                override fun onPermissionGranted() {
                    val myUri = Uri.parse("tel:010-2222-3333")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }
                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(this@MainActivity, "권한이 없어서 전화 연결에 싶패했습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            TedPermission.create()
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("전화 연결 권한이 필요합니다. [설정] 에서 진행해 주세요.")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()
        }
    }
}