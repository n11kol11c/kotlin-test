package com.example.counter

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import kotlin.random.Random

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

        var polje_za_unos = findViewById<EditText>(R.id.editTextText)
        var polje_za_ispis = findViewById<TextView>(R.id.textView2)
        var polje_za_broj_pokusaja = findViewById<TextView>(R.id.textView)

        var brojac_pokusaja = 0

        var skriveni_broj = Random.nextInt(1, 10)

        dugme_pogodi.setOnClickListener {
            if (skriveni_broj == polje_za_unos.text.toString().toInt()) {
                brojac_pokusaja++
                polje_za_ispis.setText("Skriveni broj je pogodjen")
                polje_za_broj_pokusaja.setText(brojac_pokusaja.toString())
            } else {
                brojac_pokusaja++
                polje_za_ispis.setText("Skriveni broj nije pogodjen")
                polje_za_broj_pokusaja.setText(brojac_pokusaja.toString())
            }
        }

        dugme_restart.setOnClickListener {
            skriveni_broj = Random.nextInt(1, 10)
            brojac_pokusaja = 0
            polje_za_unos.setText("")
            polje_za_ispis.setText("")
        }
    }
}