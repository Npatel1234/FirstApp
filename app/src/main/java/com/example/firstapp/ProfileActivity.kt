package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val name_edit= findViewById<EditText>(R.id.editText)
        val email_edt  = findViewById<EditText>(R.id.editText2)
        val submit_button = findViewById<Button>(R.id.profile_submit_button)
        val pbar = findViewById<ProgressBar>(R.id.profile_progressbar)

        val databaseref= Firebase.database.getReference("Users/${FirebaseAuth.getInstance().uid}")

        databaseref.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                name_edit.setText(snapshot.child("name").toString())
                email_edt.setText(snapshot.child("email").toString())
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("ProfileActivity", "Firebase database error $error")
            }


        })


        submit_button.setOnClickListener {

            updateuserinfo(name_edit.text.toString(),email_edt.text.toString())

        }



    }

    private fun updateuserinfo(name: String,email: String?) {

        val database = Firebase.database.reference

        val user = User(name,email)



    }
}