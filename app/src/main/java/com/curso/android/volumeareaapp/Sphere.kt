package com.curso.android.volumeareaapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Sphere : AppCompatActivity() {
    lateinit var sphereRadius: EditText
    lateinit var title : TextView
    lateinit var result : TextView
    lateinit var btnResult : Button
    lateinit var btnReturn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sphere)

        sphereRadius = findViewById(R.id.editText_sphere)
        title = findViewById(R.id.title)
        result = findViewById(R.id.volumeText)
        btnResult = findViewById(R.id.btnResult)
        btnReturn = findViewById(R.id.btnReturn)

        btnResult.setOnClickListener {
            val radius = sphereRadius.text.toString().toDouble()
            val volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3.0)
            val truncatedValue = String.format("%.3f", volume).toDouble()
            result.text = "V = $truncatedValue m³"
        }

        btnReturn.setOnClickListener {
            val intent = android.content.Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}