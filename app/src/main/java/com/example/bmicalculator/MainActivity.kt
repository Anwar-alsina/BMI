package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val weight = binding.edWeight
        val height = binding.edHeight
        val bmiResult = binding.tvResult
        val bmiStatus = binding.tvBmiStatus
        val calculate = binding.btnCalculate
        
        calculate.setOnClickListener{
            var weightValue = 0.0
            var heightValue = 0.0
            if (weight.text.toString().isNotEmpty()){
                weightValue = weight.text.toString().toDouble()
            }
            if (height.text.toString().isNotEmpty()){
                heightValue = height.text.toString().toDouble()/100
            }
            if (weightValue > 0.0 && heightValue > 0.0){
                val bmiValue = (weightValue/heightValue * heightValue)
                bmiResult.text = bmiValue.toString()
                bmiStatus.text = bmiStatusValue(weightValue/heightValue * heightValue)
            } else
                Toast.makeText(this, "Please Input Weight and Height Values greater than 0", Toast.LENGTH_LONG).show()
        }
        }
    }

    private fun bmiStatusValue(bmi: Double): String {
        lateinit var bmiStatus: String
        if (bmi < 18.5)
            bmiStatus = "Underweight"
        else if (bmi >= 18.5 && bmi < 25)
            bmiStatus = "Normal"
        else if (bmi >= 25 && bmi < 30)
            bmiStatus = "Overweight"
        else if (bmi > 30)
            bmiStatus = "Obese"
        return bmiStatus
    }
