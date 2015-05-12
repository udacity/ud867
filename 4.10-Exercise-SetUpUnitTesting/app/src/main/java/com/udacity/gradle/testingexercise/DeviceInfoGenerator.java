package com.udacity.gradle.testingexercise;


import android.os.Build;

import java.util.Date;

public class DeviceInfoGenerator {

    public static String getDeviceInfo(){
        return Build.MODEL;
    }

    public static String getDate(){
        return new Date().toString();
    }
}
