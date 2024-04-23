package com.example.workliteadmin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.razorpay.Checkout

import org.json.JSONObject


class PaymentFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val checkout = Checkout()
        checkout.setKeyID("rzp_test_YMpRNrRlG6VDeZ")

        val options = JSONObject()
        options.put("name", "Worklite")
        options.put("description", "Best  App For Workers")
        options.put("image", "https://i.pinimg.com/originals/22/85/63/2285638720d5a004208fb38664aaf4ab.png")
        options.put("theme.color", "#BD9B72")
        options.put("currency", "BDT")
        options.put("prefill.email", "bhoomiag67890@gmail.com.com")
        options.put("prefill.contact", "+9084243046")

        try {
            checkout.open(requireActivity(), options)
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onPaymentSuccess(p0: String?) {
        Toast.makeText(requireContext(), "Payment Success", Toast.LENGTH_SHORT).show()
    }

    private fun onPaymentError(p0: Int, p1: String?) {
        Toast.makeText(requireContext(), "Payment error", Toast.LENGTH_SHORT).show()
    }
}


