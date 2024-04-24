package com.example.workliteadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.workliteadmin.databinding.ActivityAddTask2Binding

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class addTask2 : AppCompatActivity() {
    private lateinit var binding: ActivityAddTask2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTask2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.submitButton.setOnClickListener {
            validateAndStoreData()
        }
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
                Toast.makeText(this@addTask2, "Product added", Toast.LENGTH_SHORT).show()
                clearFields()
            }
            .addOnFailureListener { e ->
                Log.e("FirebaseError", "Error adding product", e)
                Toast.makeText(
                    this@addTask2,
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

