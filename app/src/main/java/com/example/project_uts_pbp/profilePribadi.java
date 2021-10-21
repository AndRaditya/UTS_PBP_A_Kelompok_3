package com.example.project_uts_pbp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project_uts_pbp.preferences.UserPreferences;
import com.example.project_uts_pbp.model.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class profilePribadi extends AppCompatActivity {
    private TextView namaProfile, nomor_telpProfile, emailProfile;
    private Button btnLogout, btnDone;
    private User user;
    private UserPreferences userPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_pribadi);
        setTitle("Profil Anda");

        userPreferences = new UserPreferences(profilePribadi.this);
        namaProfile = findViewById(R.id.namaProfile);
        nomor_telpProfile = findViewById(R.id.nomor_telpProfile);
        emailProfile = findViewById(R.id.emailProfile);
        btnLogout = findViewById(R.id.btnLogoutProfile);
        btnDone = findViewById(R.id.btnDoneProfile);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.profileMenu);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        user = userPreferences.getUserLogin();

        checkLogin();

        if(user.getEmail().equals("arya@gmail.com")){
            namaProfile.setText("Andreas Raditya Aryatama");
            nomor_telpProfile.setText("0812 1234 1234");
            emailProfile.setText(user.getEmail());
        }else if(user.getEmail().equals("jona@gmail.com")){
            namaProfile.setText("Jonathan Kevin Susanto");
            nomor_telpProfile.setText("0812 1234 1234");
            emailProfile.setText(user.getEmail());
        }

        btnLogout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                userPreferences.logout();
                Toast.makeText(profilePribadi.this, "Baiii baiii", Toast.LENGTH_LONG).show();
                checkLogin();
            }
        });

        btnDone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(profilePribadi.this, homeAplikasi.class));
                finish();
            }
        });
    }

    private void checkLogin(){
        if(!userPreferences.checkLogin()){
            startActivity(new Intent(profilePribadi.this, loginActivity.class));
            finish();
        }
        else{
            Toast.makeText(profilePribadi.this, "Heyy kamu sudah login!!", Toast.LENGTH_SHORT).show();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item){
                    switch(item.getItemId()){
                        case R.id.homeMenu:
                            startActivity(new Intent(profilePribadi.this, homeAplikasi.class));
                            finish();
                            break;
                        case R.id.profileMenu:
                            startActivity(new Intent(profilePribadi.this, profilePribadi.class));
                            finish();
                            break;
                    }
                    return true;
                }
            };
}