package tn.esprit.checkmybmi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var etWeight: EditText
    private lateinit var etHeight: EditText
    private lateinit var btnCalculateBMI: Button
    private lateinit var tvBMI: TextView
    private lateinit var tvInterpretation: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




//initialise views
        etWeight = findViewById(R.id.etWeight)
        etHeight = findViewById(R.id.etHeight)
        btnCalculateBMI = findViewById(R.id.btnCalculateBMI)
        tvBMI = findViewById(R.id.tvBMI)
        tvInterpretation = findViewById(R.id.tvInterpretation)
        //set click listener on the button
        btnCalculateBMI.setOnClickListener{
            
        }
    }

    private fun CalculateBMi(){

    }
}