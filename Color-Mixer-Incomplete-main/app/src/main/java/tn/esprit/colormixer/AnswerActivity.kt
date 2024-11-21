package tn.esprit.colormixer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.google.android.material.snackbar.Snackbar
import tn.esprit.colormixer.databinding.ActivityAnswerBinding

class AnswerActivity : AppCompatActivity() {

    //TODO 12 Add lateint var for binding
    private lateinit var binding: ActivityAnswerBinding

    private var correctColor = "NONE"
    private var name = "NONE"
    private var color1 = "NONE"
    private var color2 = "NONE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO 13 Bind the view and implement setContentView()
        binding = ActivityAnswerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO 14 Change the value of correctColor / name / color1 / color2 with the DATA from the INTENT
        name = intent.getStringExtra(NAME) ?: "NONE"
        color1 = intent.getStringExtra(COLOR1) ?: "NONE"
        color2 = intent.getStringExtra(COLOR2) ?: "NONE"
        correctColor = when {
            (color1 == BLUE && color2 == YELLOW) || (color1 == YELLOW && color2 == BLUE) -> GREEN
            (color1 == BLUE && color2 == RED) || (color1 == RED && color2 == BLUE) -> PURPLE
            (color1 == RED && color2 == YELLOW) || (color1 == YELLOW && color2 == RED) -> ORANGE
            else -> "NONE"
        }


        //TODO 15 Change the txtChoosed with : "You chose $color1 and $color2"
        binding.txtChoosed.text = "You chose $color1 and $color2"

        //TODO 16 Implement setOnClickListener on the btnSubmit and call checkAnswer()
        // You must check if only one radio button is selected the navigate to the ResultActivity with the data name and RESULT (FAILED/SUCCESS)
        binding.btnSubmit.setOnClickListener {
            if (checkSelectedRadioButton()) {
                val result = if (checkAnswer()) SUCCESS else FAILED
                val resultIntent = Intent(this, ResultActivity::class.java).apply {
                    putExtra(NAME, name)
                    putExtra(RESULT, result)
                }
                startActivity(resultIntent)
            }
            }
    }

    private fun checkSelectedRadioButton(): Boolean {
        // Check if a radio button is selected
        val selectedId = binding.radioGroup.checkedRadioButtonId
        if (selectedId == -1) {
            Snackbar.make(binding.root, "Please select one color!", Snackbar.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun checkAnswer(): Boolean {
        //TODO 17 Check if the answer of the chosen color is correct
        // Récupérer l'ID du bouton radio sélectionné
        val selectedId = binding.radioGroup.checkedRadioButtonId
        return when (selectedId) {
                R.id.rbPurple -> (correctColor == PURPLE)
                R.id.rbGreen -> (correctColor == GREEN)
                R.id.rbOrange -> (correctColor == ORANGE)
                else -> false
        }
    }
}