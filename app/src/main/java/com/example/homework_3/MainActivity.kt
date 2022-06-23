package com.example.homework_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.homework_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveBtn.setOnClickListener {
            emptyFieldValidation()
            userNameValidation()
            checkIfEmailIsValid(binding.edEmail.text.toString())
            validAge()
            Toast.makeText(this, "The data was successfully saved", Toast.LENGTH_SHORT).show()

        }

        binding.clearBtn.setOnLongClickListener {

            binding.edEmail.setText("")
            binding.edUsername.setText("")
            binding.edFirstName.setText("")
            binding.edLastName.setText("")
            binding.edAge.setText("")
            true
        }
    }

    private fun emptyFieldValidation() {
        if (binding.edEmail.text.toString().isEmpty() ||

            binding.edUsername.text.toString().isEmpty() ||
            binding.edFirstName.text.toString().isEmpty() ||
            binding.edLastName.text.toString().isEmpty() ||
            binding.edAge.text.toString().isEmpty()
        ) {
            Toast.makeText(this, "Please, fill all field", Toast.LENGTH_SHORT).show()
        }
    }

    private fun userNameValidation() {
        if (binding.edUsername.text.toString().length < 10) {
            Toast.makeText(
                this,
                "Your username must contain at least 10 characters",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun checkIfEmailIsValid(email: String) {
        if (email.contains("@") && email.contains(".")) {
        }else{
            Toast.makeText(this, "invalid email address!", Toast.LENGTH_SHORT).show()
        }

    }

    private fun validAge() {
        val input = binding.edAge.text.toString() ?: ""
        val userAge = input.toInt()

        if (userAge <= 0 || userAge > 150) {
            Toast.makeText(this, "Please enter the correct age", Toast.LENGTH_SHORT).show()
        }
    }

}


