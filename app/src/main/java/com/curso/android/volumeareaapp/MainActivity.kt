package com.curso.android.volumeareaapp

import android.util.Log
import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val gridView = findViewById<GridView>(R.id.gridView)

        val shapesArrayList = ArrayList<Shape>()
        shapesArrayList.add(Shape(R.drawable.cube, "Cube"))
        shapesArrayList.add(Shape(R.drawable.sphere, "Sphere"))
        shapesArrayList.add(Shape(R.drawable.cylinder, "Cylinder"))
        shapesArrayList.add(Shape(R.drawable.prism, "Prism"))

        gridView.adapter = MyCustomAdapter(this, shapesArrayList)
        gridView.numColumns = 2

        gridView.setOnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position) as Shape
            launchShapeActivity(item.shapeName)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun launchShapeActivity(name: String) {
        Log.d("MainActivity", "launchShapeActivity called with name: $name")
        val intent = when (name) {
            "Sphere" -> {
                Log.d("MainActivity", "Launching Sphere activity")
                Intent(this, Sphere::class.java)
            }
            "Cylinder" -> {
                Log.d("MainActivity", "Launching Cylinder activity")
                Intent(this, Cylinder::class.java)
            }
            "Prism" -> {
                Log.d("MainActivity", "Launching Prism activity")
                Intent(this, Prism::class.java)
            }
            "Cube" -> {
                Log.d("MainActivity", "Launching Cube activity")
                Intent(this, Cube::class.java)
            }
            else -> {
                Log.e("MainActivity", "No activity found for: $name")
                null
            }
        }

        if (intent != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "No activity found for $name", Toast.LENGTH_SHORT).show()
        }
    }
}