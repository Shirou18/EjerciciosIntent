package com.dev.ejerciciosintent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dev.ejerciciosintent.databinding.ActivityEjercicio4Binding

class Ejercicio4 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEjercicio4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnLlamar.setOnClickListener {
            val numCelular = binding.editTxtNumero.text.toString()
            val dial = "tel:$numCelular"
            startActivity(Intent(Intent.ACTION_CALL, Uri.parse(dial)))
        }
    }
}