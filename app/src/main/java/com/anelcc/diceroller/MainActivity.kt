package com.anelcc.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage = findViewById(R.id.dice_image)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.text = "Let's Roll"

        rollButton.setOnClickListener(){
            rollDice()
        }
        diceImage.setOnClickListener(){
            getDiceImageNumber()
        }

    }

    private fun getDiceImageNumber() {
        val number = when (diceImage.id) {
            R.drawable.dice_1 -> 1
            R.drawable.dice_2 -> 2
            R.drawable.dice_3 -> 3
            R.drawable.dice_4 -> 4
            R.drawable.dice_5 -> 5
            else -> 6
        }

        Toast.makeText(this, "Dice number is "+number,Toast.LENGTH_LONG).show()
    }

    private fun rollDice() {
        //val result: TextView =findViewById(R.id.result)
        val randomInt = Random().nextInt(6)+1
       // result.text = randomInt.toString()
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
    }
}
