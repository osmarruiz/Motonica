package com.example.motonica

import android.content.Context
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.motonica.network.LoginRequest
import com.example.motonica.network.LoginResponse
import com.example.motonica.network.RetrofitInstance
import com.example.motonica.util.TokenManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonRegistrar: Button = findViewById(R.id.button_registrarse)
        val buttonLogin: Button = findViewById(R.id.button_login)
        val usernameEditText: EditText = findViewById(R.id.edit_text_email)
        val passwordEditText: EditText = findViewById(R.id.edit_text_password)

        buttonRegistrar.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        buttonLogin.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            login(username, password)
        }
    }
    private fun login(username: String, password: String) {
        val loginService = RetrofitInstance.loginService
        val loginRequest = LoginRequest(username, password)

        loginService.login(loginRequest).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse != null) {
                        TokenManager.setToken(this@LoginActivity, loginResponse.token)

                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                } else { 
                    Toast.makeText(this@LoginActivity, "Login failed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(this@LoginActivity, "An error occurred: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }



}