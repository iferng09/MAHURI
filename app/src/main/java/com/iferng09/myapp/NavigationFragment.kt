package com.iferng09.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView


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

        val myDataset = Datasource().loadAffirmations()

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        var adapter = ItemAdapter(this, myDataset)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : ItemAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                connection.sendMsg(position.toString())
            }

        })

        recyclerView.setHasFixedSize(true)


        return view
    }
}