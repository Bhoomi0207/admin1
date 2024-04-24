package com.example.workliteadmin


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.workliteadmin.databinding.FragmentDetailsBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*


class DetailsFragment : Fragment() {


    private lateinit var binding:FragmentDetailsBinding




    override fun onCreateView(
        inflater:LayoutInflater, container:ViewGroup?,
        savedInstanceState:Bundle?,
    ):View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater)







        binding.submitButton.setOnClickListener{
            validateData()
        }


        return binding.root
    }

    private fun validateData() {
        if (binding.taskame.text.toString().isEmpty()){
            binding.taskame.requestFocus()
            binding.taskame.error= "Empty"
        }else if (binding.taskdate.text.toString().isEmpty()){
            binding.taskdate.error = "Empty"

        }else{
           storeData()
        }
    }



    private fun storeData() {
        val db = Firebase.firestore.collection("Products")
        val key = db.document().id

        val data = addTaskModel(
            binding.taskame.text.toString(),
            binding.taskdate.text.toString(),
          //  key,

        )
        db.document(key).set(data).addOnSuccessListener {
           // dialog.dismiss()

            Toast.makeText(requireContext(), "sucessfully added", Toast.LENGTH_SHORT).show()
            binding.taskame.text = null
        }
            .addOnFailureListener { e ->
               // dialog.dismiss()
                Log.e("FirebaseError", "Error adding category", e)
                Toast.makeText(
                    requireContext(),
                    "Something went wrong: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()

            }


    }




    }





