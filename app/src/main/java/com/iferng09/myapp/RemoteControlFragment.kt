package com.iferng09.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.activityViewModels

class RemoteControlFragment : Fragment(R.layout.fragment_remote_control) {

    private lateinit var connection:Connection

    private val viewModel: FragmentViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_remote_control, container, false)

        viewModel.data.observe(viewLifecycleOwner) {
            connection = it
        }

        val botonStop = view.findViewById<Button>(R.id.botonStop)
        val botonUp = view.findViewById<ImageButton>(R.id.upButton)
        val botonDown = view.findViewById<ImageButton>(R.id.downButton)
        val botonRight = view.findViewById<ImageButton>(R.id.rightButton)
        val botonLeft = view.findViewById<ImageButton>(R.id.letfButton)

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

        botonStop.setOnClickListener {
            connection.sendMsg("STOP")
        }

        return view;
    }
}