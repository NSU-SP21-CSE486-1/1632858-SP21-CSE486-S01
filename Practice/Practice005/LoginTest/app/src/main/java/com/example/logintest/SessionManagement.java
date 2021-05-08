package com.example.logintest;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManagement {
//    SharedPreferences sharedPreferences;
//    Context context;
//    private String email;
//    public User(Context context){
//        this.context = context;
//        sharedPreferences = context.getSharedPreferences("userinfo", Context.MODE_PRIVATE);
//
//    }
//
//    public void remove(){
//        sharedPreferences.edit().clear().commit();
//    }
//
//    public String getEmail() {
//        sharedPreferences.getString("userData","");
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//        sharedPreferences.edit().putString("userData", email).commit();
//    }

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SHARED_PREF_NAME = "session";
    String SESSION_KEY = "session_key";

    public SessionManagement(Context context){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveSession(User user){
        //save session of user whenever user is logged in
        String email = user.getEmail();
        editor.putString(SESSION_KEY,email).commit();
    }

    public String getSession(){
        //return user whose session is saved
        return sharedPreferences.getString(SESSION_KEY,"");
    }

    public void removeSession(){
        editor.putString(SESSION_KEY,"").commit();
    }
}
