package com.example.mad_105currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val convertCurrency = findViewById<EditText>(R.id.idConvert)
        val rbUStoEU = findViewById<RadioButton>(R.id.idRadioBtnUStoEU)
        val rbEUtoUS = findViewById<RadioButton>(R.id.idRadioBtnEutoUS)
        val txtResult = findViewById<TextView>(R.id.idResult)
        val convertButton = findViewById<Button>(R.id.idConvertButton)

        convertButton.setOnClickListener {


            val moneyPattern = DecimalFormat("###,####.00")
            val stringCurrency = convertCurrency.text.toString()
            val doubleCurrency = convertCurrency.text.toString().toDouble()
            val conversionRate = 0.91
            var convertNum: Double?


           if (rbUStoEU.isChecked) {
                if (doubleCurrency < 10000) {
                    convertNum = doubleCurrency * conversionRate
                    txtResult.text = "€" + moneyPattern.format(convertNum)
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Amount must be less than $10,000", Toast.LENGTH_LONG
                    ).show()
                }
            }


           if (rbEUtoUS.isChecked) {
                if (doubleCurrency < 10000) {
                    convertNum = doubleCurrency / conversionRate
                    txtResult.text = "$" + moneyPattern.format(convertNum)
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Amount must be less than €10,000", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
