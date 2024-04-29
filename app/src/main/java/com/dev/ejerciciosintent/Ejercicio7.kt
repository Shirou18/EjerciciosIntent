package com.dev.ejerciciosintent

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dev.ejerciciosintent.databinding.ActivityEjercicio7Binding
import java.io.File
import java.io.FileOutputStream


class Ejercicio7 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio7Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEjercicio7Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnEnviarFoto.setOnClickListener {
            val imageView: ImageView = findViewById(R.id.imgView_Floppa)
            val bitmap = (imageView.drawable as BitmapDrawable).bitmap
            enviarImagen(bitmap)
        }
    }
    private fun enviarImagen(bitmap: Bitmap) {
        val file = File(externalCacheDir, "my_image.png")
        val fOut = FileOutputStream(file)
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut)
        fOut.flush()
        fOut.close()
        file.setReadable(true, false)
        val uri: Uri = FileProvider.getUriForFile(
            this,
            "com.dev.ejerciciosintent.fileprovider",
            file)
        val intent = Intent(Intent.ACTION_SEND)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.putExtra(Intent.EXTRA_STREAM, uri)
        intent.type = "image/png"
        startActivity(Intent.createChooser(intent, "Compartir imagen"))
    }
}