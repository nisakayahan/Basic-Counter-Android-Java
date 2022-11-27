package com.example.sayac_app;

import android.content.Context;
import android.content.SharedPreferences;

public class SettingClass {
    public int upperLimit;
    public int lowerLimit;
    public int lastValue;
    public static SettingClass settingClass=null;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor edit;

    private SettingClass(Context context){
        sharedPreferences =context.getSharedPreferences("setting",Context.MODE_PRIVATE);
        edit = sharedPreferences.edit();
        loadValue();
    }
    public static SettingClass getSettingClass(Context context){
        if(settingClass==null){
            settingClass=new SettingClass(context);
        }
        return settingClass;
    }
    public void saveValue(){
        edit.putInt("upperLimit", upperLimit);
        edit.putInt("lowerLimit", lowerLimit);
        edit.putInt("lastValue", lastValue);
        edit.commit();
    }
    public void loadValue(){
        upperLimit=sharedPreferences.getInt("upperLimit",5);
        lowerLimit=sharedPreferences.getInt("lowerLimit",0);
        lastValue=sharedPreferences.getInt("lastValue",0);
    }

}
