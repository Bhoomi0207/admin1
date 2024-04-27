package com.example.workliteadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.workliteadmin.databinding.ActivityDetailBinding
import com.example.workliteadmin.databinding.FragmentDetailsBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class DetailActivity : AppCompatActivity() {
    private lateinit var submitButton: Button
    private lateinit var taskNameEditText: EditText
    private lateinit var taskDateEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail) // Replace with your layout resource ID

        // Initialize view references using view binding (recommended for maintainability)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        submitButton = binding.submitButton // Replace with your submit button ID
        taskNameEditText = binding.taskame // Replace with your task name EditText ID
        taskDateEditText = binding.taskdate // Replace with your task date EditText ID

        submitButton.setOnClickListener {
            validateData()
        }
    }

    private fun validateData() {
        if (taskNameEditText.text.toString().isEmpty()){
            taskNameEditText.requestFocus()
            taskNameEditText.error= "Empty"
        }else if (taskDateEditText.text.toString().isEmpty()){
            taskDateEditText.error = "Empty"

        }else{
            storeData()
        }
    }



    private fun storeData() {
        val db = Firebase.firestore.collection("Products")
        val key = db.document().id

        val data = addTaskModel(
            taskNameEditText.text.toString(),
           taskDateEditText.text.toString(),
            //  key,

        )
        db.document(key).set(data).addOnSuccessListener {
            // dialog.dismiss()

            Toast.makeText(this, "sucessfully added", Toast.LENGTH_SHORT).show()
            taskNameEditText.text = null
            taskDateEditText.text=null
        }
            .addOnFailureListener { e ->
                // dialog.dismiss()
                Log.e("FirebaseError", "Error adding category", e)
                Toast.makeText(
                    this,
                    "Something went wrong: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()

            }


    }




}



