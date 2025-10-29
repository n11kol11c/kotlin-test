package com.example.finaltest

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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

        val dugme_faktorijel = findViewById<Button>(R.id.button)
        val dugme_okreni_string = findViewById<Button>(R.id.button2)
        val dugme_ispis_string_po_indeksima = findViewById<Button>(R.id.button3)

        var polje_za_unos_broja = findViewById<EditText>(R.id.editTextText)
        var polje_za_unos_stringa = findViewById<EditText>(R.id.editTextText2)

        var polje_za_ispis_poruke = findViewById<TextView>(R.id.textView)

        fun faktorijel(broj: Int): Int {
            if (broj == 0) {
                return 1
            }

            return faktorijel(broj) * broj - 1
        }

        fun faktorijelSaFor(broj: Int): Int {
            if (broj == 0) {
                return 1
            }

            var rezultat = 1

            for (i in broj downTo 1) {
                rezultat *= i
            }

            return rezultat
        }

        dugme_faktorijel.setOnClickListener {
            val broj_iz_polja = polje_za_unos_broja.text.toString().toInt()
            var rezultat = faktorijelSaFor(broj_iz_polja)

            polje_za_ispis_poruke.setText(rezultat.toString())
        }

        dugme_okreni_string.setOnClickListener {
            var string_iz_polja = polje_za_unos_stringa.text.toString()
            var velicina_stringa = string_iz_polja.length
            var okrenuti_string = ""

            for (i in velicina_stringa - 1 downTo 0) {
                okrenuti_string += string_iz_polja[i]
            }

            polje_za_ispis_poruke.setText(okrenuti_string.toString())
        }

        dugme_ispis_string_po_indeksima.setOnClickListener {
            var string_iz_polja = polje_za_unos_stringa.text.toString()
            var velicina_stringa = string_iz_polja.length
            var indeks = 1
            var poruka_po_indeksima = ""

            for (i in 0..velicina_stringa - 1) {
                poruka_po_indeksima += indeks.toString() + ". " + string_iz_polja[i] + " \n"
                indeks++
            }

            polje_za_ispis_poruke.setText(poruka_po_indeksima.toString())
        }
    }
}
