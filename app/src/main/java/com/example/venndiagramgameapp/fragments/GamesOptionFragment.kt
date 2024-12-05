package com.example.venndiagramgameapp.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.venndiagramgameapp.ApiService
import com.example.venndiagramgameapp.ClassInformation
import com.example.venndiagramgameapp.R
import com.example.venndiagramgameapp.RetrofitClient
import com.example.venndiagramgameapp.adapters.ClassInformationAdapter
import com.example.venndiagramgameapp.databinding.FragmentGamesOptionBinding
import com.example.venndiagramgameapp.databinding.FragmentHomeBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GamesOptionFragment : Fragment() {

    private var _binding: FragmentGamesOptionBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGamesOptionBinding.inflate(inflater, container, false)
        val view = binding!!.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(requireActivity()) {
            findNavController().popBackStack()
        }

        val json = """
[
  {
    "id": "1",
    "title": "Introduction to Android Development",
    "description": "A beginner's course on Android app development using Kotlin."
  },
  {
    "id": "2",
    "title": "Mastering Java",
    "description": "An advanced course on Java programming for software engineers."
  },
  {
    "id": "3",
    "title": "Web Development Essentials",
    "description": "Learn the basics of HTML, CSS, and JavaScript to build websites."
  },
  {
    "id": "4",
    "title": "Data Science with Python",
    "description": "A comprehensive guide to data analysis and machine learning using Python."
  },
  {
    "id": "5",
    "title": "Digital Marketing 101",
    "description": "Understand the fundamentals of digital marketing and SEO."
  },
  {
    "id": "6",
    "title": "UI/UX Design Principles",
    "description": "Learn how to design user-friendly and visually appealing interfaces."
  },
  {
    "id": "7",
    "title": "Cybersecurity Basics",
    "description": "An introduction to cybersecurity concepts and practices."
  },
  {
    "id": "8",
    "title": "Cloud Computing Fundamentals",
    "description": "Explore the basics of cloud services and infrastructure."
  },
  {
    "id": "9",
    "title": "Mobile App Development",
    "description": "Create mobile apps using Flutter and Dart programming."
  },
  {
    "id": "10",
    "title": "Game Development with Unity",
    "description": "Build 2D and 3D games using the Unity engine."
  }
]
        """

        val personList = parseJson(json)

        val recyclerView: RecyclerView = binding!!.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        recyclerView.adapter = ClassInformationAdapter(personList)

    }

    fun parseJson(json: String): List<ClassInformation> {
        val gson = Gson()
        val itemType = object : TypeToken<List<ClassInformation>>() {}.type
        return gson.fromJson(json, itemType)
    }

}