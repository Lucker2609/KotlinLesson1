package com.example.kotlinlesson1

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.toString as toString1


const val dollar = 74
const val euro = 78
const val pound = 88
const val hryvnia = 3


class MainActivity : AppCompatActivity() {
    private var tvRouble: TextView? = null
    private var tvDollar: TextView? = null

    private var edRouble: EditText? = null

    private var convertResult: Double? = null // ПРОМЕЖУТОЧНЫЙ РЕЗУЛЬТАТ
    private var finalResult: Double? = null
    private var roubles: Double? = null

    private var result: String? = null

    private var index1: Int? = 0
    private var index2: Int? = 0
    private var kurs: Int? = 0
    private var kurs2: Int? = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvRouble = findViewById(R.id.tvRouble)
        tvDollar = findViewById(R.id.tvRouble)
        edRouble = findViewById(R.id.edRouble)


        val currencys =
            arrayOf("Рубль", "Доллар", "Евро", "Фунт", "Гривна") // массив с значениями для спиннера
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, currencys)


        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (currencys.get(position)) {
                    "Доллар" -> {
                        index1 = 1
                        kurs = dollar
                    }
                    "Рубль" -> {
                        index1 = 0
                        kurs = 1
                    }
                    "Евро" -> {
                        index1 = 2
                        kurs = euro
                    }
                    "Фунт" -> {
                        index1 = 3
                        kurs = pound
                    }
                    "Гривна" -> {
                        index1 = 4
                        kurs = hryvnia
                    }
                }
            }
        }
        spinner3.adapter = arrayAdapter
        spinner3.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (currencys.get(position)) {
                    "Доллар" -> {
                        index2 = 1
                        kurs2 = dollar
                    }
                    "Рубль" -> {
                        index2 = 0
                        kurs2 = 1
                    }
                    "Евро" -> {
                        index2 = 2
                        kurs2 = euro
                    }
                    "Фунт" -> {
                        index2 = 3
                        kurs2 = pound
                    }
                    "Гривна" -> {
                        index2 = 4
                        kurs2 = hryvnia
                    }
                }

            }
        }
    }

    fun ConvertRoubles(view: View) {
        Log.d("mLog", "$kurs")
        if (index1 != 0 && index2 != 0 || index1 != 0 && index2 == 0 ) {
            roubles = edRouble?.text.toString1().toDouble()
            convertResult = roubles!! * kurs!!
            var decimal = BigDecimal(convertResult!!).setScale(2, RoundingMode.HALF_EVEN)
            convertResult = decimal.toDouble()
            finalResult = convertResult!! / kurs2!!
            var decimal2 = BigDecimal(finalResult!!).setScale(2, RoundingMode.HALF_EVEN)
            finalResult = decimal2.toDouble()
            tvRouble?.text = finalResult!!.toString()

        } else if (index1 == 0 && index2 != 0 || index1 == 0 && index2 == 0) {
            roubles = edRouble?.text.toString1().toDouble()
            convertResult = roubles!! / kurs2!!
            var decimal = BigDecimal(convertResult!!).setScale(2, RoundingMode.HALF_EVEN)
            convertResult = decimal.toDouble()
            tvRouble?.text = convertResult!!.toString()
        }


    }


}



