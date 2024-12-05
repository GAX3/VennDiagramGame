package com.example.venndiagramgameapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.venndiagramgameapp.R
import com.example.venndiagramgameapp.databinding.FragmentGameBinding
import com.example.venndiagramgameapp.databinding.FragmentGamesOptionBinding

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding!!.root
        return view
    }

}