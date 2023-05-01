package com.example.tic_tac_toy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tic_tac_toy.databinding.ActivityMainBinding
import com.example.tic_tac_toy.databinding.ActivityWinnerBinding

lateinit var binding: ActivityWinnerBinding
class WinnerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_winner)
        binding.winnerText.setText(winner_txt)
        binding.againBtn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)


        }
    }




    companion object{
        var winner_txt : String = ""

    }
}