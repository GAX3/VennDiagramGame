package com.example.venndiagramgameapp.fragments.partOne

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.venndiagramgameapp.entities.ClassInformation
import com.example.venndiagramgameapp.R
import com.example.venndiagramgameapp.adapters.ClassInformationAdapter
import com.example.venndiagramgameapp.databinding.FragmentGamesOptionBinding
import com.example.venndiagramgameapp.viewmodel.UserViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GamesOptionFragment : Fragment(), ClassInformationAdapter.OnCardClickListener {

    private var _binding: FragmentGamesOptionBinding? = null
    private val binding get() = _binding

    private val viewModel: UserViewModel by activityViewModels()

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
    "description": "A beginner's course on Android app development using Kotlin.",
    "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/ProfilePics/01.PNG"
  },
  {
    "id": "2",
    "title": "Mastering Java",
    "description": "An advanced course on Java programming for software engineers.",
    "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/ProfilePics/01.PNG"
  },
  {
    "id": "3",
    "title": "Web Development Essentials",
    "description": "Learn the basics of HTML, CSS, and JavaScript to build websites.",
    "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/ProfilePics/01.PNG"
  }
]
        """

        val personList = parseJson(json)

        val recyclerView: RecyclerView = binding!!.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        recyclerView.adapter = ClassInformationAdapter(personList, this)

    }

    override fun onCardClick(item: ClassInformation) {
        viewModel.currentoption = ClassInformation(item.id, item.title, item.description, item.imgLink)
        findNavController().navigate(R.id.conjuctDetailFragment)
    }

    fun parseJson(json: String): List<ClassInformation> {
        val gson = Gson()
        val itemType = object : TypeToken<List<ClassInformation>>() {}.type
        return gson.fromJson(json, itemType)
    }

}