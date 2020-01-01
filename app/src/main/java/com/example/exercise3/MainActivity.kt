package com.example.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var spin : Spinner
    lateinit var radioMale: RadioButton
    lateinit var radioFemale : RadioButton
    lateinit var smoke: CheckBox
    lateinit var insurance: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        spin = findViewById(R.id.spinnerAge)

        smoke = findViewById(R.id.checkBoxSmoker)
        radioMale = findViewById(R.id.radioButtonMale)
        radioFemale = findViewById(R.id.radioButtonFemale)
        insurance = findViewById(R.id.textViewPremium)

        buttonCalculate.setOnClickListener{

            var total : Int = 0

            val age = spin.selectedItem.toString()

            if(age == "Less than 17")
            {
                total = condition(60, 0 , 0)
            }
            else if(age == "17 to 25")
            {
                total = condition(70, 50 , 100)
            }
            else if(age == "26 to 30")
            {
                total = condition(90, 100 , 150)
            }
            else if(age == "31 to 40")
            {
                total = condition(120, 150 , 200)
            }
            else if(age == "41 to 55")
            {
                total = condition(150, 200 , 250)
            }
            else
            {
                total = condition(150, 200 , 30)
            }



            insurance.setText("Insurance Premium : RM" + total)




        }


        buttonReset.setOnClickListener{view : View ->


            insurance.setText("Insurance Premium :")
            spin.setSelection(0)
            radioMale.isChecked = false
            radioFemale.isChecked = false
            smoke.isChecked = false


        }




    }

    fun  condition(premium : Int, male : Int, smoker : Int) : Int
    {
        var total : Int = 0

        if(radioMale.isChecked && smoke.isChecked)
        {
            total = premium + male + smoker
        }
        else if(radioMale.isChecked)
        {
            total = premium + male
        }
        else if(smoke.isChecked)
        {
            total = premium + smoker
        }
        else if(radioFemale.isChecked)
        {
            total = premium
        }
        else
        {
            total = 0
        }

        return total
    }
}
