package com.dev.ejerciciosintent

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dev.ejerciciosintent.databinding.ActivityEjercicio6Binding

class Ejercicio6 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEjercicio6Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnEnviarCorreo.setOnClickListener {
            val destinatario = binding.editTextDestinatario.text.toString()
            val asunto = binding.editTextAsunto.text.toString()
            val cuerpo = binding.editTextCuerpo.text.toString()

            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "message/rfc822"
                putExtra(Intent.EXTRA_EMAIL, arrayOf(destinatario))
                putExtra(Intent.EXTRA_SUBJECT, asunto)
                putExtra(Intent.EXTRA_TEXT, cuerpo)
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "No hay aplicaciones de correo instaladas.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
