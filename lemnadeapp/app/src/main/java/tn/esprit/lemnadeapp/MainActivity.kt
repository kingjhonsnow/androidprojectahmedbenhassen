package tn.esprit.lemnadeapp

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView


import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var BUTTON:Button
    lateinit var image1: ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        image1 = findViewById(R.id.imageView2)
        textView=findViewById(R.id.textView2)
        BUTTON=findViewById(R.id.Button2)
       BUTTON.setOnClickListener{
           val myintent=Intent(this,Juce::class.java)
           startActivity(myintent)
       }
    }
}