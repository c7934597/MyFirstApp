package com.myandroid.myfirstapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //宣告介面元件相同型態的物件
    private var mEdtSex: EditText? = null
    private var mEdtAge: EditText? = null
    private var mTxtR: TextView? = null
    private var mBtnOK: Button? = null
    private val btnOKOnClick = View.OnClickListener {
        //按下按鈕後要執行的程式碼
        val strSex = mEdtSex!!.text.toString()
        val iAge = Integer.parseInt(mEdtAge!!.text.toString())

        var strSug = getString(R.string.subjuect)
        if (strSex == getString(R.string.sex_male))
            if (iAge < 28) {
                strSug += getString(R.string.sug_not_hurry)
                Log.d("MarrisSug", "man, 1")
            } else if (iAge > 33) {
                strSug += getString(R.string.sug_get_married)
                Log.d("MarrisSug", "man, 2")
            } else {
                strSug += getString(R.string.sug_find_couple)
                Log.d("MarrisSug", "man, 3")
            }
        else {
            if (iAge < 25) {
                strSug += getString(R.string.sug_not_hurry)
                Log.d("MarrisSug", "woman, 1")
            } else if (iAge > 30) {
                strSug += getString(R.string.sug_get_married)
                Log.d("MarrisSug", "woman, 2")
            } else {
                strSug += getString(R.string.sug_find_couple)
                Log.d("MarrisSug", "woman, 3")
            }
        }

        mTxtR!!.text = strSug
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //利用findViewById() 取得介面元件 並設定給對應的物件
        //記得要轉型 (粗體標示的部分)
        mEdtSex = findViewById<View>(R.id.edtSex) as EditText
        mEdtAge = findViewById<View>(R.id.edtAge) as EditText
        mTxtR = findViewById<View>(R.id.txtR) as TextView
        mBtnOK = findViewById<View>(R.id.btnOK) as Button

        mBtnOK!!.setOnClickListener(btnOKOnClick)
    }
}
