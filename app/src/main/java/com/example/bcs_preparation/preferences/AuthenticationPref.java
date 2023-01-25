package com.example.bcs_preparation.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.bcs_preparation.utils.ConstantUtils;

public class AuthenticationPref {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public AuthenticationPref(Context context) {
        sharedPreferences = context.getSharedPreferences(ConstantUtils.AuthPreference.FILE_NAME,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public boolean getLoginStatus(){
        return sharedPreferences.getBoolean(ConstantUtils.AuthPreference.STATUS_KEY,false);
    }

    public String getAccessToken(){
        return sharedPreferences.getString(ConstantUtils.AuthPreference.TOKEN_NAME,"");
    }

    public Integer getUserID(){
        return sharedPreferences.getInt(ConstantUtils.AuthPreference.LOGIN_USER,0);
    }

    public void setLoginStatus(boolean status){
        editor.putBoolean(ConstantUtils.AuthPreference.STATUS_KEY,status);
        editor.commit();
    }

    public void setAccessToken(String token){
        editor.putString(ConstantUtils.AuthPreference.TOKEN_NAME,token);
        editor.commit();
    }

    public void setUserID(int id){
        editor.putInt(ConstantUtils.AuthPreference.LOGIN_USER,id);
        editor.commit();
    }


}
