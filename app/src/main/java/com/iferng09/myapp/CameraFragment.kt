package com.iferng09.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.fragment.app.activityViewModels


class CameraFragment : Fragment(R.layout.fragment_camera) {
    private lateinit var connection:Connection

    private val viewModel: FragmentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_rooms, container, false)
        viewModel.data.observe(viewLifecycleOwner) {
            connection = it
        }

        val img = view.findViewById<VideoView>(R.id.img)
        connection.sendMsg("CAMARA")

        return view
    }
}