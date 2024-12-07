package com.example.venndiagramgameapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.DragEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.venndiagramgameapp.R
import com.example.venndiagramgameapp.databinding.FragmentGameBinding
import com.example.venndiagramgameapp.databinding.FragmentGamesOptionBinding
import com.example.venndiagramgameapp.viewmodel.UserViewModel

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding

    private val viewModel: UserViewModel by activityViewModels()

    private var score = 0
    private lateinit var scoreView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding!!.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar la puntuación
        scoreView = binding!!.scoreView

        when(viewModel.currentoption!!.id){
            1->{unionGame()}
            2->{}
            3->{}
            4->{}
        }
    }

    @SuppressLint("SetTextI18n")
    private fun unionGame(){
        //Set Texts

        binding!!.question.text = "A: {1, 2, 3, 4} \nB: {3, 4, 5, 6} \nA∪B={1,2,3,4,5,6}"

        binding!!.element1.text = "1"
        binding!!.element2.text = "2"
        binding!!.element3.text = "3"
        binding!!.element4.text = "4"
        binding!!.element5.text = "5"
        binding!!.element6.text = "6"

        // Configurar elementos arrastrables
        val elements = listOf(
            binding!!.element1,
            binding!!.element2,
            binding!!.element3,
            binding!!.element4,
            binding!!.element5,
            binding!!.element6,
        )

        elements.forEach { element ->
            element.setOnLongClickListener {
                val dragShadow = View.DragShadowBuilder(it)
                it.startDragAndDrop(null, dragShadow, it, 0)
                true
            }
        }

        // Configurar receptores (círculos del diagrama)
        val circle1 = binding!!.circle1
        val circle2 = binding!!.circle2
        val intersection = binding!!.intersection

        val targets = mapOf(
            circle1 to setOf("1", "2"),
            circle2 to setOf("5", "6"),
            intersection to setOf("3", "4",)
        )

        targets.keys.forEach { target ->
            target.setOnDragListener { _, event ->
                when (event.action) {
                    DragEvent.ACTION_DROP -> {
                        val draggedView = event.localState as TextView
                        val itemName = draggedView.text.toString()

                        if (targets[target]?.contains(itemName) == true) {
                            Toast.makeText(requireActivity(), "¡Correcto!", Toast.LENGTH_SHORT).show()
                            incrementScore(10)
                            draggedView.visibility = View.GONE
                        } else {
                            Toast.makeText(requireActivity(), "¡Incorrecto!", Toast.LENGTH_SHORT).show()
                        }
                        true
                    }
                    else -> true
                }
            }
        }
    }




    private fun incrementScore(points: Int) {
        score += points
        scoreView.text = "Puntuación: $score"
    }

}