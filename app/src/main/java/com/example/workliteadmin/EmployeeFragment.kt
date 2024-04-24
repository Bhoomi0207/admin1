package com.example.workliteadmin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workliteadmin.databinding.FragmentEmployeeBinding
import com.google.android.gms.common.util.CollectionUtils


class EmployeeFragment : Fragment() {


    private lateinit var binding:FragmentEmployeeBinding
    private lateinit var adapter: ProfileAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmployeeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Sample data for ProfileItems
        val profileItems = CollectionUtils.listOf(
            ProfileItem("Sunita", "9015768567", R.drawable.person),
            ProfileItem("Sunita", "9015768567", R.drawable.person),
            ProfileItem("Sunita", "9015768567", R.drawable.person),
            ProfileItem("Sunita", "9015768567", R.drawable.person),
            ProfileItem("Sunita", "9015768567", R.drawable.person),
            ProfileItem("Sunita", "9015768567", R.drawable.person),
            ProfileItem("Sunita", "9015768567", R.drawable.person),
            // Add more ProfileItems as needed
        )

        // Initialize adapter with the provided data
        adapter = ProfileAdapter(requireContext(), profileItems)

        // Set layout manager and adapter for RecyclerView
        binding.cartRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecycler.adapter = adapter
    }
}