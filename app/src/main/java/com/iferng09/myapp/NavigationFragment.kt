package com.iferng09.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels


class NavigationFragment : Fragment(R.layout.fragment_navigation) {

    private lateinit var connection:Connection

    private val viewModel: FragmentViewModel by activityViewModels()
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view : View = inflater.inflate(R.layout.fragment_navigation, container, false)
        viewModel.data.observe(viewLifecycleOwner) {
            connection = it
        }
        val botonSalon = view.findViewById<Button>(R.id.btn_Salon)
        val botonCocina = view.findViewById<Button>(R.id.btn_cocina)
        val botonHabitacion = view.findViewById<Button>(R.id.btn_Habitacion)

        botonSalon.setOnClickListener{
            connection.sendMsg("SALON")
        }

        botonCocina.setOnClickListener{
            connection.sendMsg("COCINA")
        }

        botonHabitacion.setOnClickListener{
            connection.sendMsg("HABITACION")
        }

        return view
    }
}