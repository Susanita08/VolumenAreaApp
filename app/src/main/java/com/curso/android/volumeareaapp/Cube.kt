package com.curso.android.volumeareaapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Cube : AppCompatActivity() {
    lateinit var arist: EditText
    lateinit var title : TextView
    lateinit var result : TextView
    lateinit var btnResult : Button
    lateinit var btnReturn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cube)

        arist = findViewById(R.id.editText_cube)
        title = findViewById(R.id.title)
        result = findViewById(R.id.volumeText)
        btnResult = findViewById(R.id.btnResult)
        btnReturn = findViewById(R.id.btnReturn)

        btnResult.setOnClickListener {
            val arist = arist.text.toString().toDouble()
            val volume = Math.pow(arist, 3.0)
            val truncatedValue = String.format("%.3f", volume).toDouble()
            result.text = "V = $truncatedValue m³"
        }

        btnReturn.setOnClickListener {
            val intent = android.content.Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}