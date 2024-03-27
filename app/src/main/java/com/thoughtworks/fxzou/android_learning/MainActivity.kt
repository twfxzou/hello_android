package com.thoughtworks.fxzou.android_learning

import android.content.Intent
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
import com.thoughtworks.fxzou.android_learning.activities.RelativeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val linearLayout = findViewById<LinearLayout>(R.id.button_list)
        1.rangeTo(20).forEach{
            val newButton = Button(this)
            newButton.text = resources.getString(R.string.button_label, it)
            newButton.width = MATCH_PARENT
            newButton.height = WRAP_CONTENT
            newButton.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.gray))
            if (it == 5) {
                newButton.setOnClickListener {
                    startActivity(Intent(this, RelativeActivity::class.java))
                }
            }
            linearLayout.addView(newButton)
        }
    }
}