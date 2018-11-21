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

class MainActivity : AppCompatActivity() {
    var str: StringBuilder = java.lang.StringBuilder();

    @SuppressLint("SetTextI18n", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn1: Button = findViewById(R.id.button1)
        var btn2: Button = findViewById(R.id.button2)
        var btn3: Button = findViewById(R.id.button3)
        var btn4: Button = findViewById(R.id.button5)
        var btn5: Button = findViewById(R.id.button6)
        var btn6: Button = findViewById(R.id.button7)
        var btn7: Button = findViewById(R.id.button9)
        var btn8: Button = findViewById(R.id.button10)
        var btn9: Button = findViewById(R.id.button12)
        var btn0: Button = findViewById(R.id.button14)
        var btnplus: Button = findViewById(R.id.button4)
        var btnminus: Button = findViewById(R.id.button8)
        var btnmul: Button = findViewById(R.id.button11)
        var btndiv: Button = findViewById(R.id.button1)
        var btnequel: Button = findViewById(R.id.button16)
        var btndel: Button = findViewById(R.id.button17)
        var btnleft: Button = findViewById(R.id.button13)
        var btnrigth: Button = findViewById(R.id.button15)
        var btnpoint: Button = findViewById(R.id.button19)
        var view1 : TextView = findViewById(R.id.view1)

        if (str.isEmpty()) {
            view1.text = "write"
        } else {
            view1.text = str.toString()
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("str", str.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        str = StringBuilder(savedInstanceState.getInt("count"))
    }

    fun putPoint(view: View){
        str.append('.');
        view1.text = str.toString()
    }
    fun putOne(view: View) {
        str.append('1')
        view1.text = str.toString()

    }

    fun putTwo(view: View) {
        str.append('2')
        view1.text = str.toString()
    }

    fun putThree(view: View) {
        str.append('3')
        view1.text = str.toString()
    }

    fun putFour(view: View) {
        str.append('4')
        view1.text = str.toString()
    }

    fun putFive(view: View) {
        str.append('5')
        view1.text = str.toString()
    }

    fun putSix(view: View) {
        str.append('6')
        view1.text = str.toString()
    }

    fun putSeven(view: View) {
        str.append('7')
        view1.text = str.toString()
    }

    fun putEight(view: View) {
        str.append('8')
        view1.text = str.toString()
    }

    fun putNine(view: View) {
        str.append('9')
        view1.text = str.toString()
    }

    fun putZero(view: View) {
        str.append('0')
        view1.text = str.toString()
    }

    fun putPlus(view: View) {
        str.append('+')
        view1.text = str.toString()
    }

    fun putMinus(view: View) {
        str.append('-')
        view1.text = str.toString()
    }

    fun putMult(view: View) {
        str.append('*')
        view1.text = str.toString()
    }

    fun putDiv(view: View) {
        str.append('/')
        view1.text = str.toString()
    }

    fun putLBr(view: View) {
        str.append('(')
        view1.text = str.toString()
    }


    fun putRbr(view: View) {
        str.append(')')
        view1.text = str.toString()
    }

    fun putDel(view: View) {
        if (!str.isEmpty()) {
            str.deleteCharAt(str.lastIndex)
            view1.text = str.toString()
        }else{
            view1.text = "0"
        }
    }

    fun putCulc(view: View)  {
        if(!str.isEmpty()) {
            val parser = ExpressionParser()
            try {
                val ret: Double = parser.parse(str.toString()).evaluate()
                str = StringBuilder(ret.toString())
                view1.text = str.toString()
            } catch (e: MyExceptions) {
                view1.text = e.message
                str = StringBuilder()
            }
        }

    }

}
