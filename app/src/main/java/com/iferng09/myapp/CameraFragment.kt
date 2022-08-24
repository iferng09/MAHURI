package com.iferng09.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.activityViewModels
import java.util.concurrent.TimeUnit


class CameraFragment : Fragment(R.layout.fragment_camera) {
    //private lateinit var connection:CameraConnection

    //private val viewModel: CameraViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_camera, container, false)

        /*viewModel.data.observe(viewLifecycleOwner) {
            connection = it
        }*/

        val img = view.findViewById<ImageView>(R.id.img)

        val connection = CameraConnection()

        while(true) {
            connection.receiveImg()
            TimeUnit.SECONDS.sleep(4)

            img.setImageBitmap(connection.getBitmap())

            return view
        }
    }
}