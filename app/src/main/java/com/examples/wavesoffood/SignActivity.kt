package com.examples.wavesoffood
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.wavesoffood.R
import com.example.wavesoffood.databinding.ActivitySignBinding
import com.examples.wavesoffood.model.UserModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthCredential
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

@Suppress("NAME_SHADOWING")
class SignActivity : AppCompatActivity() {

    private lateinit var email :String
    private lateinit var passwprd :String
    private lateinit var username :String
    private lateinit var auth : FirebaseAuth
    private lateinit var database: DatabaseReference
    private lateinit var googleSignInClint: GoogleSignInClient


    private val binding : ActivitySignBinding by lazy {
        ActivitySignBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build()


        // initiliza Firebase auth
        auth = Firebase.auth
        // inicio base
        database = Firebase.database.reference
        // base

        googleSignInClint = GoogleSignIn.getClient(this,googleSignInOptions)


        binding.createAccountButton.setOnClickListener {
            username = binding.userName.text.toString()
            email = binding.EmailAddress.text.toString().trim()
            passwprd = binding.password.text.toString().trim()

            if(email.isEmpty() || passwprd.isBlank() || username.isBlank()){
                Toast.makeText(this,"Por favor todos los detalles", Toast.LENGTH_SHORT).show()
            }else{
                createAccount(email,passwprd)
            }
        }

        binding.arhbutton.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        binding.googleButton.setOnClickListener {
            val singIntent = googleSignInClint.signInIntent
            launcher.launch(singIntent)
        }
    }


    // launcher gor google sing
    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
    if (result.resultCode == Activity.RESULT_OK){
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        if (task.isSuccessful){
            val account : GoogleSignInAccount? = task.result
            val credential = GoogleAuthProvider.getCredential(account?.idToken,null)
            auth.signInWithCredential(credential).addOnCompleteListener{ task ->
                if(task.isSuccessful){
                    Toast.makeText(this,"Entrandoo\uD83E\uDEE0",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else{
                    Toast.makeText(this,"shild in fiel",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }else {
        Toast.makeText(this,"shild in fiel",Toast.LENGTH_SHORT).show()
    }

    }

    private fun createAccount(email: String, passwprd: String) {
        auth.createUserWithEmailAndPassword(email,passwprd).addOnCompleteListener {
            task ->
            if(task.isSuccessful){
                Toast.makeText(this,"Cuenta creada", Toast.LENGTH_SHORT).show()
                saveUserData()
                startActivity(Intent(this,LoginActivity::class.java))
                finish()
            }else{
                Toast.makeText(this,"Creacion fallida",Toast.LENGTH_SHORT).show()
                Log.d("Cuenta","Creacion Cuenta: Failure",task.exception)
            }
        }
    }

    private fun saveUserData() {
        username = binding.userName.text.toString()
        email = binding.EmailAddress.text.toString().trim()
        passwprd = binding.password.text.toString().trim()

        val user = UserModel(username,email,passwprd)
        val userId = FirebaseAuth.getInstance().currentUser!!.uid
        // Guarda la base de datos
        database.child("user").child(userId).setValue(user)
    }
}