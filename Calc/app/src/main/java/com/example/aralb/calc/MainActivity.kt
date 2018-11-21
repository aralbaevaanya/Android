package com.example.aralb.calc

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import expression.MyExceptions
import kotlinx.android.synthetic.main.activity_main.*
import parser.ExpressionParser

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MainActivity : AppCompatActivity() {
    var str: StringBuilder = java.lang.StringBuilder()
    val parser = ExpressionParser()

    @SuppressLint("SetTextI18n", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myText : TextView = myText

        if (str.isEmpty()) {
            myText.text = "write"
        } else {
            myText.text = str.toString()
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("str",str.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        str = java.lang.StringBuilder()
        if ( savedInstanceState.getString("str") != null ){
            str = java.lang.StringBuilder(savedInstanceState.getString("str"))
        }
        myText.text = str.toString()

    }

    fun putPoint(view: View){
        str.append('.')
        myText.text = str.toString();
    }

    fun putOne(view: View) {
        str.append('1')
        myText.text = str.toString()

    }

    fun putTwo(view: View) {
        str.append('2')
        myText.text = str.toString()
    }

    fun putThree(view: View) {
        str.append('3')
        myText.text = str.toString()
    }

    fun putFour(view: View) {
        str.append('4')
        myText.text = str.toString()
    }

    fun putFive(view: View) {
        str.append('5')
        myText.text = str.toString()
    }

    fun putSix(view: View) {
        str.append('6')
        myText.text = str.toString()
    }

    fun putSeven(view: View) {
        str.append('7')
        myText.text = str.toString()
    }

    fun putEight(view: View) {
        str.append('8')
        myText.text = str.toString()
    }

    fun putNine(view: View) {
        str.append('9')
        myText.text = str.toString()
    }

    fun putZero(view: View) {
        str.append('0')
        myText.text = str.toString()
    }

    fun putPlus(view: View) {
        str.append('+')
        myText.text = str.toString()
    }

    fun putMinus(view: View) {
        str.append('-')
        myText.text = str.toString()
    }

    fun putMult(view: View) {
        str.append('*')
        myText.text = str.toString()
    }

    fun putDiv(view: View) {
        str.append('/')
        myText.text = str.toString()
    }

    fun putLBr(view: View) {
        str.append('(')
        myText.text = str.toString()
    }


    fun putRbr(view: View) {
        str.append(')')
        myText.text = str.toString()
    }

    fun putDel(view: View) {
        if (!str.isEmpty()) {
            str.deleteCharAt(str.lastIndex)
            myText.text = str.toString()
        }else{
            myText.text = "0"
        }
    }

    fun putCalc(view: View)  {
        if(!str.isEmpty()) {
            try {
                val ret: Double = parser.parse(str.toString()).evaluate()
                str = StringBuilder(ret.toString())
                myText.text = str.toString()
            } catch (e: MyExceptions) {
                myText.text = e.message
                str = StringBuilder()
            }
        }

    }

}
