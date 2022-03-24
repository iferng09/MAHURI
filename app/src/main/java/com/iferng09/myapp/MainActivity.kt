package com.iferng09.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cameraFragment = CameraFragment()
        val controlPadFragment = ControlPadFragment()
        val micFragment = MicFragment()
        val roomsFragment = RoomsFragment()

        val barraNavegacion = findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.barraNavegacion)

        

        barraNavegacion.setOnItemSelectedListener{
            when(it.itemId){
                R.id.nav_controlPad -> {
                    setCurrentFragment(controlPadFragment)
                    true
                }

                R.id.nav_camera -> {
                    setCurrentFragment(cameraFragment)
                    true
                }

                R.id.nav_mic -> {
                    setCurrentFragment(micFragment)
                    true
                }

                R.id.nav_rooms -> {
                    setCurrentFragment(roomsFragment)
                    true
                }

                else -> false
            }
        }

    }

    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            commit()
        }
    }
}