package com.example.workliteadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // Set the initial fragment
        setCurrentFragment(EmployeeFragment())

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> setCurrentFragment(EmployeeFragment())
                R.id.nav_request -> setCurrentFragment(RequestFragment())
                R.id.nav_deatils -> setCurrentFragment(DetailsFragment())
                R.id.nav_pay -> setCurrentFragment(PaymentFragment())
                R.id.nav_description -> setCurrentFragment(DescriptionFragment())
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment)
            commit()
        }
    }
}

