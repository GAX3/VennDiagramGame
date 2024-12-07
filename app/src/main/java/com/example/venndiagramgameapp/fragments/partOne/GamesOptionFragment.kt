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
    "description": "Es una rama fundamental de la matemática que estudia los conjuntos, es decir, colecciones de objetos. \n\nEs una teoría que proporciona las bases para la formulación rigurosa de las\nmatemáticas y se utiliza como fundamento de muchas áreas, como la aritmética, la\ngeometría, la lógica, y más",
    "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/VennDiagram/Definiciones/01.jpg"
  },
  {
    "id": "2",
    "title": "Notación",
    "description": "Es el conjunto de símbolos y convenciones que se utilizan para representar matemáticamente a los conjuntos y las operaciones que realizan sobre ellos. \n\nLa notación proporciona una manera estandarizada de expresar ideas matemáticas y facilita la comprensión de los conceptos y procedimientos relacionados con los conjuntos.",
    "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/VennDiagram/Definiciones/02.jpg"
  },
  {
    "id": "3",
    "title": "Relación de pertenencia",
    "description": "Este establece que un elemento pertenece o no pertenece a un conjunto.\n\nSe denota por el símbolo ∈ para indicar que un elemento está en un conjunto, y ∉ para indicar que un elemento no está en un conjunto.",
    "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/VennDiagram/Definiciones/03.jpg"
  },
  {
    "id": "4",
    "title": "Determinación de conjuntos",
    "description": "La determinación de un conjunto implica especificar qué elementos lo conforman. \n\nEsto puede hacerse de varias maneras:\n\n• Por extensión: Se enumeran explícitamente los elementos del conjunto.\nEjemplo: A={2,4,6}, donde los elementos del conjunto son 2, 4 y 6.\n\n• Por comprensión: Se define el conjunto mediante una propiedad o condición que\ndeben satisfacer sus elementos.\nEjemplo: B={x ∣ x es un número par mayor que 1} que describe el conjunto de todos los\nnúmeros pares mayores que 1.\nLa determinación de un conjunto puede hacerse de manera finita o infinita, dependiendo de\nla cantidad de elementos que contenga.\n",
    "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/VennDiagram/Definiciones/04.jpg"
  },
    {
    "id": "5",
    "title": "Representación de conjuntos de diagrama de venn",
    "description": "Un conjunto se representa por un círculo. Los elementos dentro del círculo corresponden a los elementos de ese conjunto.",
    "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/VennDiagram/Definiciones/05.png"
  }
]
        """

        val json2 = """
            [
              {
                "id": "1",
                "title": "Conjunto vacío",
                "description": "El conjunto vacío es un conjunto que no contiene ningún elemento. Se denota por ∅ o {}.\n\nEl conjunto vacío es un subconjunto de cualquier conjunto, y tiene la propiedad de que su\ncardinalidad (número de elementos) es igual a cero.",
                "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/VennDiagram/Tipos/01.jpg"
              },
              {
                "id": "2",
                "title": "Conjunto unitario",
                "description": "Un conjunto unitario es un conjunto que contiene exactamente un elemento. \n\nSu cardinalidad es 1. Se denomina unitario porque tiene solo una unidad, es decir, un único miembro.",
                "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/VennDiagram/Tipos/02.jpg"
              },
              {
                "id": "3",
                "title": "Conjunto infinito",
                "description": "Un conjunto infinito es aquel que tiene infinitos elementos, es decir, no tiene un número limitado de elementos.\n\nUn conjunto infinito no puede enumerarse completamente, ya que sus elementos siguen sin fin. Los conjuntos infinitos pueden ser numerables (como el conjunto de los números naturales) o no numerables (como el conjunto de los númerosreales).",
                "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/VennDiagram/Tipos/03.jpg"
              },
              {
                "id": "4",
                "title": "Conjunto universal",
                "description": "El conjunto universal es el conjunto que contiene todos los elementos bajo consideración en un contexto determinado. \n\nEs el conjunto que incluye a todos los elementos de todos los conjuntos de un determinado problema. Se denota comúnmente por U o ξ.",
                "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/VennDiagram/Tipos/04.jpg"
              },
              {
                "id": "5",
                "title": "Igualdad de conjuntos",
                "description": "Dos conjuntos A y B son iguales si y solo si contienen los mismos elementos, es decir, A – B si y solo si para cada x, x ∈ A.\n\nEl orden de los elementos no importa en la igualdad de conjuntos,ni la repetición de los elementos.",
                "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/VennDiagram/Tipos/05.png"
              },
              {
                "id": "6",
                "title": "Conjunto de potencia",
                "description": "El conjunto potencia de un conjunto es otro conjunto formado por todos los subconjuntos del conjunto dado1. \n\nEs decir, el conjunto potencia de un conjunto es el conjunto de todos los subconjuntos de ese conjunto",
                "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/VennDiagram/Tipos/06.jpg"
              },
              {
                "id": "7",
                "title": "Conjuntos numéricos",
                "description": "Los conjuntos numéricos son las categorías en las que se clasifican los números, en función de sus diferentes características. \n\nLos conjuntos numéricos se utilizan para separar los números en distintas clases que tienen propiedades similares. Algunos ejemplos de conjuntos numéricos son los números naturales, los números enteros y los números racionales o fraccionarios. \n\nEl conjunto de los números naturales está formado por: N= {0, 1,2, 3, 4, 5, 6, 7, 8, 9,...}",
                "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/VennDiagram/Tipos/07.jpg"
              }
            ]
        """.trimIndent()

        val json3 = """        
            [
            {
                "id": "1",
                "title": "Unión",
                "description": "Cada círculo o elipse representa una categoría. La unión de dos conjuntos está representada por ∪. \n\nEste es un diagrama de Venn de dos círculos. \n\nEl círculo verde es A y el círculo azul es B.git s\n\nEl diagrama de Venn completo representa la unión de A y B, o bien, A ∪ B.",
                "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/VennDiagram/Juego/01.png"
            },
            {
                "id": "2",
                "title": "Intersección",
                "description": "Se obtiene el conjunto de elementos que dos conjuntos tienen en común.",
                "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/VennDiagram/Juego/02.png"
            },
            {
                "id": "3",
                "title": "Diferencia",
                "description": "Se obtiene el conjunto de elementos de un conjunto que no están presentes en otro.",
                "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/VennDiagram/Juego/03.png"
            },
            {
                "id": "4",
                "title": "Complemento",
                "description": "Se obtiene el conjunto de elementos que no están presentes en un conjunto y que están presentes en otro",
                "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/VennDiagram/Juego/04.png"
            }
        ]""".trimIndent()
        val json4 = """        
            [
            {
                "id": "1",
                "title": "Unión",
                "description": "",
                "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/VennDiagram/Juego/01.png"
            },
            {
                "id": "2",
                "title": "Intersección",
                "description": "",
                "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/VennDiagram/Juego/02.png"
            },
            {
                "id": "3",
                "title": "Diferencia",
                "description": "",
                "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/VennDiagram/Juego/03.png"
            },
            {
                "id": "4",
                "title": "Complemento",
                "description": "",
                "imgLink": "https://raw.githubusercontent.com/GAX3/assets/refs/heads/main/VennDiagram/Juego/04.png"
            }
        ]""".trimIndent()




        when(viewModel.menuSelectedOption){
            1->{json = json1
                binding!!.txtHome.text = "Conjunto definiciones"
            }
            2->{json = json2
                binding!!.txtHome.text = "Clases de conjuntos especiales"
            }
            3->{json = json3
                binding!!.txtHome.text = "Operaciones con conjuntos"
            }
            4->{json = json4
                binding!!.txtHome.text = "Juegos Diagrama de Venn"
            }
            else->{}
        }


        val personList = parseJson(json)

        val recyclerView: RecyclerView = binding!!.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        recyclerView.adapter = ClassInformationAdapter(personList, this)

    }

    override fun onCardClick(item: ClassInformation) {
        viewModel.currentoption = ClassInformation(item.id, item.title, item.description, item.imgLink)

        if (viewModel.menuSelectedOption == 4){
            findNavController().navigate(R.id.gameFragment)
        }else{
            findNavController().navigate(R.id.conjuctDetailFragment)
        }
    }

    fun parseJson(json: String): List<ClassInformation> {
        val gson = Gson()
        val itemType = object : TypeToken<List<ClassInformation>>() {}.type
        return gson.fromJson(json, itemType)
    }

}