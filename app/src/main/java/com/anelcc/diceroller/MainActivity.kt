package com.anelcc.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage = findViewById(R.id.dice_image)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.text = "Let's Roll"

        val resetButton: Button = findViewById(R.id.reset_button)

        rollButton.setOnClickListener(){
            rollDice()
        }
        resetButton.setOnClickListener(){
            reset()
        }
    }

    private fun reset() {
        diceImage.setImageResource(getDrawableResource(0))
    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6)+1
        diceImage.setImageResource(getDrawableResource(randomInt))
    }

    private fun getDrawableResource(randomInt: Int): Int {
        return when (randomInt) {
            0 -> R.drawable.empty_dice
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}
