package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import com.example.exercise1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonCalculate.setOnClickListener{

            val carLoan = (binding.editTextCarPrice.text.toString().toDouble() ) - (binding.editTextDownPayment.text.toString().toDouble())
            val interest = carLoan * (binding.editTextInterestRate.text.toString().toDouble()) * (binding.editTextLoanPeriod.text.toString().toDouble())
            val monthRepay = (carLoan + interest) / (binding.editTextLoanPeriod.text.toString().toDouble()) / 12
            binding.textViewLoan.text = "Loan : " + carLoan.toString()
            binding.textViewInterest.text = "Interest : " + interest.toString()
            binding.textViewMonthlyRepayment.text = "Monthly Repayment : " + monthRepay.toString()

        }

        binding.buttonReset.setOnClickListener{
            binding.editTextCarPrice.setText("")
            binding.editTextDownPayment.setText("")
            binding.editTextInterestRate.setText("")
            binding.editTextLoanPeriod.setText("")
            binding.textViewLoan.text = "Loan : "
            binding.textViewMonthlyRepayment.text = "Monthly Repayment : "
            binding.textViewInterest.text = "Interest : "
        }
    }
}


