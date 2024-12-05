package com.example.venndiagramgame

import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    private var score = 0
    private lateinit var scoreView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar la puntuación
        scoreView = findViewById(R.id.scoreView)

        // Configurar elementos arrastrables
        val elements = listOf(
            findViewById<TextView>(R.id.element1),
            findViewById<TextView>(R.id.element2),
            findViewById<TextView>(R.id.element3)
        )

        elements.forEach { element ->
            element.setOnLongClickListener {
                val dragShadow = View.DragShadowBuilder(it)
                it.startDragAndDrop(null, dragShadow, it, 0)
                true
            }
        }

        // Configurar receptores (círculos del diagrama)
        val circle1 = findViewById<View>(R.id.circle1)
        val circle2 = findViewById<View>(R.id.circle2)
        val intersection = findViewById<View>(R.id.intersection)

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
                            Toast.makeText(this, "¡Correcto!", Toast.LENGTH_SHORT).show()
                            incrementScore(10)
                            draggedView.visibility = View.GONE
                        } else {
                            Toast.makeText(this, "¡Incorrecto!", Toast.LENGTH_SHORT).show()
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
