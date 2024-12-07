package com.example.venndiagramgameapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.venndiagramgameapp.entities.ClassInformation

class UserViewModel() : ViewModel() {

    var menuSelectedOption: Int = 0

    var currentoption: ClassInformation? = null
}