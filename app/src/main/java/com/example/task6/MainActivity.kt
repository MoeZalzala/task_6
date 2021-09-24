package com.example.task6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    private val topFragment = TopFragment()
    private val bottomFragment = BottomFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragments()

    }

    private fun initFragments() {
       val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.bottomFragmentContainer, bottomFragment)
        transaction.add(R.id.topFragmentContainer, topFragment)
        transaction.commit()
    }




}