package com.example.workliteadmin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.workliteadmin.databinding.FragmentDetailsBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class DetailsFragment : Fragment() {
  private lateinit var binding: FragmentDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentDetailsBinding.inflate(layoutInflater)
        binding.submitButton.setOnClickListener {
            validateAndStoreData()
        }

        return binding.root
    }
    private fun validateAndStoreData() {
        val taskName = binding.taskame.text.toString()
        val taskDate = binding.taskdate.text.toString()
        val checkIn = binding.taskame.text.toString()
        val checkOut = binding.taskdate.text.toString()






        storeData(taskName, taskDate, checkIn, checkOut)
    }

    private fun storeData(taskName: String, taskDate: String, checkIn: String, checkOut: String) {
        val db = Firebase.firestore
        val productsRef = db.collection("Products")

        val data = addTaskModel(binding.taskame.toString(),
            binding.taskdate.toString(),
            binding.checkin.toString(),
            binding.checkout.toString()
        )

        productsRef.add(data)
            .addOnSuccessListener {
                Toast.makeText(requireContext(), "Product added", Toast.LENGTH_SHORT).show()
                clearFields()
            }
            .addOnFailureListener { e ->
                Log.e("FirebaseError", "Error adding product", e)
                Toast.makeText(
                    requireContext(),
                    "Something went wrong: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    private fun clearFields() {
        binding.taskame.text = null
        binding.taskdate.text = null
        binding.checkin.text = null
        binding.checkout.text = null
    }
}


