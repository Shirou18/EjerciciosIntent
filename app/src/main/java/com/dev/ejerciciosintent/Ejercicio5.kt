package com.dev.ejerciciosintent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dev.ejerciciosintent.databinding.ActivityEjercicio5Binding

class Ejercicio5 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEjercicio5Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnBuscar.setOnClickListener {
            val url = binding.editTextURL.text.toString()
            if (url.isNotEmpty()) {
                val webpage = Uri.parse(url)
                if (webpage.scheme != null) { // Verifica que la URL tenga un esquema (http, https, etc.)
                    val buscar = Intent(Intent.ACTION_VIEW)
                    buscar.data = webpage
                    startActivity(buscar)
                } else {
                    Toast.makeText(this, "Debe ingresar una URL válida", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Debe ingresar una URL", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
