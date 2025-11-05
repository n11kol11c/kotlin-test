package com.example.funkcije1

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

        val dugme_saberi = findViewById<Button>(R.id.button)
        val dugme_pomnozi = findViewById<Button>(R.id.button2)

        var polje_za_ispis = findViewById<TextView>(R.id.textView)
        var unos_broj1 = findViewById<EditText>(R.id.editTextText)
        var unos_broj2 = findViewById<EditText>(R.id.editTextText2)

        fun saberi(x: Int, y: Int): Int {

            if (unos_broj1.text.toString().isEmpty() || x.toInt() == null) {
                Toast.makeText(this, "Unesite cijeli broj", Toast.LENGTH_SHORT).show()
            }

            if (unos_broj2.text.toString().isEmpty() || y.toInt() == null) {
                Toast.makeText(this, "Unesite cijeli broj", Toast.LENGTH_SHORT).show()
            }

            return x + y
        }

        fun pomnozi(x: Int, y: Int): Int {

            if (unos_broj1.text.toString().isEmpty() || x.toInt() == null) {
                Toast.makeText(this, "Unesite cijeli broj", Toast.LENGTH_SHORT).show()
            }

            if (unos_broj2.text.toString().isEmpty() || y.toInt() == null) {
                Toast.makeText(this, "Unesite cijeli broj", Toast.LENGTH_SHORT).show()
            }

            return x * y
        }

        dugme_saberi.setOnClickListener {
            var x = unos_broj1.text.toString().toInt()
            var y = unos_broj2.text.toString().toInt()
            var r = saberi(x!!, y!!)
            polje_za_ispis.setText(r.toString())
        }

        dugme_pomnozi.setOnClickListener {
            var x = unos_broj1.text.toString().toInt()
            var y = unos_broj2.text.toString().toInt()
            var r = pomnozi(x!!, y!!)
            polje_za_ispis.setText(r.toString())
        }
    }
}
