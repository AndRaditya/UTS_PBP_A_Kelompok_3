 package com.example.project_uts_pbp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.project_uts_pbp.databinding.ActivityMainBinding;

import com.example.project_uts_pbp.profilRS;

public class homeAplikasi extends AppCompatActivity {

    ActivityMainBinding binding;
    private ImageButton btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        ActivityMainBinding binding;
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.homeAplikasi);
        binding.setActivity(this);

        btnHome = findViewById(R.id.btnHome);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        // bottomNavigationView.setSelectedItemId(R.id.todolist);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent moveProfil = new Intent(homeAplikasi.this, profilRS.class);
                homeAplikasi.this.startActivity(moveProfil);

            }

        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item){
                    switch(item.getItemId()){
                        case R.id.homeMenu:
                            startActivity(new Intent(homeAplikasi.this, homeAplikasi.class));
                            finish();
                            break;
                        case R.id.profileMenu:
                            startActivity(new Intent(homeAplikasi.this, profilePribadi.class));
                            finish();
                            break;
                    }
                    return true;
                }
            };
}