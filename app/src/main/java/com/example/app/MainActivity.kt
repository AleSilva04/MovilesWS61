package com.example.app

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var questions: ArrayList<Question>
    var i: Int = 0
    var wrong: Int = 0
    var right: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadQuestion()
        setupView()
        Score()

    }

    private fun loadQuestion() {
        questions = ArrayList()
        questions.add(Question("Es Lima capital de Peru?", true))
        questions.add(Question("Es Lima capital de Chile?", false))
        questions.add(Question("Es Piura capital de Chile?", false))
        questions.add(Question("Es Brasil capital de Chile?", false))
        questions.add(Question("Es Santiago capital de Chile?", true))
        questions.add(Question("Es Washington DC capital de EEUU?", true))
    }

    private fun Lost(){


        if(wrong == 3){
            findViewById<TextView>(R.id.tvLost).text = "Perdiste!!"
        }
    }
    private fun Score(){
        findViewById<TextView>(R.id.tvScore).text = "Puntaje: " + right.toString()

        if(right == 6){
            findViewById<TextView>(R.id.tvLost).text = "Ganaste!!"
        }
    }

    private fun setupView(){
        val tvText = findViewById<TextView>(R.id.tvTexto)
        val btYes = findViewById<Button>(R.id.btYes)
        val btNo = findViewById<Button>(R.id.btNo)
        val btNext = findViewById<Button>(R.id.btNext)


        tvText.text = questions[i].sentence

        btYes.setOnClickListener{
            if(questions[i].answer){
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
                right++
                Score()
            }else{
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
                wrong++
                Lost()
            }
        }

        btNo.setOnClickListener{
            if(!questions[i].answer){
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
                right++
                Score()
            }else{
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
                wrong++
                Lost()
            }
        }

        btNext.setOnClickListener{
            i++
            tvText.text = questions[i].sentence
            Lost()
        }



    }
}