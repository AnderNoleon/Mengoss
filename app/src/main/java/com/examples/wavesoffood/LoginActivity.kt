package com.examples.wavesoffood

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.wavesoffood.R
import com.example.wavesoffood.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class LoginActivity : AppCompatActivity() {

    private lateinit var email :String
    private lateinit var passwprd :String
    private lateinit var username :String
    private lateinit var auth : FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var googleSignInClint: GoogleSignInClient

    private val binding:ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build()

        // Inilizacion de la base de datos
        auth = Firebase.auth
        // inicio base
        database = FirebaseDatabase.getInstance()

        googleSignInClint = GoogleSignIn.getClient(this,googleSignInOptions)


        // Login y la contrasena
        binding.loginbutton.setOnClickListener {
            // toma los datos del texto

            email = binding.EmailAddress.text.toString().trim()
            passwprd = binding.Password.text.toString().trim()

            if(email.isBlank() || passwprd.isBlank()){
                Toast.makeText(this,"Por favor ingrese todos los datos",Toast.LENGTH_SHORT).show()

            }else{
                createUser()
                Toast.makeText(this,"Ingresado Feliz",Toast.LENGTH_SHORT).show()

            }

            val intent = Intent(this,SignActivity::class.java)
            startActivity(intent)
        }
        binding.donthavebutton.setOnClickListener {
            val intent = Intent(this,SignActivity::class.java)
            startActivity(intent)
        }

    }

    private fun createUser() {

        auth.signInWithEmailAndPassword(email,passwprd).addOnCompleteListener { task ->
            if(task.isSuccessful){
                val user = auth.currentUser
                updateUi(user)
            }else{
                auth.createUserWithEmailAndPassword(email,passwprd).addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        val user = auth.currentUser
                        updateUi(user)
                    }else
                    {
                        Toast.makeText(this,"ENTRADA FALLIDA",Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }

    private fun updateUi(user: FirebaseUser?) {
        val intent = Intent(this,SignActivity::class.java)
        startActivity(intent)
        finish()
    }
}