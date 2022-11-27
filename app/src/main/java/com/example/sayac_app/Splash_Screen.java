package com.example.sayac_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

public class Splash_Screen extends AppCompatActivity {


    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

      handler.postDelayed(new Runnable() {
          @RequiresApi(api = Build.VERSION_CODES.S)
          @Override
          public void run() {
              Intent intent = new Intent(Splash_Screen.this, MainActivity.class);
              startActivity(intent);
              finish();
          }
      },2000);

    }
}