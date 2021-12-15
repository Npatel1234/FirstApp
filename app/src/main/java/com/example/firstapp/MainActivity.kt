package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TimingLogger
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.auth.AuthUI
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number =  IntRange(0,100).toList()
        IntRange(0,100).toList()

        val goto_profile_button = findViewById<Button>(R.id.main_profile_button)

        goto_profile_button.setOnClickListener {



        }






        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        val signout =findViewById<Button>(R.id.Button)
        signout.setOnClickListener{
            AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener {

                    Toast.makeText(this,"User signinout succesfully!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,LoginActivity::class.java))

                }

        }


        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = MyAdapter(number)





        }



    }



