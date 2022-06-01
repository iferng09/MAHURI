package com.iferng09.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.activityViewModels


class CameraFragment : Fragment(R.layout.fragment_camera) {
    private lateinit var connection:Connection

    private val viewModel: FragmentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_camera, container, false)

        val img = view.findViewById<ImageView>(R.id.img)

        //val camera = CameraConnection()

        //img.setImageBitmap(camera.getBitmap())

        return view
    }
}