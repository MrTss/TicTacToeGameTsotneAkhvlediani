package com.example.tictactoegame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    private lateinit var Score: TextView
    private lateinit var b1: Button
    private lateinit var b2: Button
    private lateinit var b3: Button
    private lateinit var b4: Button
    private lateinit var b5: Button
    private lateinit var b6: Button
    private lateinit var b7: Button
    private lateinit var b8: Button
    private lateinit var b9: Button
    private lateinit var Reset:Button
    private lateinit var Restart: Button


    private lateinit var tv:TextView

    private var firstPlayerScore = 0
    private var secondPlayerScore = 0


    private var activePlayer = 1

    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val message1 = intent.getStringExtra("EXTRA_MESSAGE1")
        val message2 = intent.getStringExtra("EXTRA_MESSAGE2")

        val FirstName = findViewById<TextView>(R.id.FirstName).apply {
            text = message1

        }

        val SecondName = findViewById<TextView>(R.id.SecondName).apply {
            text = message2
        }

        init()
        reset()
        restart()

    }

        private fun init(){
            tv = findViewById(R.id.Players)
            Restart = findViewById(R.id.Restart)
            b1 = findViewById(R.id.b1)
            b2 = findViewById(R.id.b2)
            b3 = findViewById(R.id.b3)
            b4 = findViewById(R.id.b4)
            b5 = findViewById(R.id.b5)
            b6 = findViewById(R.id.b6)
            b7 = findViewById(R.id.b7)
            b8 = findViewById(R.id.b8)
            b9 = findViewById(R.id.b9)
            Reset = findViewById(R.id.Reset)
            Score = findViewById(R.id.Score)

            b1.setOnClickListener(this)
            b2.setOnClickListener(this)
            b3.setOnClickListener(this)
            b4.setOnClickListener(this)
            b5.setOnClickListener(this)
            b6.setOnClickListener(this)
            b7.setOnClickListener(this)
            b8.setOnClickListener(this)
            b9.setOnClickListener(this)
            Reset.setOnClickListener{
                reset()

            }
            Restart.setOnClickListener{
                restart()
            }


        }

        override fun onClick(clickedView: View?) {

            var buttonNumber = 0

            if (clickedView is Button) {

                when (clickedView.id) {

                    R.id.b1 -> buttonNumber = 1
                    R.id.b2 -> buttonNumber = 2
                    R.id.b3 -> buttonNumber = 3
                    R.id.b4 -> buttonNumber = 4
                    R.id.b5 -> buttonNumber = 5
                    R.id.b6 -> buttonNumber = 6
                    R.id.b7 -> buttonNumber = 7
                    R.id.b8 -> buttonNumber = 8
                    R.id.b9 -> buttonNumber = 9
                }
            }

            if (buttonNumber != 0) {
                playGame(buttonNumber, clickedView as Button)
            }

        }
        fun disabledButtons(){

            b1.isEnabled = false
            b2.isEnabled = false
            b3.isEnabled = false
            b4.isEnabled = false
            b5.isEnabled = false
            b6.isEnabled = false
            b7.isEnabled = false
            b8.isEnabled = false
            b9.isEnabled = false


        }
        private fun playGame(buttonNumber: Int, clickedView: Button) {

            if (activePlayer == 1){
                clickedView.text = "X"
                clickedView.setTextColor(Color.BLACK)
                clickedView.setBackgroundColor(Color.WHITE)
                activePlayer = 2
                firstPlayer.add(buttonNumber)
                tv.setText("0 Turn")
            }else if (activePlayer == 2){
                clickedView.text = "0"
                clickedView.setTextColor(Color.WHITE)
                clickedView.setBackgroundColor(Color.RED)
                activePlayer = 1
                secondPlayer.add(buttonNumber)
                tv.setText("X Turn")
            }
            clickedView.isEnabled = false
            check()
        }
        private fun check() {

            var winnerPlayer = 0
            Score.text = "$firstPlayerScore : $secondPlayerScore"

            var len1 = firstPlayer.size
            var len2 = secondPlayer.size
            if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
                winnerPlayer = 1
                b1.setBackgroundColor(Color.GREEN)
                b2.setBackgroundColor(Color.GREEN)
                b3.setBackgroundColor(Color.GREEN)
            }
            if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
                winnerPlayer = 2
                b1.setBackgroundColor(Color.GREEN)
                b2.setBackgroundColor(Color.GREEN)
                b3.setBackgroundColor(Color.GREEN)
            }
            if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
                winnerPlayer = 1
                b4.setBackgroundColor(Color.GREEN)
                b5.setBackgroundColor(Color.GREEN)
                b6.setBackgroundColor(Color.GREEN)
            }
            if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
                winnerPlayer = 2
                b4.setBackgroundColor(Color.GREEN)
                b5.setBackgroundColor(Color.GREEN)
                b6.setBackgroundColor(Color.GREEN)
            }
            if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
                winnerPlayer = 1
                b7.setBackgroundColor(Color.GREEN)
                b8.setBackgroundColor(Color.GREEN)
                b9.setBackgroundColor(Color.GREEN)
            }
            if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
                winnerPlayer = 2
                b7.setBackgroundColor(Color.GREEN)
                b8.setBackgroundColor(Color.GREEN)
                b9.setBackgroundColor(Color.GREEN)
            }
            if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
                winnerPlayer = 1
                b1.setBackgroundColor(Color.GREEN)
                b4.setBackgroundColor(Color.GREEN)
                b7.setBackgroundColor(Color.GREEN)
            }
            if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
                winnerPlayer = 2
                b1.setBackgroundColor(Color.GREEN)
                b4.setBackgroundColor(Color.GREEN)
                b7.setBackgroundColor(Color.GREEN)
            }
            if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
                winnerPlayer = 1
                b2.setBackgroundColor(Color.GREEN)
                b5.setBackgroundColor(Color.GREEN)
                b8.setBackgroundColor(Color.GREEN)
            }
            if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
                winnerPlayer = 2
                b2.setBackgroundColor(Color.GREEN)
                b5.setBackgroundColor(Color.GREEN)
                b8.setBackgroundColor(Color.GREEN)
            }
            if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
                winnerPlayer = 1
                b3.setBackgroundColor(Color.GREEN)
                b6.setBackgroundColor(Color.GREEN)
                b9.setBackgroundColor(Color.GREEN)
            }
            if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
                winnerPlayer = 2
                b3.setBackgroundColor(Color.GREEN)
                b6.setBackgroundColor(Color.GREEN)
                b9.setBackgroundColor(Color.GREEN)
            }
            if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
                winnerPlayer = 1
                b1.setBackgroundColor(Color.GREEN)
                b5.setBackgroundColor(Color.GREEN)
                b9.setBackgroundColor(Color.GREEN)
            }
            if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
                winnerPlayer = 2
                b1.setBackgroundColor(Color.GREEN)
                b5.setBackgroundColor(Color.GREEN)
                b9.setBackgroundColor(Color.GREEN)
            }
            if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
                winnerPlayer = 1
                b3.setBackgroundColor(Color.GREEN)
                b5.setBackgroundColor(Color.GREEN)
                b7.setBackgroundColor(Color.GREEN)
            }
            if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
                winnerPlayer = 2
                b3.setBackgroundColor(Color.GREEN)
                b5.setBackgroundColor(Color.GREEN)
                b7.setBackgroundColor(Color.GREEN)
            }
            if (winnerPlayer == 1) {
                tv.setText("გაიმარჯვა პირველმა მოთამაშემ")
                firstPlayerScore += 1




                disabledButtons()
            }
            if (winnerPlayer == 1){
                Toast.makeText(applicationContext, "გაიმარჯვა პირველმა მოთამაშემ", Toast.LENGTH_SHORT).show()



                disabledButtons()


            }
            if (winnerPlayer == 2) {
                tv.setText("გაიმარჯვა მეორე მოთამაშემ")
                secondPlayerScore += 1




                disabledButtons()


            }
            if (winnerPlayer == 2) {
                Toast.makeText(applicationContext, "გაიმარჯვა მეორე მოთამაშემ", Toast.LENGTH_SHORT).show()




                disabledButtons()

            }else if(len1 + len2 == 9 && winnerPlayer != 1 && winnerPlayer !=2 ) {
                Toast.makeText(applicationContext, "ფრე!", Toast.LENGTH_SHORT).show()
                tv.setText("ფრე!")


            }




        }




        fun reset() {
            var winnerPlayer = 0





            b1.text = ""
            b2.text = ""
            b3.text = ""
            b4.text = ""
            b5.text = ""
            b6.text = ""
            b7.text = ""
            b8.text = ""
            b9.text = ""

            b1.isEnabled = true
            b2.isEnabled = true
            b3.isEnabled = true
            b4.isEnabled = true
            b5.isEnabled = true
            b6.isEnabled = true
            b7.isEnabled = true
            b8.isEnabled = true
            b9.isEnabled = true


            b1.setBackgroundColor(Color.BLACK)
            b2.setBackgroundColor(Color.BLACK)
            b3.setBackgroundColor(Color.BLACK)
            b4.setBackgroundColor(Color.BLACK)
            b5.setBackgroundColor(Color.BLACK)
            b6.setBackgroundColor(Color.BLACK)
            b7.setBackgroundColor(Color.BLACK)
            b8.setBackgroundColor(Color.BLACK)
            b9.setBackgroundColor(Color.BLACK)

            tv.setText("X Turn")

            if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
                winnerPlayer = 1

            }
            if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
                winnerPlayer = 2

            }
            if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
                winnerPlayer = 1

            }
            if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
                winnerPlayer = 2

            }
            if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
                winnerPlayer = 1

            }
            if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
                winnerPlayer = 2

            }
            if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
                winnerPlayer = 1

            }
            if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
                winnerPlayer = 2

            }
            if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
                winnerPlayer = 1

            }
            if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
                winnerPlayer = 2

            }
            if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
                winnerPlayer = 1

            }
            if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
                winnerPlayer = 2

            }
            if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
                winnerPlayer = 1

            }
            if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
                winnerPlayer = 2

            }
            if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
                winnerPlayer = 1

            }
            if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
                winnerPlayer = 2

            }


            if (winnerPlayer == 1) {
                tv.setText("X Turn")
                activePlayer = 1

            }

            if (winnerPlayer == 2) {
                activePlayer = 2
                tv.setText("0 Turn")

            }








            firstPlayer.clear()
            secondPlayer.clear()


        }

        fun restart() {
            firstPlayer.clear()
            secondPlayer.clear()
            reset()
            firstPlayerScore = 0
            secondPlayerScore = 0
            Score.text = "0 : 0"
        }
    }





