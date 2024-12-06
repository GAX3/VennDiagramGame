package com.example.venndiagramgameapp

import com.example.venndiagramgameapp.entities.ClassInformation

interface ApiService {

    suspend fun getUser(): ClassInformation
}
