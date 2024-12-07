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

        var json = ""

        val json1 = """
[
  {
    "id": "1",
    "title": "Teoría de conjuntos",
    "description": "Es una rama fundamental de la matemática que estudia los conjuntos, es decir, colecciones de objetos. Es una teoría que proporciona las bases para la formulación rigurosa de las\nmatemáticas y se utiliza como fundamento de muchas áreas, como la aritmética, la\ngeometría, la lógica, y más",
    "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/ProfilePics/01.PNG"
  },
  {
    "id": "2",
    "title": "Notación",
    "description": "Es el conjunto de símbolos y convenciones que se utilizan para representar matemáticamente a los conjuntos y las operaciones que realizan sobre ellos. La notación proporciona una manera estandarizada de expresar ideas matemáticas y facilita la\ncomprensión de los conceptos y procedimientos relacionados con los conjuntos.",
    "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/ProfilePics/01.PNG"
  },
  {
    "id": "3",
    "title": "Relación de pertenencia",
    "description": "Este establece que un elemento pertenece o no pertenece a un conjunto. Se denota por el símbolo ∈ para indicar que un elemento está en un conjunto, y ∉ para indicar que un elemento no está en un conjunto.",
    "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/ProfilePics/01.PNG"
  },
  {
    "id": "4",
    "title": "Determinación de conjuntos",
    "description": "La determinación de un conjunto implica especificar qué elementos lo conforman. Esto\npuede hacerse de varias maneras:\n• Por extensión: Se enumeran explícitamente los elementos del conjunto.\nEjemplo: A={2,4,6}, donde los elementos del conjunto son 2, 4 y 6.\n• Por comprensión: Se define el conjunto mediante una propiedad o condición que\ndeben satisfacer sus elementos.\nEjemplo: B={x ∣ x es un número par mayor que 1} que describe el conjunto de todos los\nnúmeros pares mayores que 1.\nLa determinación de un conjunto puede hacerse de manera finita o infinita, dependiendo de\nla cantidad de elementos que contenga.\n",
    "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/ProfilePics/01.PNG"
  },
    {
    "id": "5",
    "title": "Representación de conjuntos de diagrama de venn",
    "description": "Un conjunto se representa por un círculo. Los elementos dentro del círculo corresponden a los elementos de ese conjunto.",
    "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/ProfilePics/01.PNG"
  }
]
        """

        val json2 = """
            
            
        """.trimIndent()
        val json3 = """        
            [
            {
                "id": "1",
                "title": "Unión",
                "description": "Se obtiene el conjunto de todos los elementos de los conjuntos dados.",
                "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/ProfilePics/01.PNG"
            },
            {
                "id": "2",
                "title": "Intersección",
                "description": "Se obtiene el conjunto de elementos que dos conjuntos tienen en común.",
                "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/ProfilePics/01.PNG"
            },
            {
                "id": "3",
                "title": "Diferencia",
                "description": "Se obtiene el conjunto de elementos de un conjunto que no están presentes en otro.",
                "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/ProfilePics/01.PNG"
            },
            {
                "id": "4",
                "title": "Complemento",
                "description": "Se obtiene el conjunto de elementos que no están presentes en un conjunto y que están presentes en otro",
                "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/ProfilePics/01.PNG"
            }
        ]""".trimIndent()
        val json4 = ""




        when(viewModel.menuSelectedOption){
            1->{json = json1}
            2->{json = json2}
            3->{json = json3}
            4->{json = json4}
            else->{}
        }


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