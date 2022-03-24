package com.iferng09.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class RoomsFragment : Fragment(R.layout.fragment_rooms) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_rooms, container, false)
        val botonSalon = view.findViewById<Button>(R.id.btn_Salon)
        val botonCocina = view.findViewById<Button>(R.id.btn_cocina)
        val botonHabitacion = view.findViewById<Button>(R.id.btn_Habitacion)

        return view
    }
}