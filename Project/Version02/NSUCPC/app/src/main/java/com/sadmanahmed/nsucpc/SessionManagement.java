package com.sadmanahmed.nsucpc;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManagement {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SHARED_PREF_NAME = "session";
    String SESSION_KEY = "session_key";


    public SessionManagement(Context context){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveSession(UserSession userSession){
        //save session whenever a user is logged in
        String email = userSession.getEmail();

        editor.putString(SESSION_KEY,email).commit();


    }

    public String getSession(){
        //return whose session is saved
        return sharedPreferences.getString(SESSION_KEY,"");
    }

    public void removeSession(){
        //remove the current session
        editor.putString(SESSION_KEY,"").commit();
    }

}
