package com.example.sayac_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    Button button_arti, button_eksi,button_settings;
    TextView count_text;
    SettingClass settingClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_arti = findViewById(R.id.button_arti);
        button_eksi = findViewById(R.id.button_eksi);
        count_text = findViewById(R.id.count_text);
        button_settings = findViewById(R.id.button_settings);

        Context context = getApplicationContext();
        settingClass = SettingClass.getSettingClass(context);

        button_arti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                count++;
//                count_text.setText(Integer.toString(count));
                changeValue(1);
            }
        });
        button_eksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                count--;
//                count_text.setText(Integer.toString(count));
                changeValue(-1);
            }

        });
        button_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
               // finish();
            }
        });

    }
    public void changeValue(int step){
        if (step > 0) {
            if (settingClass.lastValue + step > settingClass.upperLimit) {
                settingClass.lastValue = settingClass.upperLimit;
            } else {
                settingClass.lastValue += step;
            }
        }
        if (step < 0) {
            if (settingClass.lastValue + step < settingClass.lowerLimit) {
                settingClass.lastValue = settingClass.lowerLimit;
            } else {
                settingClass.lastValue += step;
            }
        }
        count_text.setText(String.valueOf(settingClass.lastValue));
    }
    protected void onResume() {
        super.onResume();
        count_text.setText(String.valueOf(settingClass.lastValue));
    }
    protected void onPause() {
        super.onPause();
        settingClass.saveValue();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        TextView count_text = (TextView) findViewById(R.id.count_text);
        int action = event.getAction();
        int key = event.getKeyCode();
        switch (key) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_UP) {
                    count+=5;
                    count_text.setText(Integer.toString(count));
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    count-=5;
                    count_text.setText(Integer.toString(count));
                }
                return true;
        }
        return super.dispatchKeyEvent(event);
    }
}