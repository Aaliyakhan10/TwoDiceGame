package com.example.twodicegame

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.twodicegame.databinding.ActivityMainBinding
import kotlin.random.Random
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var count = 1
        var score1 = 0
        var score2 = 0
        binding.tvP.text = "Player 1"
        binding.btnR.setOnClickListener {
            if (count <= 2) {
                val num1 = Random.nextInt(1, 7)
                val num2 = Random.nextInt(1, 7)
                val drawableImg1 = when (num1) {
                    1 -> R.drawable.one
                    2 -> R.drawable.two
                    3 -> R.drawable.three
                    4 -> R.drawable.four
                    5 -> R.drawable.five
                    6 -> R.drawable.six
                    else -> {
                        Toast.makeText(this, "Roll Again", Toast.LENGTH_SHORT).show()
                        R.drawable.five
                    }
                }
                val drawableImg2 = when (num2) {
                    1 -> R.drawable.one
                    2 -> R.drawable.two
                    3 -> R.drawable.three
                    4 -> R.drawable.four
                    5 -> R.drawable.five
                    6 -> R.drawable.six
                    else -> {
                        Toast.makeText(this, "Roll Again", Toast.LENGTH_SHORT).show()
                        R.drawable.six

                    }
                }



                binding.diceA.setImageResource(drawableImg1)
                binding.diceB.setImageResource(drawableImg2)


                if (count == 1) {

                    binding.tvP.text = "Player 2"
                    score1 = num1 + num2
                    binding.tvS1.text = score1.toString()


                } else {
                    score2 = num1 + num2
                    binding.tvS2.text = score2.toString()
                }
                if(count==2){
                    if (score1 > score2) {
                        binding.tvR.text = "Player 1 win "
                    } else if (score1 == score2) {
                        binding.tvR.text = "Tied..."
                    } else {
                        binding.tvR.text = "Player 2 win"
                    }
                    binding.llV.visibility = View.VISIBLE
                    binding.btnR.visibility = View.INVISIBLE
                }
                count += 1


            }
        }
        binding.btnPa.setOnClickListener {
            count = 1
            score1 = 0
            score2 = 0
            binding.tvR.text = ""
            binding.tvP.text = "Player 1"
            binding.tvS1.text = score1.toString()
            binding.tvS2.text = score2.toString()
            binding.llV.visibility = View.INVISIBLE
            binding.btnR.visibility = View.VISIBLE


        }
        binding.btnE.setOnClickListener {
            this@MainActivity.finish()

            exitProcess(0)

        }


    }
}

