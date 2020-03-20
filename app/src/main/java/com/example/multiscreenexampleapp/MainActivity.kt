package com.example.multiscreenexampleapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mBtnRunCode: Button
    lateinit var mBtnClear: Button
    lateinit var mTxtOutput:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initViews()

        mBtnRunCode.setOnClickListener {
            //function for run code button


        }

        mBtnClear.setOnClickListener {
            //function for clear button


        }

    }

    private fun showOutput(output:String){
        if(mTxtOutput.text.equals("Ready to Learn!"))
            mTxtOutput.text=""

        mTxtOutput.append("$output \n")

    }

    private fun initViews() {
        mBtnRunCode=findViewById(R.id.btn_run_code)
        mBtnClear=findViewById(R.id.btn_clear)
        mTxtOutput=findViewById(R.id.text_out)
    }

}
