package com.example.venndiagramgameapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.venndiagramgameapp.R
import com.example.venndiagramgameapp.databinding.FragmentHomeBinding
import com.example.venndiagramgameapp.viewmodel.UserViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy { UserViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGame.setOnClickListener {
            view.findNavController().navigate(R.id.gameOptionsFragment)
        }

        viewModel.currentUser = "XD"

        Glide.with(this)
            .asGif()
            .load("https://cdn.pixabay.com/animation/2024/02/17/02/20/02-20-10-821_512.gif") // Replace with your GIF URL or local resource
            .into(binding.gifImageView)

    }

}