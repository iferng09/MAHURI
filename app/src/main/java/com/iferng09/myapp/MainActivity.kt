package com.iferng09.myapp

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonConexion = findViewById<Button>(R.id.botonConexion)
        val botonUp = findViewById<ImageButton>(R.id.upButton)
        val botonDown = findViewById<ImageButton>(R.id.downButton)
        val botonRight = findViewById<ImageButton>(R.id.rightButton)
        val botonLeft = findViewById<ImageButton>(R.id.letfButton)
        //val textoContador = findViewById<TextView>(R.id.contador)

        var contador = 1;
        val connection = Connection()

        botonConexion.setOnClickListener{
            connection.connect(contador)
            //textoContador.text = contador.toString()
            contador++
        }

        botonUp.setOnClickListener{
            connection.sendMsg("UP")
        }

        botonDown.setOnClickListener{
            connection.sendMsg("DOWN")
        }

        botonLeft.setOnClickListener{
            connection.sendMsg("LEFT")
        }

        botonRight.setOnClickListener{
            connection.sendMsg("RIGHT")
        }
    }
}