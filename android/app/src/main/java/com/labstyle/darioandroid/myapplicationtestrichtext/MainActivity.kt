package com.labstyle.darioandroid.myapplicationtestrichtext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.labstyle.darioandroid.dariorichtextclickable.DarioRichTextClickable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val richText = "The <b>quick</b> <span style='color:#a52a2a;'>brown</span> <i>fox</i> jumps <a href='#'>over</a> <u>the</u> <a href='#'>lazy dog</a>."
        findViewById<TextView>(R.id.textview01)?.let { textview ->
            DarioRichTextClickable.transform(textview, richText, listOf(
                Runnable {
                    Log.d("rafff", "1st handler")
                },
                Runnable {
                    Log.d("rafff", "2nd handler")
                }
            ))
        }

    }
}