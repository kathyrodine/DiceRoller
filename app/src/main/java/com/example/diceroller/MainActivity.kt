package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result on the screen
 **/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDiceA();rollDiceB()}

        //Do a dice roll when the app starts
        rollDiceA()
        rollDiceB()
    }

    /**
     * Roll the dice and update the screen with the result
     **/
    private fun rollDiceA() {
        //Create a Dice object with 6 sides and roll the dice
        val diceA = DiceA(6)
        val diceARoll: Int = diceA.rollA()

        //Find the ImageView in the layout
        val diceAImage: ImageView = findViewById(R.id.imageView)

        //Determine which drawable resource ID to use based on the dice roll
        val drawableResourceA = when (diceARoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //Update the ImageView with the correct drawable resource
        diceAImage.setImageResource(drawableResourceA)
        //Update the content description
        diceAImage.contentDescription = diceARoll.toString()
        println("Testing println()")

    }

    private fun rollDiceB() {
        //Create another new Dice object with 6 sides and roll the dice
        val diceB = DiceB(6)
        val diceBRoll: Int = diceB.rollB()

        //Find the ImageView in the layout
        val diceBImage: ImageView = findViewById(R.id.imageView2)

        val drawableResourceB = when (diceBRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //Update the ImageView with the correct drawable resource for B
        diceBImage.setImageResource(drawableResourceB)

        //Update the content description for B
        diceBImage.contentDescription = diceBRoll.toString()
    }

    class DiceA(private val numSides: Int) {
        fun rollA(): Int {
            return (1..numSides).random()
        }
    }
    class DiceB(private val numSides: Int) {
        fun rollB(): Int {
                return (1..numSides).random()
        }
    }
}