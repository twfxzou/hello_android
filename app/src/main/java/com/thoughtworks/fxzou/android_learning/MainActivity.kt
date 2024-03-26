package com.thoughtworks.fxzou.android_learning

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val linearLayout = findViewById<LinearLayout>(R.id.button_list)
        1.rangeTo(20).forEach{
            val newButton = Button(this)
            newButton.text = resources.getString(R.string.button_label_prefix) + it
            newButton.width = MATCH_PARENT
            newButton.height = WRAP_CONTENT
            newButton.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.gray))
            linearLayout.addView(newButton)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}