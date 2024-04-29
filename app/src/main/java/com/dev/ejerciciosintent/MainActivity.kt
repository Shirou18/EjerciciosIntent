package com.dev.ejerciciosintent

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dev.ejerciciosintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configurar los OnClickListener para los botones de los ejercicios
        binding.btnEjercicio1.setOnClickListener {
            val intent = Intent(this, Ejercicio1::class.java)
            startActivity(intent)
        }

        binding.btnEjercicio2.setOnClickListener {
            val intent = Intent(this, Ejercicio2::class.java)
            startActivity(intent)
        }

        binding.btnEjercicio3.setOnClickListener {
            val intent = Intent(this, Ejercicio3::class.java)
            startActivity(intent)
        }

        binding.btnEjercicio4.setOnClickListener {
            val intent = Intent(this, Ejercicio4::class.java)
            startActivity(intent)
        }

        binding.btnEjercicio5.setOnClickListener {
            val intent = Intent(this, Ejercicio5::class.java)
            startActivity(intent)
        }

        binding.btnEjercicio6.setOnClickListener {
            val intent = Intent(this, Ejercicio6::class.java)
            startActivity(intent)
        }

        binding.btnEjercicio7.setOnClickListener {
            val intent = Intent(this, Ejercicio7::class.java)
            startActivity(intent)
        }
    }
}
