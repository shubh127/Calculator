package com.shubham.calculatorkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
import java.text.NumberFormat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {

        btn_0.setOnClickListener(this)
        btn_1.setOnClickListener(this)
        btn_2.setOnClickListener(this)
        btn_3.setOnClickListener(this)
        btn_4.setOnClickListener(this)
        btn_5.setOnClickListener(this)
        btn_6.setOnClickListener(this)
        btn_7.setOnClickListener(this)
        btn_8.setOnClickListener(this)
        btn_9.setOnClickListener(this)

        btn_dot.setOnClickListener(this)
        btn_negation.setOnClickListener(this)

        btn_add.setOnClickListener(this)
        btn_minus.setOnClickListener(this)
        btn_product.setOnClickListener(this)
        btn_divide.setOnClickListener(this)
        btn_modulus.setOnClickListener(this)
        btn_equals.setOnClickListener(this)

        btn_clear.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_0 -> {
                numberClickHandle("0")
            }
            R.id.btn_1 -> {
                numberClickHandle("1")
            }
            R.id.btn_2 -> {
                numberClickHandle("2")
            }
            R.id.btn_3 -> {
                numberClickHandle("3")
            }
            R.id.btn_4 -> {
                numberClickHandle("4")
            }
            R.id.btn_5 -> {
                numberClickHandle("5")
            }
            R.id.btn_6 -> {
                numberClickHandle("6")
            }
            R.id.btn_7 -> {
                numberClickHandle("7")
            }
            R.id.btn_8 -> {
                numberClickHandle("8")
            }
            R.id.btn_9 -> {
                numberClickHandle("9")
            }
            R.id.btn_dot -> {
                numberClickHandle(".")
            }
            R.id.btn_negation -> {
                numberClickHandle("negation")
            }
            R.id.btn_add -> {
                operationClickHandle("+")
            }
            R.id.btn_minus -> {
                operationClickHandle("-")
            }
            R.id.btn_product -> {
                operationClickHandle("*")
            }
            R.id.btn_divide -> {
                operationClickHandle("/")
            }
            R.id.btn_modulus -> {
                performPercentageOperation()
            }
            R.id.btn_equals -> {
                performEqualsOperation()
            }
            R.id.btn_clear -> {
                performClearOperation()
            }
        }
    }

    fun numberClickHandle(value: String) {
        if (isNewOperator) {
            et_show_number.setText("0")
        }
        isNewOperator = false
        var btnClickedValue: String = et_show_number.text.toString()
        when (value) {
            "0" -> {
                btnClickedValue += "0"
            }
            "1" -> {
                btnClickedValue += "1"
            }
            "2" -> {
                btnClickedValue += "2"
            }
            "3" -> {
                btnClickedValue += "3"
            }
            "4" -> {
                btnClickedValue += "4"
            }
            "5" -> {
                btnClickedValue += "5"
            }
            "6" -> {
                btnClickedValue += "6"
            }
            "7" -> {
                btnClickedValue += "7"
            }
            "8" -> {
                btnClickedValue += "8"
            }
            "9" -> {
                btnClickedValue += "9"
            }
            "." -> {
                if (!btnClickedValue.contains(".", true)) {
                    btnClickedValue += "."
                }
            }
            "negation" -> {
                if (btnClickedValue.contains(".", true)) {
                    btnClickedValue = (btnClickedValue.toFloat() * -1).toString()
                } else {
                    btnClickedValue = (btnClickedValue.toInt() * -1).toString()
                }
            }
        }
        if (btnClickedValue[0].equals('0')) {
            btnClickedValue = btnClickedValue.substring(1, btnClickedValue.length)
        }
        et_show_number.setText(btnClickedValue)
    }

    var operator = "*"
    var oldNumber = ""
    var isNewOperator = true
    val nf: NumberFormat = DecimalFormat("##.###")
    fun operationClickHandle(value: String) {
        when (value) {
            "+" -> {
                operator = "+"
            }
            "-" -> {
                operator = "-"
            }
            "*" -> {
                operator = "*"
            }
            "/" -> {
                operator = "/"
            }
        }
        oldNumber = et_show_number.text.toString()
        isNewOperator = true
    }

    fun performEqualsOperation() {
        val newNumber = et_show_number.text.toString()
        var finalNumber: Double? = null
        when (operator) {
            "+" -> {
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
            "-" -> {
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            "*" -> {
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "/" -> {
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
        }
        et_show_number.setText((nf.format(finalNumber)).toString())
        isNewOperator = true
    }

    fun performPercentageOperation() {
        val number: Double = et_show_number.text.toString().toDouble() / 100

        et_show_number.setText((nf.format(number)).toString())
        isNewOperator = true
    }

    fun performClearOperation() {
        et_show_number.setText("0")
        isNewOperator = true
    }
}
