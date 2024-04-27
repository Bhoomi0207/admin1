package com.example.workliteadmin

import ComnplainAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workliteadmin.databinding.FragmentComplainBinding
import com.example.workliteadmin.databinding.FragmentRequestBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class ComplainFragment : Fragment() {

    private lateinit var binding: FragmentComplainBinding
    private lateinit var adapter: ComnplainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComplainBinding.inflate(layoutInflater)

        //    getProducts()
        retrieveDataFromFirestore()
        return binding.root

    }

    private fun retrieveDataFromFirestore() {
        val db = Firebase.firestore
        val productsRef = db.collection("complain")

        val taskItemList = mutableListOf<addComplainModel>() // Step 1: Create an empty list

        productsRef.get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    // Step 2: Create TaskItem objects and add them to the list
                    val taskName = document.getString("name") ?: ""
                    val taskDate = document.getString("complain") ?: ""


                    val taskItem = addComplainModel(taskName, taskDate)
                    taskItemList.add(taskItem)

                    // Example: Display data in Logcat
                    Log.d(
                        "FirestoreData",
                        "Task Name: $taskName, Task Date: $taskDate"
                    )
                }

                // Step 3: Initialize RecyclerView adapter with the list and set
                adapter = ComnplainAdapter(requireContext(), taskItemList)
                binding.cartRecycler.adapter = adapter
                binding.cartRecycler.layoutManager = LinearLayoutManager(requireContext())
            }
            .addOnFailureListener { e ->
                Log.e("FirestoreError", "Error retrieving data", e)
                Toast.makeText(
                    requireContext(),
                    "Error retrieving data: ${e.message}",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
    }
}
