package com.example.calculatorapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var calcString: TextView
    private var result:Float = 0f
    private var actionClicked: Boolean = false
    private var operString: String = ""
    private lateinit var currentNumber:String

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calcString = findViewById(R.id.display_calc)
        currentNumber = calcString.text.toString()

        findViewById<TextView>(R.id.number_1).setOnClickListener {
            setText("1")
        }
        findViewById<TextView>(R.id.number_2).setOnClickListener {
            setText("2")
        }
        findViewById<TextView>(R.id.number_3).setOnClickListener {
            setText("3")
        }
        findViewById<TextView>(R.id.number_4).setOnClickListener {
            setText("4")
        }
        findViewById<TextView>(R.id.number_5).setOnClickListener {
            setText("5")
        }
        findViewById<TextView>(R.id.number_6).setOnClickListener {
            setText("6")
        }
        findViewById<TextView>(R.id.number_7).setOnClickListener {
            setText("7")
        }
        findViewById<TextView>(R.id.number_8).setOnClickListener {
            setText("8")
        }
        findViewById<TextView>(R.id.number_9).setOnClickListener {
            setText("9")
        }
        findViewById<TextView>(R.id.number_0).setOnClickListener {
            setText("0")
        }
        findViewById<TextView>(R.id.clear_text).setOnClickListener {
            result = 0f
            currentNumber = "0"
            actionClicked = false
            calcString.text = "0"
            operString = ""
        }
//        findViewById<TextView>(R.id.cut_text).setOnClickListener {
//           cutText()
//        }
        findViewById<TextView>(R.id.addition_text).setOnClickListener{
            val str = calcString.text.toString() + " + "
            calcString.text = str

            changeCalculation()
            operString = "+"
            actionClicked = true
            currentNumber = ""
        }
        findViewById<TextView>(R.id.subtract_text).setOnClickListener{
            val str = calcString.text.toString() + " - "
            calcString.text = str

            changeCalculation()
            operString = "_"
            actionClicked = true
            currentNumber = ""
        }
        findViewById<TextView>(R.id.multiply_text).setOnClickListener{
            val str = calcString.text.toString() + " * "
            calcString.text = str

            changeCalculation()
            operString = "*"
            actionClicked = true
            currentNumber = ""
        }
        findViewById<TextView>(R.id.divide_text).setOnClickListener{
            val str = calcString.text.toString() + " / "
            calcString.text = str

            changeCalculation()
            operString = "/"
            actionClicked = true
            currentNumber = ""
        }
        findViewById<TextView>(R.id.modulus_text).setOnClickListener{
            val str = calcString.text.toString() + " % "
            calcString.text = str

            changeCalculation()
            operString = "%"
            actionClicked = true
            currentNumber = ""
        }
        findViewById<TextView>(R.id.equalToText).setOnClickListener{
            if(currentNumber != "") {
                changeCalculation()
                val str = calcString.text.toString() + "\n = "
                calcString.text = str + result.toString()
            }
        }

    }


    private fun setText(string: String) {
        if(calcString.text == "0"){
            calcString.text = string
            currentNumber = string
            result += string.toFloat()
        }
        else{
            val str = calcString.text.toString() + string
            calcString.text = str
            currentNumber += string
        }

    }

    private fun changeCalculation() {
        if(actionClicked && currentNumber != "") {
            when (operString) {
                "+" -> result += currentNumber.toFloat()
                "_" -> result -= currentNumber.toFloat()
                "*" -> result *= currentNumber.toFloat()
                "/" -> result /= currentNumber.toFloat()
                "%" -> result %= currentNumber.toFloat()
            }
            currentNumber = ""
            actionClicked = false
        }
        else if(!actionClicked && currentNumber != "") {
            result = currentNumber.toFloat()
            currentNumber = ""
        }
    }
}