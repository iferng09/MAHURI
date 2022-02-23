package com.iferng09.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonStop = findViewById<Button>(R.id.botonStop)
        val botonUp = findViewById<ImageButton>(R.id.upButton)
        val botonDown = findViewById<ImageButton>(R.id.downButton)
        val botonRight = findViewById<ImageButton>(R.id.rightButton)
        val botonLeft = findViewById<ImageButton>(R.id.letfButton)
        val botonListen = findViewById<Button>(R.id.btn_listen)

        val connection = Connection()

        botonUp.setOnClickListener {
            connection.sendMsg("UP")
        }

        botonDown.setOnClickListener {
            connection.sendMsg("DOWN")
        }

        botonLeft.setOnClickListener {
            connection.sendMsg("LEFT")
        }

        botonRight.setOnClickListener {
            connection.sendMsg("RIGHT")
        }

        botonStop.setOnClickListener{
            connection.sendMsg("STOP")
        }
    }
}