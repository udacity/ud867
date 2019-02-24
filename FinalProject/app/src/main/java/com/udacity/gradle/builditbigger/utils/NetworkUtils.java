package com.udacity.gradle.builditbigger.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkUtils {

    private static final String TAG = NetworkUtils.class.getName();

    /**
     * Method to verify connection of device
     * @param context application
     * @return true if internet is available
     */
    public static boolean checkInternetConnection(Context context){
        boolean isConnected;
        NetworkInfo activeNetwork = null;
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if(cm != null){
            activeNetwork = cm.getActiveNetworkInfo();
        }
        isConnected = activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();
        Log.d(TAG, "checkInternetConnection: " + isConnected);
        return isConnected;
    }
}
