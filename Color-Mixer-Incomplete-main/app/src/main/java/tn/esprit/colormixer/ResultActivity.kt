package tn.esprit.colormixer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import tn.esprit.colormixer.databinding.ActivityResultBinding // Assurez-vous d'importer le bon package

class ResultActivity : AppCompatActivity() {

    //TODO 18 Add lateinit var for binding
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO 19 Bind the view and implement setContentView()
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO 20 Check the RESULT from the intent and change rlBackground BackgroundColor / btnQuit BackgroundColor / imgResult / txtResult / txtName / txtAnswer
        val name = intent.getStringExtra(NAME) ?: "UNKNOWN"
        val result = intent.getStringExtra(RESULT) ?: FAILED

        binding.txtName.text = ""

        if (result == SUCCESS) {
            setupSuccessView(name)
        } else {
            setupWrongView(name)
        }

        //TODO 21 Implement setOnClickListener for btnQuit to destroy the activity
        binding.btnQuit.setOnClickListener {
            finish() // Ferme l'activité actuelle
        }
    }

    private fun setupSuccessView(name :String) {
        binding.rlBackground.setBackgroundColor(ContextCompat.getColor(this, R.color.success))
        binding.txtResult.text = "SUCCESS"
        binding.txtAnswer.text = "Congratulations $name!\n"+"Your answer is correct!"
        binding.imgResult.setImageResource(R.drawable.ic_success) // Assurez-vous d'avoir cette image
        binding.btnQuit.setBackgroundColor(ContextCompat.getColor(this, R.color.success))
    }

    private fun setupWrongView(name :String) {
        binding.rlBackground.setBackgroundColor(ContextCompat.getColor(this, R.color.error))
        binding.txtResult.text = "WRONG"
        binding.txtAnswer.text = "Sorry $name!\n" + "Your answer is correct!"
        binding.imgResult.setImageResource(R.drawable.ic_failure) // Assurez-vous d'avoir cette image
        binding.btnQuit.setBackgroundColor(ContextCompat.getColor(this, R.color.error))
    }
}
