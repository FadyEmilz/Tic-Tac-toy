package com.example.tic_tac_toy

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.tic_tac_toy.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    var player1= ArrayList<Int>()
    var player2= ArrayList<Int>()
    var Active_player : Int = 1
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.btn1.setOnClickListener{ btnClicked(it) }
        binding.btn2.setOnClickListener{ btnClicked(it) }
        binding.btn3.setOnClickListener{ btnClicked(it) }
        binding.btn4.setOnClickListener{ btnClicked(it) }
        binding.btn5.setOnClickListener{ btnClicked(it) }
        binding.btn6.setOnClickListener{ btnClicked(it) }
        binding.btn7.setOnClickListener{ btnClicked(it) }
        binding.btn8.setOnClickListener{ btnClicked(it) }
        binding.btn9.setOnClickListener{ btnClicked(it) }


    }

    private fun btnClicked (view : View){
        var  btn_select = view as Button
        var cellnum =0
        when(view.id){
            binding.btn1.id -> cellnum=1
            binding.btn2.id -> cellnum=2
            binding.btn3.id -> cellnum=3
            binding.btn4.id -> cellnum=4
            binding.btn5.id -> cellnum=5
            binding.btn6.id -> cellnum=6
            binding.btn7.id -> cellnum=7
            binding.btn8.id -> cellnum=8
            binding.btn9.id -> cellnum=9
        }

        play_game(cellnum, btn_select)

    }
    private fun play_game (cellnum : Int , btn_select : Button){
        if (Active_player == 1){
            btn_select.setText("X")
            btn_select.background = ContextCompat.getDrawable(this,R.drawable.drawable_x)
            player1.add(cellnum)
            Active_player=2

        }
        else{
            btn_select.setText("O")
            btn_select.background = ContextCompat.getDrawable(this,R.drawable.desine_o)
            player2.add(cellnum)
            Active_player=1

        }
        btn_select.isEnabled = false
        check_winner()
        check_draw()


    }
    private fun check_winner(){
        var winner = -1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) winner = 1
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) winner = 2

        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) winner = 1
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) winner = 2

        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) winner = 1
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) winner = 2



        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) winner = 1
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) winner = 2


        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) winner = 1
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) winner = 2

        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) winner = 1
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) winner = 2



        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) winner = 1
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) winner = 2

        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) winner = 1
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) winner = 2


        if(winner == 1){
        val intent = Intent(this,WinnerActivity::class.java)
            WinnerActivity.winner_txt = "Player 1 is the winner"
            startActivity(intent)

        }
        else if (winner == 2){
            val intent = Intent(this,WinnerActivity::class.java)
            WinnerActivity.winner_txt = "Player 2 is the winner"
            startActivity(intent)

        }


    }
    private fun check_draw(){
        if(binding.btn1.isEnabled==false&&binding.btn2.isEnabled==false&&binding.btn3.isEnabled==false){
            if(binding.btn4.isEnabled==false&&binding.btn5.isEnabled==false&&binding.btn6.isEnabled==false){
                if(binding.btn7.isEnabled==false&&binding.btn8.isEnabled==false&&binding.btn9.isEnabled==false){
                    val intent = Intent(this,MainActivity2::class.java)
                    startActivity(intent)

                }
            }

        }



    }

}