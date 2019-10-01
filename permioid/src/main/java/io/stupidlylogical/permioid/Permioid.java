package io.stupidlylogical.permioid;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class Permioid extends AppCompatActivity {

    private Context context;
    private String[] permissions = {};
    private String NAV_TO_SETTINGS_DIALOG_TITLE = "Alert!";
    private String NAV_TO_SETTINGS_DIALOG_TEXT = "Go to settings to allow required permissions";
    private String REQUEST_DIALOG_TITLE = "Warning!";
    private String REQUEST_DIALOG_TEXT = "All permissions are necessary";

    public Permioid() { }

    public Permioid(Context context, String[] permissions, String NAV_TO_SETTINGS_DIALOG_TITLE, String NAV_TO_SETTINGS_DIALOG_TEXT, String REQUEST_DIALOG_TITLE, String REQUEST_DIALOG_TEXT) {
        this.context = context;
        this.permissions = permissions;
        this.NAV_TO_SETTINGS_DIALOG_TITLE = NAV_TO_SETTINGS_DIALOG_TITLE;
        this.NAV_TO_SETTINGS_DIALOG_TEXT = NAV_TO_SETTINGS_DIALOG_TEXT;
        this.REQUEST_DIALOG_TITLE = REQUEST_DIALOG_TITLE;
        this.REQUEST_DIALOG_TEXT = REQUEST_DIALOG_TEXT;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String[] getPermissions() {
        return permissions;
    }

    public void setPermissions(String[] permissions) {
        this.permissions = permissions;
    }

    public String getNAV_TO_SETTINGS_DIALOG_TITLE() {
        return NAV_TO_SETTINGS_DIALOG_TITLE;
    }

    public void setNAV_TO_SETTINGS_DIALOG_TITLE(String NAV_TO_SETTINGS_DIALOG_TITLE) {
        this.NAV_TO_SETTINGS_DIALOG_TITLE = NAV_TO_SETTINGS_DIALOG_TITLE;
    }

    public String getNAV_TO_SETTINGS_DIALOG_TEXT() {
        return NAV_TO_SETTINGS_DIALOG_TEXT;
    }

    public void setNAV_TO_SETTINGS_DIALOG_TEXT(String NAV_TO_SETTINGS_DIALOG_TEXT) {
        this.NAV_TO_SETTINGS_DIALOG_TEXT = NAV_TO_SETTINGS_DIALOG_TEXT;
    }

    public String getREQUEST_DIALOG_TITLE() {
        return REQUEST_DIALOG_TITLE;
    }

    public void setREQUEST_DIALOG_TITLE(String REQUEST_DIALOG_TITLE) {
        this.REQUEST_DIALOG_TITLE = REQUEST_DIALOG_TITLE;
    }

    public String getREQUEST_DIALOG_TEXT() {
        return REQUEST_DIALOG_TEXT;
    }

    public void setREQUEST_DIALOG_TEXT(String REQUEST_DIALOG_TEXT) {
        this.REQUEST_DIALOG_TEXT = REQUEST_DIALOG_TEXT;
    }

    public boolean checkAllPermissions() {
        for (String permission: permissions){
            if (context.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED){
                return false;
            }
        }
        return true;
    }

    public void requestAllPermissions() {
        ActivityCompat.requestPermissions((Activity)context, permissions, 1111);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
