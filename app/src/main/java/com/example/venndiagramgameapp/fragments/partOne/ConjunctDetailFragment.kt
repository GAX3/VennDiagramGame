package com.example.venndiagramgameapp.fragments.partOne

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.venndiagramgameapp.databinding.FragmentConjuntoDetailBinding
import com.example.venndiagramgameapp.viewmodel.UserViewModel

class ConjunctDetailFragment : Fragment() {

    private var _binding: FragmentConjuntoDetailBinding? = null
    private val binding get() = _binding

    private val viewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConjuntoDetailBinding.inflate(inflater, container, false)
        val view = binding!!.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
    }

    private fun setData() {
        Glide.with(requireActivity())
            .load(viewModel.currentoption!!.imgLink)
            .into(binding!!.imageView)

        binding!!.titleTextView.text = viewModel.currentoption!!.title!!
        binding!!.descriptionTextView.text = viewModel.currentoption!!.title!!
    }

}