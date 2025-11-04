package com.example.pogodirijec

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.*
import java.sql.Time

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

        val dugme_pogodi = findViewById<Button>(R.id.button)
        val dugme_restart = findViewById<Button>(R.id.button2)
        val dugme_prikazi = findViewById<Button>(R.id.button3)

        var polje_za_unos = findViewById<EditText>(R.id.editTextText)

        var polje_za_ispis = findViewById<TextView>(R.id.textView)
        var polje_za_brojac = findViewById<TextView>(R.id.textView2)

        var brojac = 0
        var skrivena_rijec = "sifra123"


        dugme_pogodi.setOnClickListener {
            var unos = polje_za_unos.text.toString()

            if (unos.isEmpty()) {
                Toast.makeText(this, "Polje za unos je prazno", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (unos.equals(skrivena_rijec, false)) {
                brojac++
                polje_za_brojac.setText(brojac.toString())
                polje_za_ispis.setText("Skrivena rijec je pogodjena")
                dugme_pogodi.isEnabled = false
            } else {
                brojac++
                polje_za_brojac.setText(brojac.toString())
                polje_za_ispis.setText("Skrivena rijec nije pogodjena")
            }
        }

        dugme_restart.setOnClickListener {
            val prazno_polje = ""
            brojac = 0
            polje_za_brojac.setText(brojac.toString())
            polje_za_ispis.setText(prazno_polje.toString())
            polje_za_unos.setText(prazno_polje.toString())
            dugme_pogodi.isEnabled = true
        }

        dugme_prikazi.setOnClickListener {
            var unos = polje_za_unos.text.toString()

            if (!unos.isEmpty()) {
                Toast.makeText(this, "Unos mora biti prazan za prikaz rijeci", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else {
                Toast.makeText(this, skrivena_rijec.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }
}
