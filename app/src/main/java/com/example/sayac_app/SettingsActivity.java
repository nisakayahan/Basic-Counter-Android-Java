package com.example.sayac_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    Button upperlimit_plus,upperlimit_minus,downlimit_plus,downlimit_minus;
   // CheckBox ses_ust,ses_alt,titresim_alt,titresim_ust;
    TextView text_alt,text_ust;
    SettingClass settingClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        upperlimit_plus= findViewById(R.id.upperlimit_plus);
        upperlimit_minus= findViewById(R.id.upperlimit_minus);
        downlimit_plus= findViewById(R.id.downlimit_plus);
        downlimit_minus= findViewById(R.id.downlimit_minus);
        text_alt= findViewById(R.id.text_alt);
        text_ust= findViewById(R.id.text_ust);

        settingClass = SettingClass.getSettingClass(getApplicationContext());

        upperlimit_plus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                settingClass.upperLimit++;
                text_ust.setText(String.valueOf(settingClass.upperLimit));
            }
        });
        upperlimit_minus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                settingClass.upperLimit--;
                text_ust.setText(String.valueOf(settingClass.upperLimit));
            }
        });
        downlimit_plus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                settingClass.lowerLimit++;
                text_alt.setText(String.valueOf(settingClass.lowerLimit));
            }
        });
        downlimit_minus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                settingClass.lowerLimit--;
                text_alt.setText(String.valueOf(settingClass.lowerLimit));
            }
        });

        text_ust.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(text_ust.getText().toString().length()!=0){
                    settingClass.upperLimit= Integer.parseInt(text_ust.getText().toString());
                }
            }
        });
        text_alt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(text_alt.getText().toString().length()!=0){
                    settingClass.lowerLimit= Integer.parseInt(text_alt.getText().toString());
                }
            }
        });

    }
    @Override
    public void onResume(){
        super.onResume();
        text_ust.setText(String.valueOf(settingClass.upperLimit));
        text_alt.setText(String.valueOf(settingClass.lowerLimit));
    }
    @Override
    public void onPause(){
        super.onPause();
        settingClass.saveValue();
    }
}