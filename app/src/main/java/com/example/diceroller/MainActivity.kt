package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result on the screen
 **/

class MainActivity : AppCompatActivity() {

    lateinit var dice1Image: ImageView
    lateinit var dice2Image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }

        dice1Image = findViewById(R.id.diceOneImageView)
        dice2Image = findViewById(R.id.diceTwoImageView)
    }

    private fun rollDice() {
        val dieOne = rollDie()
        val dieTwo = rollDie()

        val dieOneImage = getDieImage(dieOne)
        val dieTwoImage = getDieImage(dieTwo)

        setDieImage(dice1Image, dieOneImage, dieOne)
        setDieImage(dice2Image, dieTwoImage, dieTwo)
    }

    private fun rollDie() : Int {
        return Dice(6).roll()
    }

    private fun getDieImage(diceRoll: Int): Int {
        return when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    private fun setDieImage(diceImageView: ImageView, dieImage: Int, diceRoll: Int) {
        diceImageView.setImageResource(dieImage)
        diceImageView.contentDescription = diceRoll.toString()
    }

    class Dice(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}