package com.example.kalkulator

import android.health.connect.datatypes.units.Velocity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.reflect.typeOf

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

        val dugme_saberi = findViewById<Button>(R.id.button)
        val dugme_oduzmi = findViewById<Button>(R.id.button2)
        val dugme_pomnozi = findViewById<Button>(R.id.button3)
        val dugme_podjeli = findViewById<Button>(R.id.button4)
        val dugme_ocisti = findViewById<Button>(R.id.button6)

        var polje_za_unos = findViewById<EditText>(R.id.editTextText)
        var polje_za_ispis = findViewById<TextView>(R.id.textView)

        var prviBroj: Int? = null
        var operacija: String? = null

        fun Ocisit() {
            polje_za_unos.setText("")
            prviBroj = null
            operacija = null
            polje_za_ispis.text = ""
        }

        dugme_ocisti.setOnClickListener {
            Ocisit()
        }

        fun postaviOperaciju(op: String) {
            val unos = polje_za_unos.text.toString()

            if (unos.isEmpty()) return

            prviBroj = unos.toInt()
            operacija = op
            polje_za_unos.setText("")
        }

        dugme_saberi.setOnClickListener { postaviOperaciju("+") }
        dugme_oduzmi.setOnClickListener { postaviOperaciju("-") }
        dugme_podjeli.setOnClickListener { postaviOperaciju("/") }
        dugme_pomnozi.setOnClickListener { postaviOperaciju("*") }

        val dugme_rezultat = findViewById<Button>(R.id.button5)

        dugme_rezultat.setOnClickListener {
            val unos = polje_za_unos.text.toString()

            if (unos.isEmpty() || prviBroj == null || operacija == null ) return@setOnClickListener

            var drugiBroj = unos.toInt()

            val rezultat = when (operacija) {
                "+" -> prviBroj!! + drugiBroj
                "-" -> prviBroj!! - drugiBroj
                "*" -> prviBroj!! * drugiBroj
                "/" -> if (prviBroj != 0) prviBroj!! / drugiBroj else "djeljenje sa nulom nije dozvoljeno"
                else -> "Pogresan unos"
            }

            polje_za_ispis.text = rezultat.toString()
        }
    }
}
