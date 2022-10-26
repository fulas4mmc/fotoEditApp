package com.example.fotoeditapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mImageView = findViewById<ImageView>(R.id.obrazek)
        val mEditText = findViewById<EditText>(R.id.edit_text_1)
        val mButton = findViewById<Button>(R.id.button1)
        val mSeekBar = findViewById<SeekBar>(R.id.przezroczystosc)
        mSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) { mImageView.setAlpha(p1)
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        // When button is clicked
        mButton.setOnClickListener {
            // EditText value is converted to
            // float and rotation is applied
            if (mEditText.text.isNotEmpty()) {
                val mAngleRotate = (mEditText.text.toString() + "f").toFloat()
                mImageView.rotation = mAngleRotate
            } else {
                Toast.makeText(applicationContext, "Field cannot be empty", Toast.LENGTH_SHORT)
                    .show()
            }
        }


    }
}