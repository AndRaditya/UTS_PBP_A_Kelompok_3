package com.example.project_uts_pbp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class profilRS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profilrs);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        // bottomNavigationView.setSelectedItemId(R.id.homeMenu);
       bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item){
                    switch(item.getItemId()){
                        case R.id.homeMenu:
                            startActivity(new Intent(profilRS.this, homeAplikasi.class));
                            finish();
                            break;
                        case R.id.profileMenu:
                            startActivity(new Intent(profilRS.this, profilePribadi.class));
                            finish();
                            break;
                    }
                    return true;
                }
            };
}
