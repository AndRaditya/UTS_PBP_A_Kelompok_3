package com.example.project_uts_pbp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class emergencyGeolocation extends AppCompatActivity{

    private Button btnLokasiEmergency;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_emergency);

        btnLokasiEmergency = findViewById(R.id.btnLokasiEmergency);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView

        btnLokasiEmergency.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(emergenyGeolocation.this, emergencyLocation.classs));
            }
        });

        BottomNavigationView.OnNavigationItemSelectedListener navListener =
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.homeMenu:
                                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                                    finish();
                                    break;
                                case R.id.profileMenu:
                                    startActivity(new Intent(MainActivity.this, profilePribadi.class));
                                    finish();
                                    break;
                            }
                            return true;
                        }
                    };
//        });
    }

}

