package com.example.project_uts_pbp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class notificationReceiver extends BroadcastReceiver{
        public void onReceive(Context context, Intent intent) {
                String message = intent.getStringExtra("toastMessage");
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
}