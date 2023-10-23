package com.tjlab.librarypractice_genie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tjlab.librarypractice_genie.databinding.ActivityMainBinding

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
    }
}