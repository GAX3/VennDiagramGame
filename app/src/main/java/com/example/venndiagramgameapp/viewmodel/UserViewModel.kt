package com.example.venndiagramgameapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.venndiagramgameapp.ClassInformation

class UserViewModel() : ViewModel() {

    var currentUser: String = ""

    var currentoption: ClassInformation? = null
}