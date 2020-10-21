package com.example.android.myndapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.myndapplication.R
import com.example.android.myndapplication.model.SharedViewModel
import kotlinx.android.synthetic.main.recycler_list_item.*


class TabFragment : Fragment() {
    var position: Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.recycler_list_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        position = arguments?.getInt("pos")!!
        txt_position.setText("Dynamically Add View and Remove View "+position.toString())
        btn_remove.setOnClickListener {
            model.sendMessage(position)
        }
    }

    companion object {
        fun newInstance(position:Int) = TabFragment().apply {
            arguments = Bundle().apply {
                putInt("pos", position)
            }
        }
    }
}