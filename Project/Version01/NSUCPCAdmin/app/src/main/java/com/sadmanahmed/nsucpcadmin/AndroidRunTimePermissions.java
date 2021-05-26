package com.sadmanahmed.nsucpcadmin;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class AndroidRunTimePermissions {
    private WeakReference<Activity> activity;

    public AndroidRunTimePermissions() {
    }

    public AndroidRunTimePermissions(WeakReference<Activity> activity) {
        this.activity = activity;
    }

    public void checkForPermissions(){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) return;
        if(isAllNecessaryPermissionGranted()) return;
        requestForPermissions();
    }
    @TargetApi(Build.VERSION_CODES.M)
    private void requestForPermissions(){
        activity.get().requestPermissions(getAllPermissions().toArray(new String[0]),0);
    }

    private boolean isAllNecessaryPermissionGranted() {
        List<String> permissions = getAllPermissions();
        for(String permission : permissions){
            if(activity.get().checkCallingOrSelfPermission(permission) != PackageManager.PERMISSION_GRANTED)
                return false;
        }
        return true;
    }

    // asking user for permission
    private List<String> getAllPermissions(){
        List<String> permissions = new ArrayList<>();
        permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return permissions;
    }
}