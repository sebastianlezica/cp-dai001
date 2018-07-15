package com.dai.complements;

import android.content.Intent;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.net.Uri;
import android.os.PowerManager;
import android.content.Context;
import android.os.Build;

public class DaiComplements extends CordovaPlugin {
    public DaiComplements() {}
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            if (action.equals("settings_datetime_open")) {
                cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_DATE_SETTINGS));
                callbackContext.success();
            } else if (action.equals("battery_ignore_optimizations")) {
                /*
                Intent intent = new Intent();
                intent.setAction(android.provider.Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                intent.setData(Uri.parse("package:" + cordova.getActivity().getPackageName()));
                cordova.getActivity().startActivity(intent);
                */
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    Intent intent = new Intent();
                    String packageName = cordova.getActivity().getPackageName();
                    PowerManager pm = (PowerManager)cordova.getActivity().getSystemService(Context.POWER_SERVICE);
                    intent.setAction(android.provider.Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                    intent.setData(Uri.parse("package:" + packageName));
                    /*
                    if (pm.isIgnoringBatteryOptimizations(packageName)) {
                        intent.setAction(android.provider.Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS);
                    } else {
                        intent.setAction(android.provider.Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                        intent.setData(Uri.parse("package:" + packageName));
                    };
                    */
                    cordova.getActivity().startActivity(intent);
                };
                callbackContext.success();
            } else {
                callbackContext.error("Invalid action");
                return false;
            }
        }catch(Exception e ) {
            callbackContext.error("Exception occurred: ".concat(e.getMessage()));
            return false;
        }
        return true;
    }
}
