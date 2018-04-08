package cordova.plugins;

import android.content.Intent;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class DaiComplements extends CordovaPlugin {
    public DaiComplements() {}
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            if (action.equals('settings_datetime_open')){
                cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_DATE_SETTINGS));
                callbackContext.success();
            if (action.equals('doze_request')){
                cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_DATE_SETTINGS));
                callbackContext.success();
            } else {
                callbackContext.error('Invalid action');
                return false;
            }
        }catch(Exception e ) {
            callbackContext.error("Exception occurred: ".concat(e.getMessage()));
            return false;
        }
        return true;
    }
}
