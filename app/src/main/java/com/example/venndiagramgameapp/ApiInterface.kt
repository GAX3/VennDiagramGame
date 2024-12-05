package com.example.venndiagramgameapp

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    suspend fun getUser(): ClassInformation
}
