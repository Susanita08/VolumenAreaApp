package com.curso.android.volumeareaapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Prism : AppCompatActivity() {
    lateinit var base: EditText
    lateinit var height: EditText
    lateinit var title : TextView
    lateinit var result : TextView
    lateinit var btnResult : Button
    lateinit var btnReturn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_prism)

        base = findViewById(R.id.base_text_prism)
        height = findViewById(R.id.height_text_prism)
        title = findViewById(R.id.title)
        result = findViewById(R.id.volumeText)
        btnResult = findViewById(R.id.btnResult)
        btnReturn = findViewById(R.id.btnReturn)

        btnResult.setOnClickListener {
            val base = base.text.toString().toDouble()
            val height = height.text.toString().toDouble()
            val volume = base * height
            val truncatedValue = String.format("%.3f", volume).toDouble()
            result.text = "V = $truncatedValue m³"
        }

        btnReturn.setOnClickListener {
            val intent = android.content.Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

    }
}