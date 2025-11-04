package com.example.unosi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dugme = findViewById<Button>(R.id.button)
        val dugme_restart = findViewById<Button>(R.id.button2)

        var polje_za_unos = findViewById<EditText>(R.id.editTextText)
        var polje_za_ispis = findViewById<TextView>(R.id.textView)

        dugme.setOnClickListener {
            var unos = polje_za_unos.text.toString()

            if (unos.isEmpty()) {
                Toast.makeText(this,"Nema unosa",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (unos.contains(other = "@", ignoreCase = true)) {
                polje_za_ispis.setText("Uneseni string sadrzi '@'")
            } else {
                polje_za_ispis.setText("Uneseni string ne sadrzi '@'")
            }
        }

        dugme_restart.setOnClickListener {
            var unos = polje_za_unos.text.toString()
            var ispis = polje_za_ispis.text.toString()
            val prazno_polje = ""

            if (!unos.isEmpty()) {
                polje_za_unos.setText(prazno_polje.toString())
            } else return@setOnClickListener

            if (!ispis.isEmpty()) {
                polje_za_ispis.setText(prazno_polje.toString())
            } else return@setOnClickListener

            Toast.makeText(this,"Restartovano",Toast.LENGTH_LONG).show()
        }
    }
}