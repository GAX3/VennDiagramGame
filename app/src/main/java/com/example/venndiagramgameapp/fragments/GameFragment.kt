package com.example.venndiagramgameapp.fragments

import android.os.Bundle
import android.view.DragEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.venndiagramgameapp.R
import com.example.venndiagramgameapp.databinding.FragmentGameBinding
import com.example.venndiagramgameapp.databinding.FragmentGamesOptionBinding

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding

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

        // Configurar elementos arrastrables
        val elements = listOf(
            binding!!.element1,
            binding!!.element2,
            binding!!.element3,
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
            circle1 to setOf("Águila"),
            circle2 to setOf("Delfín"),
            intersection to setOf("Pato")
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