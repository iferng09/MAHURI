package com.iferng09.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.iferng09.myapp.CameraFragment as CameraFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cameraFragment = CameraFragment()
        val remoteControlFragment = RemoteControlFragment()
        val micFragment = MicFragment()
        val navigationFragment = NavigationFragment()

        val barraNavegacion = findViewById<BottomNavigationView>(R.id.barraNavegacion)

        val connection = Connection()
        //val cameraConnection = CameraConnection()
        val fragmentViewModel : FragmentViewModel by viewModels()
        fragmentViewModel.setData(connection)

        //val cameraConnection = CameraConnection()
        //fragmentViewModel.setCamera(cameraConnection)


        barraNavegacion.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_controlPad -> {
                    setCurrentFragment(remoteControlFragment)
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
                    setCurrentFragment(navigationFragment)
                    true
                }

                else -> false
            }
        }

    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            commit()
        }
    }
}
