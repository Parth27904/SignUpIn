package com.example.signIn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.signup.R
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()


        val btnSignUp = findViewById<Button>(R.id.btnSignUp)
        val etName = findViewById<EditText>(R.id.etName)
        val etMail = findViewById<EditText>(R.id.etMail)
        val etPass = findViewById<EditText>(R.id.etPass)
        val uniqueId = findViewById<EditText>(R.id.uniqueId)
        val til_name = findViewById<TextInputLayout>(R.id.til_name)


        btnSignUp.setOnClickListener {
            val name = etName.text.toString()
            val mail = etMail.text.toString()
            val password = etPass.text.toString()
            val uniqueid = uniqueId.text.toString()


            if (name.isBlank()){
                til_name.helperText = "*required"
            }
            else if(mail.isBlank() || password.isBlank() || uniqueid.isBlank()){
                Toast.makeText(this, "All fields are mandatory!", Toast.LENGTH_SHORT).show()
            }
            else {
                val user = User(name, mail, uniqueid, password)
                database = FirebaseDatabase.getInstance().getReference("Users")
                database.child(uniqueid).setValue(user).addOnSuccessListener {
                    etName.text?.clear()
                    etMail.text?.clear()
                    etPass.text?.clear()
                    uniqueId.text?.clear()
                    Toast.makeText(this, "User registered successfully", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}