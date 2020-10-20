package com.example.android.myndapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.android.myndapplication.R
import com.example.android.myndapplication.adapter.UserAdapter
import com.example.android.myndapplication.model.User
import kotlinx.android.synthetic.main.recycler_list_item.*
import kotlin.collections.ArrayList


class UserRecyclerFragment : Fragment() {
    private val recyclerView: RecyclerView? = null
    private val adapter: UserAdapter? = null
    private var userList: ArrayList<User>? = null
    var position: Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        /* recyclerView = view.findViewById(R.id.recycler1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new UserAdapter(getActivity(), userList);
        recyclerView.setAdapter(adapter);*/
        return inflater.inflate(R.layout.recycler_list_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        position = arguments?.getInt("pos")!!
        txt_position.setText("Dynamically Add View and Remove View "+position.toString())
        btn_remove.setOnClickListener {
            doAction()
        }
    }

    fun doAction() {
        val parentFragment = activity?.supportFragmentManager?.findFragmentById(R.id.f_container)
        if (parentFragment is MainFragmentTab) {
                parentFragment.removeTab(position)
        }
    }

    companion object {
       /* fun newInstance(position:Int ):Fragment {
            val bundle= Bundle().apply {
                putInt("pos", position)
            }
            val fragment= UserRecyclerFragment()
            fragment.arguments.apply { bundle }
            return fragment
        }*/

        fun newInstance(position:Int) = UserRecyclerFragment().apply {
            arguments = Bundle().apply {
                putInt("pos", position)
            }
        }
    }
}