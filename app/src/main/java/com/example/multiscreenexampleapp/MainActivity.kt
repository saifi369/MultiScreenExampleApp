package com.example.multiscreenexampleapp

import android.content.res.Configuration
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mBtnRunCode: Button
    lateinit var mBtnClear: Button
    lateinit var mTxtOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initViews()

        mBtnRunCode.setOnClickListener {
            //function for run code button

            showPixels()
            showScreenDensity()

        }

        mBtnClear.setOnClickListener {
            //function for clear button
            mTxtOutput.text = ""
        }

    }

    private fun showScreenSize() {

        val sizeValue =
            resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK

        val screenSize: String = if (sizeValue == Configuration.SCREENLAYOUT_SIZE_SMALL)
        //show data in separate activities
            "Small Screen"
        else if (sizeValue == Configuration.SCREENLAYOUT_SIZE_NORMAL)
        //show data in separate activities
            "Normal Screen"
        else if (sizeValue == Configuration.SCREENLAYOUT_SIZE_LARGE)
        //show data in side by side fragment in single activity
            "Large Screen"
        else if (sizeValue == Configuration.SCREENLAYOUT_SIZE_XLARGE)
        //show data in side by side fragment in single activity
            "Extra Large Screen"
        else
            "No value"

        showOutput(screenSize)

    }

    private fun showPixels() {

        val displayMetrics: DisplayMetrics = DisplayMetrics()

        this.windowManager.defaultDisplay.getMetrics(displayMetrics)


        // these are absolute pixels
        val pixelHeight = displayMetrics.heightPixels
        val pixelWidth = displayMetrics.widthPixels

        val density = displayMetrics.density

        //these are dp pixels
        val dpWidth = pixelWidth / density
        val dpHeight = pixelHeight / density

        showOutput("Absolute Pixels")
        showOutput("$pixelWidth x $pixelHeight")

        showOutput("DP Pixels")
        showOutput("$dpWidth x $dpHeight")


    }

    fun showScreenDensity() {
        val displayMetrics: DisplayMetrics = DisplayMetrics()

        windowManager.defaultDisplay.getMetrics(displayMetrics)

        val density = displayMetrics.density

        Toast.makeText(this, "DPI $density", Toast.LENGTH_LONG).show()

        if (density.equals(DisplayMetrics.DENSITY_MEDIUM))
            Toast.makeText(this, "DPI: mdpi", Toast.LENGTH_LONG).show()
        else if (density.equals(DisplayMetrics.DENSITY_XHIGH))
            Toast.makeText(this, "DPI: xhdpi $density", Toast.LENGTH_LONG).show()
        else if (density.equals(DisplayMetrics.DENSITY_XXHIGH))
            Toast.makeText(this, "DPI: xxhdpi", Toast.LENGTH_LONG).show()


//        if (density >= 4.0) {
//            return "xxxhdpi";
//        }
//        if (density >= 3.0) {
//            return "xxhdpi";
//        }
//        if (density >= 2.0) {
//            return "xhdpi";
//        }
//        if (density >= 1.5) {
//            return "hdpi";
//        }
//        if (density >= 1.0) {
//            return "mdpi";
//        }
//        return "ldpi";
//    }


    }

    private fun showOutput(output: String) {
        if (mTxtOutput.text.equals("Ready to Learn!"))
            mTxtOutput.text = ""

        mTxtOutput.append("$output \n")

    }

    private fun initViews() {
        mBtnRunCode = findViewById(R.id.btn_run_code)
        mBtnClear = findViewById(R.id.btn_clear)
        mTxtOutput = findViewById(R.id.text_out)
    }

}
