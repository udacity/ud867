package com.udacity.gradle.testingexercise;


import java.util.Date;

public class DeviceInfoGenerator {


    static String getDeviceInfo(){
        return android.os.Build.DEVICE;
    }

    static String getDate(){
        return new Date().toString();
    }
}
