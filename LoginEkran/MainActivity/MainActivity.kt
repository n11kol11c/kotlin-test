package com.example.loginekran

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

        var polje_za_unos_mejla = findViewById<EditText>(R.id.editTextText)
        var polje_za_unos_sifre = findViewById<EditText>(R.id.editTextText2)
        var polje_za_ispis = findViewById<TextView>(R.id.textView)

        fun provjeriMejl(mejl: String): Int {
            val brojevi = "0123456789"
            val malaSlova = "qwertyuiopasdfghjklzxcvbnm"
            val slova = malaSlova + malaSlova.uppercase()

            val imaSlovo = mejl.any { it in slova }
            val imaBroj = mejl.any { it in brojevi }

            return when {
                !imaSlovo -> -1
                imaSlovo && imaBroj -> 1
                else -> 0
            }
        }

        fun provjeriSifru(sifra: String): Int {
            val brojevi = "0123456789"
            val malaSlova = "qwertyuiopasdfghjklzxcvbnm"
            val slova = malaSlova + malaSlova.uppercase()
            val specijalni = "!@#\\$%^&*()_+"
            val x = brojevi + slova + specijalni

            val imaSlovo = sifra.any { it in slova }
            val imaBroj = sifra.any { it in brojevi }
            val imaKarakter = sifra.any { it in specijalni }

            return when {
                !imaSlovo -> -1
                imaSlovo && imaBroj && imaKarakter -> 2
                imaSlovo && imaBroj -> 1
                else -> 0
            }
        }

        dugme.setOnClickListener {
            var mejl_unos = polje_za_unos_mejla.text.toString()
            var sifra_unos = polje_za_unos_sifre.text.toString()

            if (!mejl_unos.contains("@", true) || mejl_unos.isEmpty()) {
                Toast.makeText(this, "Mejl mora da sadrzi '@'", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (provjeriMejl(mejl_unos) == -1) {
                Toast.makeText(this, "Mejl nije jak", Toast.LENGTH_LONG).show()
            }

            if (sifra_unos.isEmpty() || sifra_unos.length < 8) {
                Toast.makeText(this, "Polje za sifru je prazno ili manje od 8 karaktera", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (provjeriSifru(sifra_unos) == -1 || provjeriSifru(sifra_unos) == 1) {
                Toast.makeText(this, "Nedovoljno jaka sifra", Toast.LENGTH_LONG).show()
            }

            if (provjeriSifru(sifra_unos) == 2) {
                Toast.makeText(this, "Profil uspijesno napravljen", Toast.LENGTH_LONG).show()
            }
        }
    }
}
