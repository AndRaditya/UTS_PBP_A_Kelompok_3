package com.example.project_uts_pbp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project_uts_pbp.preferences.userPreferences;
import com.google.android.material.button.MaterialButton;

public class loginActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private MaterialButton btnLoginKeRegister, btnLogin;
    private com.example.project_uts_pbp.preferences.userPreferences userPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        userPreferences = new userPreferences(loginActivity.this);

        etUsername = findViewById(R.id.loginEmail);
        etPassword = findViewById(R.id.loginPassword);

        btnLogin = findViewById(R.id.btnLogin);
        btnLoginKeRegister = findViewById(R.id.btnLoginKeRegister);

        checkLogin();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateForm()) {
                    if(etUsername.getText().toString().trim().equals("190710144")
                            && etPassword.getText().toString().trim().equals("arya")){
                        userPreferences.setLogin(etUsername.getText().toString().trim(), etPassword.getText().toString().trim());
                        checkLogin();
                    }else{
                        Toast.makeText(loginActivity.this, "Username atau Password Salah", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        btnLoginKeRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginActivity.this, registerActivity.class));
            }
        });
    }

    private boolean validateForm(){
        if(etUsername.getText().toString().trim().isEmpty() || etPassword.getText().toString().trim().isEmpty()){
            Toast.makeText(loginActivity.this, "Username atau password kosong", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    private void checkLogin(){
        if(userPreferences.checkLogin()){
            startActivity(new Intent(loginActivity.this, MainActivity.class));
            finish();
        }
    }
}
