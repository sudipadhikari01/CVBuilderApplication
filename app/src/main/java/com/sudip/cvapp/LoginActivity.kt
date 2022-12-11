package com.sudip.cvapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.sudip.cvapp.constants.ConstantEnum



class LoginActivity : AppCompatActivity(), OnClickListener {

    private lateinit var emailEditTxt: EditText
    private lateinit var passwordEditTxt: EditText
    private lateinit var loginBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        val sharedPreference = getSharedPreferences(ConstantEnum.SHARED_PREF_NAME.value, 0)
        if (sharedPreference.getBoolean(ConstantEnum.IS_LOGGED_IN.value, false)) {
            openMainActivity()
        } else {
            initSharedPreference()
        }

        emailEditTxt = findViewById(R.id.email_edit_text)
        passwordEditTxt = findViewById(R.id.password_edit_text)
        loginBtn = findViewById(R.id.login_button)

        loginBtn.setOnClickListener(this)

    }

    private fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun initSharedPreference() {
        val sharedPref = getSharedPreferences(ConstantEnum.SHARED_PREF_NAME.value, 0)
        val editor = sharedPref.edit()
        editor.putString(ConstantEnum.USER_EMAIL.value, "sudip@miu.edu")
        editor.putString(ConstantEnum.USER_PASSWORD.value, "sudip123")
        editor.putString(ConstantEnum.USER_NAME.value, "Sudip Adhikari")
        editor.putBoolean(ConstantEnum.IS_LOGGED_IN.value, false)
        editor.apply()
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.login_button -> {
                if (validateFields()) {
                    if (validateAuthorization()) {

                        val sharedPref =
                            getSharedPreferences(ConstantEnum.SHARED_PREF_NAME.value, 0)
                        val editor = sharedPref.edit()
                        editor.putBoolean(ConstantEnum.IS_LOGGED_IN.value, true)
                        editor.apply()

                        openMainActivity()

                    } else {
                        Toast.makeText(this, "Email or Password did not match!", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }
    }

    private fun validateAuthorization(): Boolean {
        val sharedPreference = getSharedPreferences(ConstantEnum.SHARED_PREF_NAME.value, 0)
        val email = sharedPreference.getString(ConstantEnum.USER_EMAIL.value, "")
        val password = sharedPreference.getString(ConstantEnum.USER_PASSWORD.value, "")
        Log.v("LoginActivity", "$email : $password")
        if (emailEditTxt.text.toString().trim() != email || passwordEditTxt.text.toString()
                .trim() != password
        ) {
            return false
        }
        return true
    }

    private fun validateFields(): Boolean {
        if (emailEditTxt.text.isEmpty()) {
            emailEditTxt.error = "Email can not be blank"
            emailEditTxt.requestFocus()
            return false
        } else if (passwordEditTxt.text.isEmpty()) {
            passwordEditTxt.error = "Password can not be blank"
            passwordEditTxt.requestFocus()
            return false;
        }

        return true
    }

}