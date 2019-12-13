package com.example.insurancecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.text.Typography.less

class MainActivity : AppCompatActivity() {
    lateinit var myData: PremiumModel
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myData = ViewModelProviders.of(this).get(PremiumModel::class.java)

        display()

        buttonCalculate.setOnClickListener(){
            price.text= "RM %.2f".format(getPremium())
            myData.premiumAmount = getPremium()
            display()
        }

//        buttonCalculate.setOnClickListener(){
//            var total = 0
//            //var extra = 0
//            when{
//                spinnerAge.selectedItemPosition == 0 -> {
//                    total += 60
//                }
//                spinnerAge.selectedItemPosition == 1 -> {
//                    total += 70
//                    if(radioButtonMale.isChecked){
//                        total += 50
//                    }
//                    if(checkBoxSmoker.isChecked){
//                        total += 100
//                    }
//                }
//                spinnerAge.selectedItemPosition == 2 -> {
//                    total += 90
//                    if(radioButtonMale.isChecked){
//                        total += 100
//                    }
//                    if(checkBoxSmoker.isChecked){
//                        total += 150
//                    }
//                }
//                spinnerAge.selectedItemPosition == 3 -> {
//                    total += 120
//                    if(radioButtonMale.isChecked)
//                        total += 150
//                    if(checkBoxSmoker.isChecked)
//                        total += 200
//                }
//                spinnerAge.selectedItemPosition == 4 -> {
//                    total += 150
//                    if(radioButtonMale.isChecked)
//                        total += 200
//                    if(checkBoxSmoker.isChecked)
//                        total += 250
//                }
//                spinnerAge.selectedItemPosition == 5 -> {
//                    total += 150
//                    if(radioButtonMale.isChecked)
//                        total += 200
//                    if(checkBoxSmoker.isChecked)
//                        total += 300
//                }
//            }
//
//
//
//
//        }
        buttonReset.setOnClickListener(){
            spinnerAge.setSelection(0)
            radioGroupGender.clearCheck()
            checkBoxSmoker.isChecked = false
            myData.premiumAmount = 0.0
        }
    }
    private fun display(){
        if(myData.premiumAmount != 0.0)
            price.text = "RM " + myData.premiumAmount.toString()
    }


    private fun getPremium() : Double{
        return when(spinnerAge.selectedItemPosition){
            0 -> 60.00
            1 -> 70.00 +
                    (if(radioButtonMale.isChecked) 50.00 else 0.0) +
                    (if(checkBoxSmoker.isChecked) 100.00 else 0.0)
            2 -> 90.00 +
                    (if(radioButtonMale.isChecked) 100.00 else 0.0) +
                    (if(checkBoxSmoker.isChecked) 150.00 else 0.0)
            3 -> 120.00 +
                    (if(radioButtonMale.isChecked) 150.00 else 0.0) +
                    (if(checkBoxSmoker.isChecked) 200.00 else 0.0)
            4 -> 150.00 +
                    (if(radioButtonMale.isChecked) 200.00 else 0.0) +
                    (if(checkBoxSmoker.isChecked) 250.00 else 0.0)
            else -> 150.00 +
                    (if(radioButtonMale.isChecked) 200.00 else 0.0) +
                    (if(checkBoxSmoker.isChecked) 300.00 else 0.0)
        }
        display()
    }


}
