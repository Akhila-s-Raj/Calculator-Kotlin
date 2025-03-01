package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1 = findViewById<EditText>(R.id.num1)
        val num2 = findViewById<EditText>(R.id.num2)
        val result = findViewById<TextView>(R.id.result)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)

        btnAdd.setOnClickListener {
            val first = num1.text.toString().toDoubleOrNull()
            val second = num2.text.toString().toDoubleOrNull()
            if (first != null && second != null) {
                result.text = "Result: ${first + second}"
            } else {
                result.text = "Invalid Input"
            }
        }

        btnSubtract.setOnClickListener {
            val first = num1.text.toString().toDoubleOrNull()
            val second = num2.text.toString().toDoubleOrNull()
            if (first != null && second != null) {
                result.text = "Result: ${first - second}"
            } else {
                result.text = "Invalid Input"
            }
        }

        btnMultiply.setOnClickListener {
            val first = num1.text.toString().toDoubleOrNull()
            val second = num2.text.toString().toDoubleOrNull()
            if (first != null && second != null) {
                result.text = "Result: ${first * second}"
            } else {
                result.text = "Invalid Input"
            }
        }

        btnDivide.setOnClickListener {
            val first = num1.text.toString().toDoubleOrNull()
            val second = num2.text.toString().toDoubleOrNull()
            if (first != null && second != null) {
                if (second != 0.0) {
                    result.text = "Result: ${first / second}"
                } else {
                    result.text = "Cannot divide by zero"
                }
            } else {
                result.text = "Invalid Input"
            }
        }
    }
}

