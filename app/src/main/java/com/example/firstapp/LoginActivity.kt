package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { res ->
        this.onSignInResult(res)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.PhoneBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build())

        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()
        signInLauncher.launch(signInIntent)


    }

    private fun onSignInResult(res: FirebaseAuthUIAuthenticationResult)
    {
        val result = res.idpResponse
        if(res.resultCode == RESULT_OK)
        {
            if (result!!.isNewUser) {
                val intent = Intent(this, SignupActivity::class.java)
                startActivity(intent)
            }
            else{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "User signed in succesfully!", Toast.LENGTH_SHORT).show()
            }

            val user = FirebaseAuth.getInstance().currentUser
            val intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
            Toast.makeText(this,"User signed in succesfully!", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this,"User signin unsuccesfully!", Toast.LENGTH_SHORT).show()

            Log.e("LoginActivity","Error during login: ${result?.error?.errorCode}")
        }
    }
}