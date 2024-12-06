package com.example.venndiagramgameapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.venndiagramgameapp.databinding.ActivityMainBinding
import com.example.venndiagramgameapp.entities.ClassInformation

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var currentOption: ClassInformation? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}