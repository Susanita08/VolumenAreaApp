package com.curso.android.volumeareaapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Cylinder : AppCompatActivity() {
    var cylinderRadius: EditText? = null
    var cylinderHeight: EditText? = null
    var title : TextView? = null
    var result : TextView? = null
    var btnResult : Button? = null
    lateinit var btnReturn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cylinder)

        cylinderRadius = findViewById(R.id.editText_radius)
        cylinderHeight = findViewById(R.id.editText_height)
        title = findViewById(R.id.title)
        result = findViewById(R.id.volumeText)
        btnResult = findViewById(R.id.btnResult)
        btnReturn = findViewById(R.id.btnReturn)

        btnResult?.setOnClickListener {
            val radius = cylinderRadius?.text.toString().toDouble()
            val height = cylinderHeight?.text.toString().toDouble()
            val volume = Math.PI * Math.pow(radius, 2.0) * height
            val truncatedValue = String.format("%.3f", volume).toDouble()
            result?.text = "V = $truncatedValue m³"
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