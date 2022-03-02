package com.iferng09.myapp

import android.app.Activity
import android.content.ActivityNotFoundException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.content.Intent
import android.speech.RecognizerIntent
import android.widget.Toast
import java.util.*


class MainActivity : AppCompatActivity() {

    companion object {
        private const val REQUEST_CODE_STT = 1
    }

    private val connection = Connection()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonStop = findViewById<Button>(R.id.botonStop)
        val botonUp = findViewById<ImageButton>(R.id.upButton)
        val botonDown = findViewById<ImageButton>(R.id.downButton)
        val botonRight = findViewById<ImageButton>(R.id.rightButton)
        val botonLeft = findViewById<ImageButton>(R.id.letfButton)
        val botonListen = findViewById<Button>(R.id.btn_listen)


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

        botonListen.setOnClickListener{
            //getSpeechInput()
            val sttIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            sttIntent.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
            )
            sttIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            sttIntent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak now!")

            try {
                startActivityForResult(sttIntent, REQUEST_CODE_STT)
            } catch (e: ActivityNotFoundException) {
                e.printStackTrace()
                Toast.makeText(this, "Your device does not support STT.", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_CODE_STT -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    val result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    result?.let {
                        val txt = it[0]
                        Toast.makeText(this, txt, Toast.LENGTH_SHORT).show()
                        connection.sendMsg(txt)
                    }
                }
            }
        }
    }
}