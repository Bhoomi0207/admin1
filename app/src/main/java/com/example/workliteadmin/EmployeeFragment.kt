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


                ProfileItem("Mala",  "7392659120", R.drawable.woman12),
        ProfileItem("Deepa","9251329227", R.drawable.woman13),
        ProfileItem("Sonam", "6398462203", R.drawable.woman14),
        ProfileItem("Mahima", "8645920410", R.drawable.woman15),
        ProfileItem("Pratibha", "9015768567", R.drawable.woman1),
        ProfileItem("Ragini", "8874356772", R.drawable.woman2),
        ProfileItem("Sushila", "6954302105", R.drawable.woman4),
        ProfileItem("Naina",  "6392134091", R.drawable.woman5),
        ProfileItem("Vineeta","8764592061", R.drawable.woman6),
        ProfileItem("Poonam", "8313750129", R.drawable.woman7),
        ProfileItem("Sunita", "6205672349", R.drawable.woman8),
        ProfileItem("Rohini", "8299789338", R.drawable.woman9),
        ProfileItem("Sapna", "9693265100", R.drawable.woman10),
        ProfileItem("Pinki", "7884356013", R.drawable.woman16),

            // Add more ProfileItems as needed
        )

        // Initialize adapter with the provided data
        adapter = ProfileAdapter(requireContext(), profileItems)

        // Set layout manager and adapter for RecyclerView
        binding.cartRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecycler.adapter = adapter
    }
}