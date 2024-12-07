package com.example.venndiagramgameapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.venndiagramgameapp.R
import com.example.venndiagramgameapp.adapters.MenuOptionsAdapter
import com.example.venndiagramgameapp.databinding.FragmentGamesOptionBinding
import com.example.venndiagramgameapp.databinding.FragmentHomeBinding
import com.example.venndiagramgameapp.entities.MenuOption
import com.example.venndiagramgameapp.viewmodel.UserViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HomeFragment : Fragment(), MenuOptionsAdapter.OnCardClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding

    private val viewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding!!.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(requireActivity()) {
            requireActivity().finish()
        }

        val json = """
[
  {
    "id": "1",
    "title": "Conjunto definiciones",
    "description": "Teoría de conjuntos, Notación, Relación de pertenencia, Determinación de conjuntos, Representación de conjuntos en diagrama de Venn.",
    "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/VennDiagram/Menu/Slide1.gif"
  },
  {
    "id": "2",
    "title": "Tipo de conjuntos",
    "description": "Clase de conjuntos especiales: vacío, unitario, infinito, universal; Relaciones entre conjuntos, Igualdad de conjuntos, Conjunto potencia, Conjunto Númerico.",
    "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/VennDiagram/Menu/Slide2.gif"
  },
  {
    "id": "3",
    "title": "Operaciones con conjuntos",
    "description": "Unión, Intersección, Diferencia, Complemento.",
    "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/VennDiagram/Menu/Slide3.jpg"
  },
  {
    "id": "4",
    "title": "Juegos Diagrama de Venn",
    "description": "Juegos lúdicos aplicando los Diagramas de Venn.",
    "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/VennDiagram/Menu/Slide4.gif"
  }
]
        """

        val personList = parseJson(json)

        val recyclerView: RecyclerView = binding!!.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        recyclerView.adapter = MenuOptionsAdapter(personList, this)

    }

    override fun onCardClick(item: MenuOption) {
        viewModel.menuSelectedOption = item.id
        findNavController().navigate(R.id.action_homeFragment_to_gameOptionsFragment)
    }

    fun parseJson(json: String): List<MenuOption> {
        val gson = Gson()
        val itemType = object : TypeToken<List<MenuOption>>() {}.type
        return gson.fromJson(json, itemType)
    }

}