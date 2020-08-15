package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)

        rollDice() //Starting of Game with a image random
        rollButton.setOnClickListener() { rollDice(); } //It's the action when just have a click on button
    }

    //Function to show images of dice.
    private fun rollDice() {
        val dice = Dice(6)
        var diceRoll = dice.roll()
        //Choose the dice
        val drawableResource = when (diceRoll) {
            1 -> (R.drawable.dice_1)
            2 -> (R.drawable.dice_2)
            3 -> (R.drawable.dice_3)
            4 -> (R.drawable.dice_4)
            5 -> (R.drawable.dice_5)
            else -> (R.drawable.dice_6)
        }
        var diceImage: ImageView = findViewById<ImageView>(R.id.imageView)
        diceImage.setImageResource(drawableResource)

        diceImage.contentDescription = diceRoll.toString() //it's has been used for accessibility
    }

}

//Class Dice used for abstract the OOP
class Dice(private val numSlides: Int) {
    fun roll(): Int {
        return (1..numSlides).random()
    }
}