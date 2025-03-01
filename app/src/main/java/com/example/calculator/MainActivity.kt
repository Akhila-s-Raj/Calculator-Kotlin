package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {
    private lateinit var display: TextView
    private var expression = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)

        val buttons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
            R.id.btnAdd, R.id.btnSubtract, R.id.btnMultiply, R.id.btnDivide
        )

        buttons.forEach { id ->
            findViewById<Button>(id).setOnClickListener {
                val buttonText = (it as Button).text.toString()
                expression.append(buttonText)
                display.text = expression.toString()
            }
        }

        findViewById<Button>(R.id.btnEquals).setOnClickListener {
            try {
                val result = Expression(expression.toString().replace("÷", "/").replace("×", "*")).calculate()
                display.text = getString(R.string.result_text) + " " + result.toString() // Updated line
                expression.clear().append(result)
            } catch (e: Exception) {
                display.text = "Error"
                expression.clear()
            }
        }

        findViewById<Button>(R.id.btnClear).setOnClickListener {
            expression.clear()
            display.text = "0"
        }
    }
}
